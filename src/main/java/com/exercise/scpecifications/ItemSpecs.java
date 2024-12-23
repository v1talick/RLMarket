package com.exercise.scpecifications;

import com.exercise.RLMarket.enteties.Item;
import com.exercise.RLMarket.enteties.enums.ItemType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public class ItemSpecs {
    public static Specification<Item> byItemType(ItemType itemType) {
        return (root, query, builder) -> {
            // build query here
            return builder.equal(root.get("type"), itemType);
        };
    }
    public static Specification<Item> byLongLabel(String longLabel) {
        return (root, query, builder) -> {
            // build query here
            return builder.equal(root.get("longLabel"), longLabel);
        };
    }
    public static Specification<Item> byQuality(int quality) {
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("quality"), quality);
        });
    }
    public static Specification<Item> generalSpecification(Optional<ItemType> itemType, Optional<String> longLabel,
                                                           Optional<Integer> qualityId) {
        Specification<Item> result = Specification.where(null);
        if(itemType.isPresent()) {
            result = result.and(new Specification<Item>() {
                @Override
                public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    return criteriaBuilder.equal(root.get("type"), itemType.get());
                }
            });
        }
        if(longLabel.isPresent()) {
            result = result.and(new Specification<Item>() {
                @Override
                public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    return criteriaBuilder.equal(root.get("longLabel"), longLabel.get());
                }
            });
        }
        if(qualityId.isPresent()) {
            result = result.and(new Specification<Item>() {
                @Override
                public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    return criteriaBuilder.equal(root.get("quality"), qualityId.get());
                }
            });
        }
        return result;
    }
}
