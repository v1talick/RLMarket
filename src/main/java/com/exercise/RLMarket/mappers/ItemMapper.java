package com.exercise.RLMarket.mappers;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.enteties.Item;

import java.util.Map;

public class ItemMapper {
    public static ItemDTO itemToItemDTO(Item item) {
        Map<Integer,String> slotInterpretation;

        return ItemDTO.builder()
                .id(item.getItemId())
                .itemBlueprint(item.isItemBlueprint())
                .itemPaintable(item.isItemPaintable())
                .itemLongLabel(item.getItemLongLabel())
                .itemType("" + item.getSlotIndex())
                .build();
    }

}
