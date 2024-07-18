package com.exercise.RLMarket.utils;

import com.exercise.RLMarket.enteties.enums.ItemType;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class ItemTypeDeserializer extends JsonDeserializer<ItemType> {
    @Override
    public ItemType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        switch (node.intValue()) {
            case 16:
                return ItemType.BANNER;
            case 4:
                return ItemType.ANTENNA;
            case 0:
                return ItemType.BODY;
            case 3:
                return ItemType.BOOST;
            case 20:
                return ItemType.BORDER;
            case 5:
                return ItemType.TOPPER;
            case 7:
                return ItemType.PAINT;
            case 15:
                return ItemType.GOAL_EXPLOSION;
            case 14:
                return ItemType.TRAIL;
            case 2:
                return ItemType.WHEEL;
            case 1:
                return ItemType.DECAL;
            case 18:
                return ItemType.ANTHEM;
            case 13:
                return ItemType.ENGINE_AUDIO;
            case 24:
                return ItemType.ITEM_CONTAINER;
            default:
                return ItemType.SPECIAL;
        }
    }
}
