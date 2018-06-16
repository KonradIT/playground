package com.chernowii.retrofitexample;

import com.chernowii.retrofitexample.ApiSections.PebbleApp;
import com.chernowii.retrofitexample.ApiSections.PebbleList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface APIInterface {

    @GET("/api?type=watchapp&limit=20&category=5261a8fb3b773043d5000008")
    Call<PebbleList> CategoryRemotes();

    @GET("/api?type=watchapp&limit=20&category=5261a8fb3b773043d500000c")
    Call<PebbleList> CategoryDaily();

    @GET("/api?type=watchapp&limit=20&category=5261a8fb3b773043d5000001")
    Call<PebbleList> CategoryNotification();

    @GET("/api?type=watchapp&limit=20&category=5261a8fb3b773043d500000f")
    Call<PebbleList> CategoryTools();

    @GET("/api?type=watchapp&limit=20&category=5261a8fb3b773043d5000004")
    Call<PebbleList> CategoryHealth();

    @GET("/api?type=watchapp&limit=20&category5261a8fb3b773043d5000012")
    Call<PebbleList> CategoryGames();

    @GET("/api/?limit=20")
    Call<PebbleList> getAppDetail(@Query("appID") String AppId);

    @GET("/api/?limit=20")
    Call<PebbleApp> searchApp(@Query("search") String AppText);

}
