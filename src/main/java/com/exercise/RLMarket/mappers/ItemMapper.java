package com.exercise.RLMarket.mappers;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.enteties.Item;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ItemMapper {
    private static final Map<Integer, String> slotsNames = initSlotsNames();

    private static Map<Integer, String> initSlotsNames() {
        Map<Integer, String> slots = new HashMap<>();
        slots.put(16, "Banners");
        slots.put(4, "Antenna");
        slots.put(0, "Bodies");
        slots.put(3, "Boost");
        slots.put(20, "Borders");
        slots.put(5, "Topper");
        slots.put(7, "Paint");
        slots.put(15, "Goal Explosion");
        slots.put(14, "Supersonic Trails");
        slots.put(2, "Wheel");

        return Collections.unmodifiableMap(slots);
    }

    public static ItemDTO itemToItemDTO(Item item) {
        Map<Integer,String> slotInterpretation;
        ItemDTO itemDTO = ItemDTO.builder()
                .id(item.getItemId())
                .itemBlueprint(item.isItemBlueprint())
                .itemPaintable(item.isItemPaintable())
                .itemLongLabel(item.getItemLongLabel())
                .build();

        if(slotsNames.containsKey(item.getSlotIndex())) {
            itemDTO.setItemType(slotsNames.get(item.getSlotIndex()));
        }

        return itemDTO;
    }

    public static String itemImageUrl(ItemDTO item) {
        return "https://github.com/enzanki-ars/rocket-league-item-images/tree/enzanki-ars/Rocket%20League%20Item%20Images/"+item.getItemType()+"/"+item.getItemLongLabel().replace(" ", "%20")+"/Default.png";
    }

}
