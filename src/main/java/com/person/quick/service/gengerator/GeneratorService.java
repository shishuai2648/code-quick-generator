package com.person.quick.service.gengerator;

import com.person.quick.entity.TableEntity;
import com.person.quick.model.TableModel;
import org.apache.velocity.Template;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/**
 * @author shishuai04
 */
public interface GeneratorService {

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
    TableModel formatTable(TableEntity tableEntity);

    /**
     * 获取模板
     *
     * @param dataSourceKey
     * @return
     */
    List<String> templates(String dataSourceKey);

    /**
     * 加载定制化字段
     *
     * @param dataSourceKey
     * @return
     */
    Map<String, String> loadProperties(String dataSourceKey);


    /**
     * 渲染模板
     *
     * @param tpl
     * @param params
     * @param dataSourceKey
     * @return
     */
    StringWriter renderPage(String dataSourceKey, Template tpl, Map<String, String> params);


    /**
     * 位置分发
     *
     * @param writer
     * @param dataSourceKey
     */
    void writePosition(String dataSourceKey, StringWriter writer);

}
