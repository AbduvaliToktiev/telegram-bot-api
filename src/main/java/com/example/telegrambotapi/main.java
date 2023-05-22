package com.example.telegrambotapi;

import java.io.*;
import java.util.Objects;

import okhttp3.*;

public class main {
    public static void main(String []args) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?to=KZT&from=USD&amount=5")
                .addHeader("apikey", "qFMCvOjKbiP1bqMlT0WbCol5E1eKBonZ")
                .method("GET", null)
            .build();
    Response response = client.newCall(request).execute();
    System.out.println(Objects.requireNonNull(response.body()).string());
}
}
