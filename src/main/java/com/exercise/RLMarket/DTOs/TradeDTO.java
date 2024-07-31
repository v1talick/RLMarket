package com.exercise.RLMarket.DTOs;

import com.exercise.RLMarket.enteties.TradeItem;
import lombok.*;

import java.util.Date;
import java.util.List;

@Value
@AllArgsConstructor
public class TradeDTO {
    int tradeId;
    Date date;
    UserDTO userDTO;
    List<TradeItemDTO> giveItems;
    List<TradeItemDTO> getItems;
}
