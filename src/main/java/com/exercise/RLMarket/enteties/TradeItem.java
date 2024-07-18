package com.exercise.RLMarket.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name = "trade_give_items")
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(TradeItemPK.class)
public class TradeItem {
    int trade;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item")
    Item item;
    @Column(name = "amount")
    int amount;
}

