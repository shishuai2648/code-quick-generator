package com.person.quick.entity;

import lombok.Data;

/**
 * @author shishuai04
 */
@Data
public class ColumnEntity {

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

    private String columnKey;

    private String extra;

}
