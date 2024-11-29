package com.exercise.RLMarket.services.impl;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.enteties.Item;
import com.exercise.RLMarket.enteties.enums.ItemType;
import com.exercise.RLMarket.mappers.ItemMapper;
import com.exercise.RLMarket.repositories.ItemRepository;
import com.exercise.RLMarket.services.ItemService;
import com.exercise.scpecifications.ItemSpecs;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public List<ItemDTO> getItems(String itemType, String longLabel, String quality) {
        Specification<Item> itemSpecification = Specification.where(null);
        if (!Objects.equals(itemType, "")) {
            itemSpecification = itemSpecification.and(ItemSpecs.byItemType(ItemType.valueOf(itemType)));
        }
        if (!Objects.equals(longLabel, "")) {
            itemSpecification = itemSpecification.and(ItemSpecs.byLongLabel(longLabel));
        }
        if (!Objects.equals(quality, "")) {
            itemSpecification = itemSpecification.and(ItemSpecs.byQuality(Integer.parseInt(quality)));
        }
            return itemRepository.findAll(itemSpecification).stream()
                    .map(ItemMapper::itemToItemDTO).toList();
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
