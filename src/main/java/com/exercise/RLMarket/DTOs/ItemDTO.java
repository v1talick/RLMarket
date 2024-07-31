package com.exercise.RLMarket.DTOs;

import com.exercise.RLMarket.enteties.enums.ItemType;
import jakarta.persistence.*;
import lombok.*;

@Value
@AllArgsConstructor
public class ItemDTO {
    int id;
    String longLabel;
    String shortLabel;
    ItemType type;
    int quality;
    String thumbnailAsset;
    boolean tradeRestriction;
    boolean paintable;
}
