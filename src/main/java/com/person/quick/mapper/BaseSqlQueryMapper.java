package com.person.quick.mapper;

import com.person.quick.entity.TableEntity;

import java.util.List;
import java.util.Map;

/**
 * @author shishuai04
 */
@SuppressWarnings("all")
public interface BaseSqlQueryMapper {

    /**
     * 查询所有表数据
     *
     * @param map
     * @return
     */
    List<Map<String, Object>> queryTableList(Map<String, Object> map);

    /**
     * 查询某个表数据
     *
     * @param tableName
     * @return
     */
    TableEntity queryTable(String tableName);


    /**
     * 查询所有列数据
     *
     * @param tableName
     * @return
     */
    List<Map<String, String>> queryColumns(String tableName);
}
