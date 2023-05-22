package com.example.telegrambotapi.service.impl;

import com.example.telegrambotapi.mappers.CurrencyMapper;
import com.example.telegrambotapi.modals.dto.CurrencyDto;
import com.example.telegrambotapi.modals.enums.Currencies;
import com.example.telegrambotapi.repository.CurrencyRepository;
import com.example.telegrambotapi.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private CurrencyMapper currencyMapper = CurrencyMapper.INSTANCE;

    @Override
    public CurrencyDto save(CurrencyDto dto) {
        return currencyMapper.toDto(currencyRepository.save(currencyMapper.toEntity(dto)));
    }

    @Override
    public String getCurrencyRates(CurrencyDto currencyDto, String message) throws IOException, ParseException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?to=KZT&from=USD&amount=5")
                .addHeader("apikey", "qFMCvOjKbiP1bqMlT0WbCol5E1eKBonZ")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        return Objects.requireNonNull(response.body()).string();
    }

    private static String getFormatDate(CurrencyDto currencyDto) {
        return new SimpleDateFormat("dd MMM yyyy").format(currencyDto.getDate());
    }
}
