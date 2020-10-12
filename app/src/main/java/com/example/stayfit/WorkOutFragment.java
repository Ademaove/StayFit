package com.example.stayfit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WorkOutFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorkOutFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_work_out, container, false);
//        setContentView(R.layout.fragment_work_out);
        RecyclerView recyclerView;
        Vector<YouTubeVideos> youtubeVideos = new Vector<YouTubeVideos>();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));
        youtubeVideos.add( new YouTubeVideos("Absolution", "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/k-l-TBlyF80\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("Body Burn","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/RMs8HJ6TB-8\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("Chair Workout","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/g5I2437QqXk\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("Back & Sides","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/p0OFRvuce_Q\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("Booty Builder","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/KnSKrYXUQkI\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("Couch Workout","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/RMs8HJ6TB-8\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("Ballet Legs","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/g5I2437QqXk\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("Arms & Shoulders","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/p0OFRvuce_Q\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("Whole Body","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/KnSKrYXUQkI\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YouTubeVideos("Strength","<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/RMs8HJ6TB-8\" frameborder=\"0\" allowfullscreen></iframe>") );

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);
        return rootView;
    }
}