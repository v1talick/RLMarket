package com.exercise.RLMarket.DTOs;

import lombok.*;

@Value
@AllArgsConstructor
public class TradeItemDTO {
    ItemDTO itemDTO;
    int amount;
}
