package com.example.retrofit18102021;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private Retrofit retrofit;
    private ApiRequest apiRequest;

    private RetrofitClient(){
        retrofit = createRetrofit();
        apiRequest = retrofit.create(ApiRequest.class);
    }

    public static RetrofitClient instance(){
        if (instance == null){
            instance = new RetrofitClient();
        }
        return  instance;
    }

    public ApiRequest getRequest(){
        return apiRequest;
    }

    private Retrofit createRetrofit(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                .readTimeout(30, TimeUnit.SECONDS)
                                .writeTimeout(30 , TimeUnit.SECONDS)
                                .retryOnConnectionFailure(true)
                                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                                .build();

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
}
