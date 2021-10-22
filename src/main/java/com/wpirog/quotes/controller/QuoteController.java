package com.wpirog.quotes.controller;

import com.wpirog.quotes.model.Quote;
import com.wpirog.quotes.service.QuoteService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    private final QuoteService service;

    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @GetMapping("/random")
    public ModelAndView getRandom() {
        var query = service.getStandardQuote();
        ModelAndView mav = new ModelAndView("redirect:/quote");
        mav.addObject("id", query.getId());
        return mav;
    }
    
    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping
    public ModelAndView getQuote(@RequestParam(required = false) String id) {
        var quote = service.getQuoteById(id);
        if (quote == null) {
            quote = service.getStandardQuote();
        }
        return new ModelAndView("index", "quote", quote.getContent());
    }
}
