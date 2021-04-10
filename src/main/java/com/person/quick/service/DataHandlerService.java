package com.person.quick.service;

import com.person.quick.entity.TableEntity;
import com.person.quick.entity.TemplateEntity;
import com.person.quick.entity.UserConfigEntity;
import com.person.quick.model.TableModel;
import org.apache.velocity.Template;

import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/**
 * @author shishuai04
 */
public interface DataHandlerService {

    /**
     * 获取数据库字段
     *
     * @param tableName
     * @param dataSourceKey
     * @return
     */
    TableEntity getDatabase(String dataSourceKey, String tableName);

    /**
     * 数据库字段格式化
     *
     * @param tableEntity
     * @return
     */
    TableModel formatTable(TableEntity tableEntity, TemplateEntity templateEntity, UserConfigEntity userConfigEntity, String moduleName, Map<String, String> columnAttrMap) throws Exception;

    UserConfigEntity getUserConfig(String userKey);

    /**
     * 表名处理
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
     * @param templateName
     * @param params
     * @param dataSourceKey
     * @return
     */
    StringWriter renderPage(String dataSourceKey, String templateName, Map<String, String> params);


    /**
     * 位置分发
     *
     * @param writer
     * @param dataSourceKey
     */
    void writePosition(String dataSourceKey, TemplateEntity templateEntity, UserConfigEntity userConfigEntity, TableModel tableModel, StringWriter writer) throws FileNotFoundException;

}
