package com.mpf.beedeepayment.model.jackson.trxconfirm;

public class Item {

    private String name;
    private String value;

    /**
     * No args constructor for use in serialization
     */
    public Item() {
    }

    /**
     * @param name
     * @param value
     */
    public Item(String name, String value) {
        super();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("name:" + name).append("value" + value).toString();
    }

}
