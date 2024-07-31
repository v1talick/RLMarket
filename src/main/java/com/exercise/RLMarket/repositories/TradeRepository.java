package com.exercise.RLMarket.repositories;

import com.exercise.RLMarket.enteties.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer> {
    @Query("select t from Trade t where t.user.id =? 1 ORDER BY t.date")
    List<Trade> findTradesByUserId(int userId);
}
