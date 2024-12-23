package com.exercise.RLMarket.repositories;

import com.exercise.RLMarket.enteties.Item;
import com.exercise.RLMarket.enteties.enums.ItemType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>, JpaSpecificationExecutor<Item> {
    @Query("select i from Item i where i.type = ?1")
    public List<Item> findItemsByType(ItemType itemType);
    @Override
    List<Item> findAll(Specification<Item> spec);
}
