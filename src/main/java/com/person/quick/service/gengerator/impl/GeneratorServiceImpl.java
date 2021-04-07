package com.person.quick.service.gengerator.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.person.quick.entity.DataSourceEntity;
import com.person.quick.entity.TableEntity;
import com.person.quick.enums.DbType;
import com.person.quick.factory.BaseSqlQueryFactory;
import com.person.quick.mapper.BaseSqlQueryMapper;
import com.person.quick.model.TableModel;
import com.person.quick.service.gengerator.DataSourceService;
import com.person.quick.service.gengerator.GeneratorService;
import org.apache.velocity.Template;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/**
 * @author shishuai04
 */
@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Resource
    private DataSourceService dataSourceService;

    @Override
    @DS("#p0")
    public TableEntity getDatabase(String dataSourceKey, String tableName) {
        DataSourceEntity dataSourceEntity = dataSourceService.getDataSourceByKey(dataSourceKey);
        BaseSqlQueryMapper sqlQueryMapper = BaseSqlQueryFactory.getSqlQueryMapper(DbType.getByType(dataSourceEntity.getDataSourceType()));
        return sqlQueryMapper.queryTable(tableName);
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
