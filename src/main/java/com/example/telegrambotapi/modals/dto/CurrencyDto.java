package com.example.telegrambotapi.modals.dto;

import com.example.telegrambotapi.modals.enums.Currencies;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {

    private Long id;
    private Date date;
    private Boolean historical;
    private Double amount;
    private Currencies fromCurrencies;
    private Currencies toCurrencies;
    private Double result;
    private Boolean success;
    private Double quote;
}
