package com.person.quick.adapter;

import com.person.quick.entity.DataSourceEntity;
import com.person.quick.entity.TableEntity;
import com.person.quick.entity.TemplateEntity;
import com.person.quick.entity.UserConfigEntity;
import com.person.quick.model.TableModel;

import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/**
 * @author shishuai04
 */
public interface GeneratorAdapter {

    /**
     * 获取数据库字段
     *
     * @param dataSourceKey
     * @return
     */
    DataSourceEntity getDatabase(String dataSourceKey);

    /**
     * 获取表信息
     *
     * @param dataSourceKey
     * @param tableName
     * @return
     */
    TableEntity getTableInfo(String dataSourceKey, DataSourceEntity dataSourceEntity, String tableName);

    /**
     * 数据库字段格式化
     *
     * @param tableEntity
     * @param templateEntity
     * @param userConfigEntity
     * @param moduleName
     * @param columnAttrMap
     * @return
     * @throws Exception
     */
    TableModel formatTable(TableEntity tableEntity, TemplateEntity templateEntity, UserConfigEntity userConfigEntity, String moduleName, Map<String, String> columnAttrMap) throws Exception;

    /**
     * 获取用户配置
     *
     * @param userKey
     * @return
     */
    UserConfigEntity getUserConfig(String dataSourceKey, String userKey);

    /**
     * 表名处理
     *
     * @param tableName
     * @param templateEntity
     * @param userConfigEntity
     * @param moduleName
     * @return
     */
    String tableNameToModule(String tableName, TemplateEntity templateEntity, UserConfigEntity userConfigEntity, String moduleName);

    /**
     * 获取模板
     *
     * @param dataSourceKey
     * @return
     */
    List<TemplateEntity> templates(String dataSourceKey);

    /**
     * 加载定制化字段
     *
     * @param dataSourceKey
     * @return
     */
    Map<String, Object> loadProperties(String dataSourceKey);


    /**
     * 渲染模板
     *
     * @param templatePosition
     * @param params
     * @param dataSourceKey
     * @return
     */
    StringWriter renderPage(String dataSourceKey, String templatePosition, Map<String, Object> params);

    /**
     * 位置分发
     *
     * @param dataSourceKey
     * @param templateEntity
     * @param userConfigEntity
     * @param tableModel
     * @param writer
     * @throws FileNotFoundException
     */
    void writePosition(String dataSourceKey, TemplateEntity templateEntity, UserConfigEntity userConfigEntity, TableModel tableModel, StringWriter writer) throws FileNotFoundException;

}
