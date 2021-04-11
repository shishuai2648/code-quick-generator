package com.person.quick.model;

import lombok.Data;

import java.lang.ref.PhantomReference;
import java.util.List;

/**
 * @author shishuai04
 */public class TableModel {
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

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public List<ColumnModel> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnModel> columns) {
        this.columns = columns;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getClassPackage() {
        return classPackage;
    }

    public void setClassPackage(String classPackage) {
        this.classPackage = classPackage;
    }

    public String getClassPackageName() {
        return classPackageName;
    }

    public void setClassPackageName(String classPackageName) {
        this.classPackageName = classPackageName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
