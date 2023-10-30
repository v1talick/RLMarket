package com.exercise.RLMarket.repositories;

import com.exercise.RLMarket.enteties.TradeOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeOfferRepository extends JpaRepository<TradeOffer, Integer> {
}
