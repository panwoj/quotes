package com.wpirog.quotes.controller;

import com.wpirog.quotes.model.Quote;
import com.wpirog.quotes.service.QuoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    private final QuoteService service;

    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @GetMapping("/random")
    public Quote getRandom() {
        return service.getStandardQuote();
    }
    
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
