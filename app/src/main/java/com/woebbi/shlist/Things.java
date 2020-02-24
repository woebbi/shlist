package com.woebbi.shlist;

import java.io.Serializable;

public class Things implements Serializable {
    private String name;
    private int amount;

    public Things(String name, int amount){
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
