package com.person.quick.entity;

import lombok.Data;

import java.util.Date;

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
}
