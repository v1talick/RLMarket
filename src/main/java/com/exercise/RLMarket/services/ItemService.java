package com.exercise.RLMarket.services;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.enteties.enums.ItemType;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<ItemDTO> getItems();
    ItemDTO getItem(int id);

    List<ItemDTO> getItemsByType(ItemType itemType);
    List<ItemDTO> getItems(String itemType, String longLabel, String quality);
}
