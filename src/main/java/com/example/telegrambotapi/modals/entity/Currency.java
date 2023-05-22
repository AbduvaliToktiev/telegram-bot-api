package com.example.telegrambotapi.modals.entity;

import com.example.telegrambotapi.modals.enums.Currencies;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "historical")
    private Boolean historical;

    @Column(name = "amount")
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "fromm")
    private Currencies fromCurrencies;

    @Enumerated(EnumType.STRING)
    @Column(name = "too")
    private Currencies toCurrencies;

    @Column(name = "result")
    private Double result;

    @Column(name = "success")
    private Boolean success;

    @Column(name = "quote")
    private Double quote;
}
