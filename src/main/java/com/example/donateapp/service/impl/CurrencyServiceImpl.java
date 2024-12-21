package com.example.donateapp.service.impl;

import com.example.donateapp.entity.Currency;
import com.example.donateapp.repository.CurrencyRepository;
import com.example.donateapp.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public Currency findById(Long id) {
        return currencyRepository.findById(id).orElse(null);
    }
}
