package com.example.telegrambotapi.repository;

import com.example.telegrambotapi.modals.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
