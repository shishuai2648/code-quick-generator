package com.person.quick.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author shishuai04
 */
@Data
public class TableEntity {

    /**
     * 表的名称
     */
    private String tableName;

    /**
     * 引擎
     */
    private String engine;

    /**
     * 表的备注
     */
    private String tableComment;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 表的主键
     */
    private ColumnEntity pk;

    /**
     * 表的列名(不包含主键)
     */
    private List<ColumnEntity> columns;
}
