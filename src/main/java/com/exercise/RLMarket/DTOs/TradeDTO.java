package com.exercise.RLMarket.DTOs;

import com.exercise.RLMarket.enteties.Item;
import com.exercise.RLMarket.enteties.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TradeDTO {
    private int id;
    private UserDTO user;
    private Date date;
    private ItemDTO giveItem;
    private int giveAmount;
    private ItemDTO getItem;
    private int getAmount;
}
