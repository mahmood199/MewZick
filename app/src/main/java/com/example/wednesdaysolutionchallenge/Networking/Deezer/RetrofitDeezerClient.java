package com.example.wednesdaysolutionchallenge.Networking.Deezer;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDeezerClient {

    public final static String TOKEN = "1501f44659msh50d95ddce9bab16p11eb3fjsn781d9a939e21";
    private final static String BASE_URL = "https://deezerdevs-deezer.p.rapidapi.com/";


    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public okhttp3.Response intercept(@NotNull Chain chain) throws IOException {

                        Request request = chain.request();
                        Request request1 = request.newBuilder()
                                .header("x-rapidapi-key", TOKEN)
                                .header("x-rapidapi-host","deezerdevs-deezer.p.rapidapi.com")
                                .build();

                        return chain.proceed(chain.request());
                    }
                })
                .addInterceptor(httpLoggingInterceptor)
                .build();


        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }

}
