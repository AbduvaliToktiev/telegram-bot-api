package com.example.telegrambotapi.service.impl;

import com.example.telegrambotapi.mappers.CurrencyMapper;
import com.example.telegrambotapi.modals.dto.CurrencyDto;
import com.example.telegrambotapi.modals.enums.Currencies;
import com.example.telegrambotapi.repository.CurrencyRepository;
import com.example.telegrambotapi.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        URL url = new URL("https://api.apilayer.com/currency_data/convert?to=KZT&from=USD&amount=5");
        Scanner scanner = new Scanner((InputStream) url.getContent());
        String result = "";
        while (scanner.hasNext()) {
            result += scanner.nextLine();
        }

        JSONObject object = new JSONObject(result);

        currencyDto.setId(object.getLong("Id"));
        currencyDto.setDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(object.getString("Date")));
        currencyDto.setHistorical(object.getBoolean("historical"));
        currencyDto.setAmount(object.getDouble("amount"));
        currencyDto.setFromCurrencies(object.getEnum(Currencies.class, "from"));
        currencyDto.setToCurrencies(object.getEnum(Currencies.class, "to"));
        currencyDto.setResult(object.getDouble("result"));
        currencyDto.setSuccess(object.getBoolean("success"));

        return "Official rate of KZT to " + currencyDto.getToCurrencies() + "\n" +
                "on the date: " + getFormatDate(currencyDto) + "\n" +
                "is: " + currencyDto.getQuote() + " USD result: " + currencyDto.getResult();
    }

    private static String getFormatDate(CurrencyDto currencyDto) {
        return new SimpleDateFormat("dd MMM yyyy").format(currencyDto.getDate());
    }
}
