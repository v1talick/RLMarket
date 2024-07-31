package com.exercise.RLMarket.DTOs.creationDTOs;

import com.exercise.RLMarket.DTOs.ItemDTO;
import com.exercise.RLMarket.enteties.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class TradeItemCreationDTO {
    int trade;
    ItemDTO item;
    int amount;
}
