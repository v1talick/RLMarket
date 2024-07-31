package com.exercise.RLMarket.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name = "trade_give_items")
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(TradeItemPK.class)
@Builder
public class TradeItem {
    @Id
    int trade;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item")
    Item item;
    @Column(name = "amount")
    int amount;
}

