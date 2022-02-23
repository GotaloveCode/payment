package com.mpf.beedeepayment.model.jackson.trxconfirm;

import java.util.List;

public class CallbackMetadata {

    private List<Item> item = null;

    /**
     * No args constructor for use in serialization
     */
    public CallbackMetadata() {
    }

    /**
     * @param item
     */
    public CallbackMetadata(List<Item> item) {
        super();
        this.item = item;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(item).toString();
    }

}
