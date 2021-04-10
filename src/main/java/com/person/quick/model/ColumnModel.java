package com.person.quick.model;

import lombok.Data;

/**
 * @author shishuai04
 */
@Data
public class ColumnModel {
    /**
     * 列类型
     */
    private String dataType;

    /**
     * 列名
     */
    private String columnName;

    /**
     * 列名备注
     */
    private String columnComment;

    /**
     * 主键标识
     */
    private String columnKey;

    /**
     * 属性名称(第一个字母小写)，如：user_name => userName
     */
    private String attrname;

    /**
     * 属性类型
     */
    private String attrType;

    /**
     * auto_increment
     */
    private String extra;

    /**
     * 是否为主键
     */
    private Boolean isPK;
}
