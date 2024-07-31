package com.exercise.RLMarket.services.impl;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.enteties.enums.ItemType;
import com.exercise.RLMarket.mappers.ItemMapper;
import com.exercise.RLMarket.repositories.ItemRepository;
import com.exercise.RLMarket.services.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    ItemRepository itemRepository;

    @Override
    public List<ItemDTO> getItems() {
        return itemRepository.findAll().stream().map(ItemMapper::itemToItemDTO).toList();
    }

    @Override
    public ItemDTO getItem(int id) {
        return ItemMapper.itemToItemDTO(itemRepository.findById(id).get());
    }

    @Override
    public List<ItemDTO> getItemsByType(ItemType itemType) {
        return itemRepository.findItemsByType(itemType).stream().map(ItemMapper::itemToItemDTO).toList();
    }
}
