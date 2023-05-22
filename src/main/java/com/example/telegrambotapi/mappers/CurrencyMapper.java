package com.example.telegrambotapi.mappers;

import com.example.telegrambotapi.modals.entity.Currency;
import com.example.telegrambotapi.modals.dto.CurrencyDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CurrencyMapper extends BaseMapper<Currency, CurrencyDto> {

    CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);
}
