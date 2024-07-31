package com.exercise.RLMarket.mappers;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.enteties.Item;

public class ItemMapper {
    public static ItemDTO itemToItemDTO(Item item) {
        return new ItemDTO(item.getId(), item.getLongLabel()
                , item.getShortLabel(), item.getType()
                , item.getQuality(), item.getThumbnailAsset()
                , item.isTradeRestriction(), item.isPaintable());
    }
    public static Item itemDTOtoItem(ItemDTO itemDTO) {
        return Item.builder()
                .id(itemDTO.getId())
                .longLabel(itemDTO.getLongLabel())
                .shortLabel(itemDTO.getShortLabel())
                .paintable(itemDTO.isPaintable())
                .quality(itemDTO.getQuality())
                .thumbnailAsset(itemDTO.getThumbnailAsset())
                .tradeRestriction(itemDTO.isTradeRestriction())
                .type(itemDTO.getType())
                .build();
    }
}
