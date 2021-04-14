package com.person.quick.adapter.impl;

import com.person.quick.adapter.BaseGeneratorAdapterImpl;
import com.person.quick.entity.ColumnEntity;
import com.person.quick.entity.DataSourceEntity;
import com.person.quick.entity.TableEntity;
import com.person.quick.entity.TemplateEntity;
import com.person.quick.entity.UserConfigEntity;
import com.person.quick.enums.DbType;
import com.person.quick.factory.BaseSqlQueryFactory;
import com.person.quick.mapper.BaseSqlQueryMapper;
import com.person.quick.service.DataSourceService;
import com.person.quick.service.TemplateService;
import com.person.quick.service.UserConfigService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shishuai04
 */
public class MySqlGeneratorAdapterImpl extends BaseGeneratorAdapterImpl {

    @Resource
    private DataSourceService dataSourceService;

    @Resource
    private TemplateService templateService;

    @Resource
    private UserConfigService userConfigService;


    public MySqlGeneratorAdapterImpl(DataSourceService dataSourceService, TemplateService templateService, UserConfigService userConfigService) {
        this.dataSourceService = dataSourceService;
        this.templateService = templateService;
        this.userConfigService = userConfigService;
    }

    @Override
    public DataSourceEntity getDatabase(String dataSourceKey) {
        DataSourceEntity dataSourceEntity = dataSourceService.getDataSourceByKey(dataSourceKey);
        return dataSourceEntity;
    }

    @Override
    public TableEntity getTableInfo(String dataSourceKey, DataSourceEntity dataSourceEntity, String tableName) {

        BaseSqlQueryMapper sqlQueryMapper = BaseSqlQueryFactory.getSqlQueryMapper(DbType.getByType(dataSourceEntity.getDataSourceType()));
        TableEntity tableEntity = sqlQueryMapper.queryTable(dataSourceKey, tableName);

        List<ColumnEntity> columns = sqlQueryMapper.queryColumns(dataSourceKey, tableName);
        tableEntity.setColumns(columns);
        return tableEntity;
    }


    @Override
    public List<TemplateEntity> templates(String dataSourceKey) {
        return templateService.getTemplateByKey(dataSourceKey);
    }

    @Override
    public UserConfigEntity getUserConfig(String userKey) {
        return userConfigService.getUserConfigByKey(userKey);
    }



}
