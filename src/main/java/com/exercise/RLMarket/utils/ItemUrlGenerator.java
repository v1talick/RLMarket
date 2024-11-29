package com.exercise.RLMarket.utils;

public class ItemUrlGenerator {
    public static String getUrl(String itemName) {
        String res = itemName.toLowerCase().replace(' ', '-');
        return new StringBuilder("https://www.rocketprices.com/images/rocket%20league/items/ps4-")
                .append(res)
                .append(".png")
                .toString();

    }
}
