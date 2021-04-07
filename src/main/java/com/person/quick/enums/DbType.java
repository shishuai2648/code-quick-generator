package com.person.quick.enums;

import org.springframework.util.StringUtils;

/**
 * @author shishuai04
 */

public enum DbType {

    MYSQL("mysql"), ORACLE("oracle"), SQL_SERVER("sqlServer");

    private String type;

    DbType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static DbType getByType(String type) {
        if (StringUtils.isEmpty(type)) {
            return null;
        }

        for (DbType value : values()) {

            if (value.getType().equals(type)) {
                return value;
            }

        }
        return null;

    }

}
