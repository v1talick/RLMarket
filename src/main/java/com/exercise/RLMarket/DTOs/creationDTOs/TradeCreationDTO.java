package com.exercise.RLMarket.DTOs.creationDTOs;

import com.exercise.RLMarket.DTOs.TradeItemDTO;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Date;
import java.util.List;

@Value
@AllArgsConstructor
public class TradeCreationDTO {
    int tradeId;
    Date date;
    UserCreationDTO user;
    List<TradeItemCreationDTO> giveItems;
    List<TradeItemCreationDTO> getItems;
}
