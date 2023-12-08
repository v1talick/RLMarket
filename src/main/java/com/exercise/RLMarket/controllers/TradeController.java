package com.exercise.RLMarket.controllers;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.services.TradeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TradeController {
    @Autowired
    TradeService tradeService;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/trading")
    public String createTradeOffer(Model model) {
        model.addAttribute("trades", tradeService.getAllTrades());

        return "trades";
    }

    @PostMapping("/submitItemList")
    public String submitTrade(@ModelAttribute ArrayList<ItemDTO> items) {
        System.out.println(items);

        return "redirect:/";
    }

}
