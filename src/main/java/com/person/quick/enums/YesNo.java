package com.person.quick.enums;

public enum YesNo {

    YES(1),
    NO(0);

    private Integer value;

    YesNo(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
