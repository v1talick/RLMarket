package com.exercise.RLMarket.services.impl;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.enteties.Item;
import com.exercise.RLMarket.enteties.enums.ItemType;
import com.exercise.RLMarket.mappers.ItemMapper;
import com.exercise.RLMarket.repositories.ItemRepository;
import com.exercise.RLMarket.services.ItemService;
import com.exercise.scpecifications.ItemSpecs;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    ItemRepository itemRepository;

    @Override
    public List<ItemDTO> getItems() {
        return itemRepository.findAll().stream().map(ItemMapper::itemToItemDTO).toList();
    }

    @Override
    public List<ItemDTO> getItems(Optional<String> itemType, Optional<String> longLabel,
                                  Optional<String> qualityId) {
        Optional<ItemType> itemType1 = !itemType.get().equals("") ? Optional.of(ItemType.valueOf(itemType.get()))   : Optional.empty();
        Optional<String> longLabel1 = !itemType.get().equals("") ? Optional.of((longLabel.get()))   : Optional.empty();
        Optional<Integer> qualityId1 = !itemType.get().equals("") ? Optional.of(Integer.valueOf(qualityId.get()))   : Optional.empty();
        return itemRepository.findAll(ItemSpecs.generalSpecification(itemType1, longLabel1, qualityId1))
                .stream().map(ItemMapper::itemToItemDTO).toList();
    }

    @Override
    public ItemDTO getItem(int id) {
        return ItemMapper.itemToItemDTO(itemRepository.findById(id).get());
//        Item item = itemRepository.findById(id)
//                .orElseThrow(() -> new ItemNotFoundException(id));
//        return ItemMapper.itemToItemDTO(item);
    }

    @Override
    public List<ItemDTO> getItemsByType(ItemType itemType) {
        return itemRepository.findItemsByType(itemType).stream().map(ItemMapper::itemToItemDTO).toList();
    }
}
