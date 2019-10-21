package com.booklisting.android.zomato;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @Headers("user-key:c2582c8abe4da7e745a6aab45b94335a")
    @GET("api/v2.1/cities")
    Call<Post> getSearch(@Query("lat") Double lat,
                                 @Query("lon") Double lon);

}