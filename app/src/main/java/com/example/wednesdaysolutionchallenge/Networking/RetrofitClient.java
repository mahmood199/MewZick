package com.example.wednesdaysolutionchallenge.Networking;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    public final static String TOKEN = "8e8a99861c6044d1aa2c0d650ba2a095";
    private final static String BASE_URL = "https://itunes.apple.com/";


    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public okhttp3.Response intercept(@NotNull Chain chain) throws IOException {

/*                        Request request = chain.request();
                        Request request1 = request.newBuilder().header("X-Auth-Token", TOKEN).build();*/

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
