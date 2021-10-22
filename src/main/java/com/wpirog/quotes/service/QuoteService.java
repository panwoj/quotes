package com.wpirog.quotes.service;

import com.wpirog.quotes.model.Quote;
import com.wpirog.quotes.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class QuoteService {
    private static final int MAX_QUOTES = 25;

    private final Random random = new Random();
    private final QuoteRepository repository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.repository = quoteRepository;
    }

    public Quote getStandardQuote() {
        return repository.findById((long) random.nextInt(MAX_QUOTES) + 1).orElse(null);
    }

    public Quote getQuoteById(String id) {
        if (id == null) {
            return null;
        }
        return repository.findById(Long.valueOf(id)).orElse(null);
    }
}
