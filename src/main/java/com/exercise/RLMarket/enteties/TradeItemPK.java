package com.exercise.RLMarket.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

//@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TradeItemPK implements Serializable {
    private int trade;
    private Item item;
}