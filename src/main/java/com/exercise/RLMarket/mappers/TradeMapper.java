package com.exercise.RLMarket.mappers;

import com.exercise.RLMarket.DTOs.TradeDTO;
import com.exercise.RLMarket.DTOs.TradeItemDTO;
import com.exercise.RLMarket.DTOs.creationDTOs.TradeCreationDTO;
import com.exercise.RLMarket.DTOs.creationDTOs.TradeItemCreationDTO;
import com.exercise.RLMarket.enteties.GetItem;
import com.exercise.RLMarket.enteties.GiveItem;
import com.exercise.RLMarket.enteties.Trade;
import com.exercise.RLMarket.enteties.TradeItem;

public class TradeMapper {
    public static Trade tradeDTOtoTrade(TradeCreationDTO tradeDTO) {
        return Trade.builder()
                .id(tradeDTO.getTradeId())
                .date(tradeDTO.getDate())
                .giveItems(tradeDTO.getGetItems()
                        .stream().map(t -> new GiveItem(TradeMapper.tradeItemCreationDTOtoTradeItem(t))).toList())
                .getItems(tradeDTO.getGetItems()
                        .stream().map(t -> new GetItem(TradeMapper.tradeItemCreationDTOtoTradeItem(t))).toList())
                .user(UserMapper.userCreationDTOtoUser(tradeDTO.getUser()))
                .build();
    }

    public static TradeDTO tradeToTradeDTO(Trade trade) {
        return new TradeDTO(trade.getId(), trade.getDate()
                , UserMapper.userToUserDTO(trade.getUser())
                , trade.getGiveItems().stream().map(TradeMapper::tradeItemToTradeItemDTO).toList()
                , trade.getGetItems().stream().map(TradeMapper::tradeItemToTradeItemDTO).toList()
        );
    }

    public static Trade tradeCreationDTOtoTrade(TradeCreationDTO tradeCreationDTO) {
        return Trade.builder()
                .id(tradeCreationDTO.getTradeId())
                .user(UserMapper.userCreationDTOtoUser(tradeCreationDTO.getUser()))
                .getItems(tradeCreationDTO.getGetItems().stream()
                        .map(i -> {
                            return new GetItem
                                    (tradeCreationDTO.getTradeId()
                                            , ItemMapper.itemDTOtoItem(i.getItem()), i.getAmount());
                        }).toList())
                .giveItems(
                        tradeCreationDTO.getGiveItems().stream()
                                .map(t -> {
                                    return new GiveItem
                                            (tradeCreationDTO.getTradeId()
                                                    , ItemMapper.itemDTOtoItem(t.getItem()), t.getAmount());
                                }).toList()
                )
                .date(tradeCreationDTO.getDate())
                .build();
    }
    private static TradeItem tradeItemCreationDTOtoTradeItem(TradeItemCreationDTO tradeItemDTO) {
        return new GiveItem(tradeItemDTO.getTrade()
                , ItemMapper.itemDTOtoItem(tradeItemDTO.getItem()), tradeItemDTO.getAmount());
    }

    private static <T extends TradeItem> TradeItemDTO tradeItemToTradeItemDTO(T tradeItem) {
        return new TradeItemDTO(ItemMapper.itemToItemDTO(tradeItem.getItem()), tradeItem.getAmount());
    }
}
