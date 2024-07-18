package com.exercise.RLMarket.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trade {
    @Id
    @Column(name = "trade_id")
    int id;
    @ManyToOne
            @JoinColumn(name = "user_id")
    User user;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    Date date;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "trade", referencedColumnName = "trade_id")
    List<GiveItem> giveItems;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "trade", referencedColumnName = "trade_id")
    List<GetItem> getItems;
}
