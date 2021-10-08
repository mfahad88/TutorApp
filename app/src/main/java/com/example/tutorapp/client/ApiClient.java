package com.example.tutorapp.client;

import com.example.tutorapp.interfaces.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    public static final String BASE_URL = "https://insightopsmagento.naheed.pk/"/*"https://www.naheed.pk/"*/;
    public static final String BASE_LIVE = "https://www.naheed.pk/";
    public static final String BASE_URL2 = "https://media.naheed.pk/catalog/";
    //      public static final String BASE_URL = "http://192.168.1.7:8080/";
    private static Retrofit retrofit = null;


    public static synchronized ApiInterface getInstance() {

        if (retrofit==null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .serializeNulls()
                    .setPrettyPrinting()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .validateEagerly(true)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(getRequestHeader())
                    .build();
        }

        return retrofit.create(ApiInterface.class);
    }



    private static OkHttpClient getRequestHeader() {
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Dispatcher dispatcher=new Dispatcher();
        dispatcher.setMaxRequests(20);

        OkHttpClient httpClient = new OkHttpClient.Builder()



                .dispatcher(dispatcher)
                .addInterceptor(interceptor)
                .connectTimeout(40, TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .followRedirects(false)
                .followSslRedirects(false)
                .build();

        return httpClient;
    }



}