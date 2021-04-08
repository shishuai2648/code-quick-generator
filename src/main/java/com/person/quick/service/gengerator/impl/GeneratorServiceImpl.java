package com.person.quick.service.gengerator.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.person.quick.config.DataSourceConfig;
import com.person.quick.entity.ColumnEntity;
import com.person.quick.entity.DataSourceEntity;
import com.person.quick.entity.TableEntity;
import com.person.quick.enums.DbType;
import com.person.quick.factory.BaseSqlQueryFactory;
import com.person.quick.mapper.BaseSqlQueryMapper;
import com.person.quick.mapper.MySqlQueryMapper;
import com.person.quick.model.TableModel;
import com.person.quick.service.gengerator.DataSourceService;
import com.person.quick.service.gengerator.GeneratorService;
import org.apache.velocity.Template;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author shishuai04
 */
@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Resource
    private MySqlQueryMapper mySqlQueryMapper;

    @Resource
    private DataSourceService dataSourceService;

    @Resource
    private DataSourceConfig dataSourceConfig;

    @Override
    public TableEntity getDatabase(String dataSourceKey, String tableName) {
        DataSourceEntity dataSourceEntity = dataSourceService.getDataSourceByKey(dataSourceKey);
        BaseSqlQueryMapper sqlQueryMapper = BaseSqlQueryFactory.getSqlQueryMapper(DbType.getByType(dataSourceEntity.getDataSourceType()));
        TableEntity tableEntity = sqlQueryMapper.queryTable(dataSourceKey, tableName);

        List<ColumnEntity> columns = sqlQueryMapper.queryColumns(dataSourceKey, tableName);
        tableEntity.setColumns(columns);

        return tableEntity;
    }

    @Override
    public TableModel formatTable(TableEntity tableEntity) {
        return null;
    }

    @Override
    public List<String> templates(String dataSourceKey) {
        return null;
    }

    @Override
    public Map<String, String> loadProperties(String dataSourceKey) {
        return null;
    }

    @Override
    public StringWriter renderPage(String dataSourceKey, Template tpl, Map<String, String> params) {
        return null;
    }

    @Override
    public void writePosition(String dataSourceKey, StringWriter writer) {

    }

}
