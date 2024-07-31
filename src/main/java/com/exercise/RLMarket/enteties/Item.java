package com.exercise.RLMarket.enteties;

import com.exercise.RLMarket.enteties.enums.ItemType;
import com.exercise.RLMarket.utils.ItemTypeDeserializer;
import com.exercise.RLMarket.utils.TradeRestrictionsDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "items")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @Column(name = "item_id")
    int id;
    @Column(name = "item_long_label")
    String longLabel;

    @Column(name = "item_short_sort_label")
    String shortLabel;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    @Basic(optional=false)
    ItemType type;

    @Column(name = "item_quality_id")
    int quality;

    @Column(name = "item_thumbnail_asset")
    String thumbnailAsset;

    @Column(name = "product_trade_restriction")
    boolean tradeRestriction;

    @Column(name = "item_paintable")
    boolean paintable;

    @JsonCreator
    public Item(@JsonProperty("Product Id")int id,
                @JsonProperty("Product Long Label") String longLabel,
                @JsonProperty("Product Short Sort Label") String shortLabel,
                @JsonProperty("Slot Index") @JsonDeserialize(using = ItemTypeDeserializer.class) ItemType itemType,
                @JsonProperty("Product Quality Id") int quality,
                @JsonProperty("Product Thumbnail Asset") String thumbnailAsset,
                @JsonProperty("Product Trade Restrictions") @JsonDeserialize(using = TradeRestrictionsDeserializer.class) boolean tradeRestriction,
                @JsonProperty("Product Paintable") boolean paintable) {
        this.id = id;
        this.longLabel = longLabel;
        this.shortLabel = shortLabel;
        this.type = itemType;
        this.quality = quality;
        this.thumbnailAsset = thumbnailAsset;
        this.tradeRestriction = tradeRestriction;
        this.paintable = paintable;
    }
}
