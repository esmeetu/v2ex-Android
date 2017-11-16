package com.firefly.v2ex.net;

import com.firefly.v2ex.bean.GankBean;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by jason on 9/17/17.
 */

public class IApi {

    public static final String API_ADDR = "http://gank.io/api/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_ADDR)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public interface GankApi{
        @GET("data/Android/10/1")
        Call<GankBean> getList();
    }

    public static GankApi getGankApi() {
        return retrofit.create(GankApi.class);
    }

}
