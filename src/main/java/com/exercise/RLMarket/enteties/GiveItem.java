package com.exercise.RLMarket.enteties;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@Entity
@Table(name = "trade_give_items")
public class GiveItem extends TradeItem{
    public GiveItem(int trade, Item item, int amount) {
        super(trade, item, amount);
    }
    public GiveItem(TradeItem tradeItem) {
        super(tradeItem.getTrade(), tradeItem.getItem(), tradeItem.trade);
    }
}
