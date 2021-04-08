package com.person.quick.model;

import lombok.Data;

import java.util.List;

/**
 * @author shishuai04
 */
@Data
public class TableModel {
    /**
     * 表的名称
     */
    private String tableName;
    /**
     * 列名类型
     */
    private String comments;
    /**
     * 表的主键
     */
    private ColumnModel pk;
    /**
     * 表的列名(不包含主键)
     */
    private List<ColumnModel> columns;

    /**
     * 类名(第一个字母大写)，如：sys_user => SysUser
     */
    private String className;
    /**
     * 类名(第一个字母小写)，如：sys_user => sysUser
     */
    private String classname;
}
