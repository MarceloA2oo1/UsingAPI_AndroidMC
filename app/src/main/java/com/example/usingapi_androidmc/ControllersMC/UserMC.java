package com.example.usingapi_androidmc.ControllersMC;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserMC {

    public static Retrofit getUserMC(String url){
        Retrofit retrofit = new Retrofit.Builder()
                                    .baseUrl(url)
                                    .addConverterFactory(GsonConverterFactory
                                                                .create()).build();
        return retrofit;
    }
}
