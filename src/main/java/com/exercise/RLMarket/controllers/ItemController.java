package com.exercise.RLMarket.controllers;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.enteties.enums.ItemType;
import com.exercise.RLMarket.services.ItemService;
import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Controller
public class ItemController {
    ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public String getItems(@RequestParam(name = "itemType", defaultValue = "") String itemType
            ,@RequestParam(name = "longLabel", defaultValue = "") String longLabel
            ,@RequestParam(name = "quality", defaultValue = "") String quality
            , Model model) {
        List<ItemDTO> result;
        if (!Objects.equals(itemType, "") || !Objects.equals(longLabel, "") || !Objects.equals(quality, "")) {
            // Filter items based on itemType
            result = itemService.getItems(itemType, longLabel, quality);
//            result = itemService.getItemsByType(ItemType.valueOf(itemType.get()));
        } else {
            // If no filter is applied, get all items
            result = itemService.getItems();
        }

        model.addAttribute("items", result);
        return "items";
    }
//
//
    @GetMapping("/item/{id}")
    public String getItem(Model model, @PathVariable int id) {
        model.addAttribute("item", itemService.getItem(id));
        return "item";
//        Pageable
    }
//
//    @GetMapping("/trade")
//    public String createTradeOffer(Model model) {
//        model.addAttribute("allItems", itemService.getItems());
//
//        return "tradeForm";
//    }
}
