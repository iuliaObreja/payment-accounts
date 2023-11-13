package org.example.common;

public enum CardType {
    CREDIT("Credit"),
    DEBIT("Debit");

    public final String name;

    CardType(String type) {
        this.name = type;
    }

    public String getName() {
        return name;
    }
}
