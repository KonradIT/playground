package com.chernowii.retrofitexample;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class APIClient {

    private static Retrofit PebbleStoreApi = null;

    static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        PebbleStoreApi = new Retrofit.Builder()
                .baseUrl("https://pebble-appstore.romanport.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return PebbleStoreApi;
    }

}