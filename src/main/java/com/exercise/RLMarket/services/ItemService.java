package com.exercise.RLMarket.services;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.enteties.enums.ItemType;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<ItemDTO> getItems();
    List<ItemDTO> getItems(Optional<String> itemType, Optional<String> longLabel,
                           Optional<String> qualityId);

    ItemDTO getItem(int id);

    List<ItemDTO> getItemsByType(ItemType itemType);
}
