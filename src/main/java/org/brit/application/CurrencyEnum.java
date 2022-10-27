package org.brit.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

public enum CurrencyEnum {
    EURO("Euro"),
    DOLLAR("US Dollar");

    private String value;

    CurrencyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
