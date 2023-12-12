package com.exercise.RLMarket.controllers;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.DTOs.TradeDTO;
import com.exercise.RLMarket.services.ItemService;
import com.exercise.RLMarket.services.TradeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class TradeController {
    @Autowired
    TradeService tradeService;
    @Autowired
    ItemService itemService;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/trading")
    public String createTradeOffer(Model model) {
        model.addAttribute("trade", new TradeDTO());
        model.addAttribute("trades", tradeService.getAllTrades());
        model.addAttribute("items", itemService.getItems());

        return "trades";
    }

//    @GetMapping("/trading")
//    public String createTradeOffer(
//            Model model,
//            @AuthenticationPrincipal UserDetails userDetails,
//            @RequestParam(name = "itemTypeFilter", required = false) String itemTypeFilter
//    ) {
//        Long userId = userService.getUserIdByUsername(userDetails.getUsername());
//
//        // Retrieve trades related to the authenticated user
//        List<TradeDTO> userTrades = tradeService.getTradesByUserId(userId);
//
//        // Apply the itemType filter if it is provided in the URL
//        if (StringUtils.isNotBlank(itemTypeFilter)) {
//            userTrades = userTrades.stream()
//                    .filter(trade -> trade.getGiveItem().getItemType().equals(itemTypeFilter))
//                    .collect(Collectors.toList());
//        }
//
//        model.addAttribute("trade", new TradeDTO());
//        model.addAttribute("trades", userTrades);
//        model.addAttribute("items", itemService.getItems());
//
//        // Add available item types for the filter form
//        List<String> itemTypes = itemService.getDistinctItemTypes();
//        model.addAttribute("itemTypes", itemTypes);
//
//        return "trades";
//    }


    @PostMapping("/submitTrade")
    public String submitTrade(@ModelAttribute(name = "trade") TradeDTO tradeDTO) {
        tradeService.saveTrade(tradeDTO);

        return "redirect:/";
    }

}
