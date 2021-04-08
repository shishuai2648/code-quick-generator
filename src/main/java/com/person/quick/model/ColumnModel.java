package com.person.quick.model;

import lombok.Data;

/**
 * @author shishuai04
 */
@Data
public class ColumnModel {
    /**
     * 列名
     */
    private String columnName;

    /**
     * 列名类型
     */
    private String dataType;

    /**
     * 列名备注
     */
    private String columnComment;

    /**
     * 属性名称(第一个字母大写)，如：user_name => UserName
     */
    private String columnKey;

    /**
     * auto_increment
     */
    private String extra;
}
