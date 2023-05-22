package com.example.telegrambotapi.service;

import com.example.telegrambotapi.modals.dto.CurrencyDto;

import java.io.IOException;
import java.text.ParseException;

public interface CurrencyService {
    CurrencyDto save(CurrencyDto dto);

    String getCurrencyRates(CurrencyDto currencyDto, String message) throws IOException, ParseException;
}
