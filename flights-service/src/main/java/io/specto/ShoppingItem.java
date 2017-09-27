package io.specto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingItem {
    private final String item;

    @JsonCreator
    public ShoppingItem(@JsonProperty(value = "item") String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    @Override
    public boolean equals(Object obj){
        return item.equals(item);
    }

    @Override
    public int hashCode() {
        return item.hashCode();
    }
}