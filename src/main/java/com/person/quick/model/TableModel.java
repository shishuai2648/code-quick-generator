package com.person.quick.model;

import lombok.Data;

import java.lang.ref.PhantomReference;
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
     * 表的备注
     */
    private String tableComment;

    /**
     * 类名(第一个字母大写)，如：sys_user => SysUser
     */
    private String className;
    /**
     * 类名(第一个字母小写)，如：sys_user => sysUser
     */
    private String classname;

    /**
     * 表的列名(不包含主键)
     */
    private List<ColumnModel> columns;

    /**
     * 包信息
     */
    private String moduleName;

    /**
     * 包名
     */
    private String classPackage;

    /**
     * 包名
     */
    private String classPackageName;

    /**
     * 开发人
     */
    private String author;

    /**
     * 邮件地址
     */
    private String email;

}
