package com.example.stayfit.api;

import com.example.stayfit.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {
    /**
     * GET request method to query the News data from /v2/top-headlines endpoint.
     * @param country The 2-letter ISO 3166-1 code of the country we want to get headlines for.
     * @param apiKey API key.
     * @return Nothing.
     */
    @GET("top-headlines")
    Call<News> getNews(@Query("country") String country, @Query("apiKey") String apiKey);
}
