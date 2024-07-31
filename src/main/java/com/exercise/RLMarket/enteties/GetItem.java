package com.exercise.RLMarket.enteties;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@Entity
@Table(name = "trade_get_items")
public class GetItem extends TradeItem {
    public GetItem(int trade, Item item, int amount) {
        super(trade, item, amount);
    }

    public GetItem(TradeItem tradeItem) {
        super(tradeItem.getTrade(), tradeItem.getItem(), tradeItem.trade);
    }
}
