package com.exercise.RLMarket.enteties;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "trade_get_items")
public class GetItem extends TradeItem{
}
