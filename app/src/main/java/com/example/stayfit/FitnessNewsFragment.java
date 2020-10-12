package com.example.stayfit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.stayfit.api.GetDataService;
import com.example.stayfit.api.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FitnessNewsFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class FitnessNewsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    public FitnessNewsFragment() {
        // Required empty public constructor
    }

    public static final String API_KEY = "b1f0f77f1ed4414ca169864b76443923";

    private List<Article> articles = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private LinearLayoutManager layoutManager;
    private GetDataService getDataService;
    private NestedScrollView nestedScrollView;
    protected Handler handler;
    private String country;
    private boolean isLoading;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fitness_news, container, false);

        getDataService = RetrofitClient.getRetrofitClient().create(GetDataService.class);
        country = Utils.getCountry();
        handler = new Handler();
        isLoading = false;
        nestedScrollView = rootView.findViewById(R.id.nestedScrollView);

        /* To refresh the news feed upon swiping. */
        swipeRefreshLayout = rootView.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent));

        /* Set up the Recycler view.*/
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // As RecyclerView is within the NestedScrollView
        recyclerView.setNestedScrollingEnabled(false);

        onLoadingSwipeRefresh();

//        ContentsAdapter adapter = new ContentsAdapter(getActivity(), types_of_journals);

//        // Set a click listener to play the audio when the list item is clicked on

        return rootView;
    }

    @Override
    public void onRefresh() {
        populateData();
    }
//
    private void onLoadingSwipeRefresh() {
        swipeRefreshLayout.post( FitnessNewsFragment.this::populateData);
    }

    /**
     * Initially loads news articles by making a GET request to the News API.
     */
    public void populateData() {
        swipeRefreshLayout.setRefreshing(true);

        Call<News> call;
        call = getDataService.getNews(country, API_KEY);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                assert response.body() != null;
                if (response.isSuccessful() && response.body().getArticles() != null) {
                    if (!articles.isEmpty()) {
                        articles.clear();
                    }
                    articles = response.body().getArticles().subList(0, 10);

                    adapter = new RecyclerViewAdapter(articles, getActivity());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    initListener();
                    initLoader();
                    swipeRefreshLayout.setRefreshing(false);
                } else {
                    swipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(getActivity(), "Error. No news results!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) { }
        });
    }

    /**
     * Sets an OnItemClickListener to navigate to the individual article pages.
     */
    private void initListener() {
        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

//                Intent intent = new Intent(getActivity(), ArticleActivity.class);

                Article article = articles.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(article.getUrl()));
//                intent.putExtra("url", article.getUrl());
//                intent.putExtra("title", article.getTitle());
//                intent.putExtra("image", article.getUrlToImage());
//                intent.putExtra("date", article.getPublishedAt());
//                intent.putExtra("source", article.getSource().getName());
//                intent.putExtra("author", article.getAuthor());

                FitnessNewsFragment.this.startActivity(intent);
            }
        });
    }

    /**
     * Sets an OnScrollChangedListener() to load additional articles.
     */
    private void initLoader() {
        nestedScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                final View view = nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1);

                int diff = (view.getBottom() - (nestedScrollView.getHeight() + nestedScrollView.getScrollY()));
                if (!isLoading && diff == 0) {
                    isLoading = true;
                    articles.add(null);
                    adapter.notifyItemInserted(articles.size() - 1);

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            final int end = articles.size() + 10;

                            Call<News> call;
                            call = getDataService.getNews(country, API_KEY);
                            call.enqueue(new Callback<News>() {
                                @Override
                                public void onResponse(Call<News> call, Response<News> response) {
                                    assert response.body() != null;
                                    if (response.isSuccessful() && response.body().getArticles() != null) {
                                        articles.remove(articles.size() - 1);
                                        adapter.notifyItemRemoved(articles.size());

                                        articles.clear();
                                        List<Article> responseArticles = response.body().getArticles();
                                        if (end < responseArticles.size()) {
                                            responseArticles = responseArticles.subList(0, end);
                                        }
                                        articles.addAll(responseArticles);
                                        adapter.notifyDataSetChanged();
                                        isLoading = false;
                                    } else {
                                        Toast.makeText(getContext(), "No result", Toast.LENGTH_SHORT).show();
//                                Toast.makeText(, "Error. No news results!", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<News> call, Throwable t) {
                                }
                            });
                        }
                    }, 2000);
                }
            }
        });
    }


}