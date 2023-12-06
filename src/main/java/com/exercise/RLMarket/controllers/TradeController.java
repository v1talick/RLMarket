package com.exercise.RLMarket.controllers;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TradeController {
    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
//    @GetMapping("/trade")
//    public String createTradeOffer(Model model) {
//
//        return "createTradeOffer";
//    }
    @PostMapping("/submitItemList")
    public String submitTrade(@ModelAttribute("items") ArrayList<ItemDTO> items) {
        System.out.println(items);

        return "redirect:/";
    }

}
