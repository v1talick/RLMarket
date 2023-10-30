package com.exercise.RLMarket.mappers;

import com.exercise.RLMarket.DTOs.TradeDTO;
import com.exercise.RLMarket.enteties.TradeOffer;

public class TradeMapper {
    public static TradeDTO tradeOfferToTradeDTO(TradeOffer tradeOffer) {
        return TradeDTO.builder()
                .id(tradeOffer.getTradeId())
                .date(tradeOffer.getDate())
                .giveItem(ItemMapper.itemToItemDTO(tradeOffer.getGiveItem().getItem()))
                .giveAmount(tradeOffer.getGiveItem().getAmount())
                .user(UserMapper.userToUserDTO(tradeOffer.getUser()))
                .build();
    }

    public static TradeOffer tradeDTOToTradeOffer(TradeDTO trade) {
        return TradeOffer.builder()
                .tradeId(trade.getId())
                .date(trade.getDate())
//                .giveItem()
                .build();
    }
}
