package com.test.json;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitGet {

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();
}
