package com.person.quick.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.person.quick.entity.ColumnEntity;
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
    @DS("#p0")
    TableEntity queryTable(String dataSourceKey, String tableName);

    @DS("#p0")
    String queryDataBase(String dataSourceKey);

    /**
     * 查询所有列数据
     *
     * @param tableName
     * @return
     */
    @DS("#p0")
    List<ColumnEntity> queryColumns(String dataSourceKey, String tableName);
}
