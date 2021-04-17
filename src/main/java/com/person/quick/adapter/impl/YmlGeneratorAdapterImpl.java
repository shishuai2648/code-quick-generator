package com.person.quick.adapter.impl;

import com.person.quick.adapter.BaseGeneratorAdapterImpl;
import com.person.quick.config.CommonConfig;
import com.person.quick.entity.*;
import com.person.quick.enums.DbType;
import com.person.quick.factory.BaseSqlQueryFactory;
import com.person.quick.mapper.BaseSqlQueryMapper;

import java.util.List;

/**
 * @author shishuai04
 */
public class YmlGeneratorAdapterImpl extends BaseGeneratorAdapterImpl {

    private CommonConfig commonConfig;

    public YmlGeneratorAdapterImpl(CommonConfig commonConfig) {
        this.commonConfig = commonConfig;
    }

    @Override
    public DataSourceEntity getDatabase(String dataSourceKey) {
        return null;
    }

    @Override
    public TableEntity getTableInfo(String dataSourceKey, DataSourceEntity dataSourceEntity, String tableName) {
        BaseSqlQueryMapper sqlQueryMapper = BaseSqlQueryFactory.getSqlQueryMapper(DbType.getByType(commonConfig.getDataSourceKey()));
        TableEntity tableEntity = sqlQueryMapper.queryTable(dataSourceKey, tableName);
        List<ColumnEntity> columns = sqlQueryMapper.queryColumns(dataSourceKey, tableName);
        tableEntity.setColumns(columns);

        return tableEntity;
    }

    @Override
    public UserConfigEntity getUserConfig(String dataSourceKey, String userKey) {
        UserConfigEntity userConfigEntity = new UserConfigEntity();
        userConfigEntity.setDataSourceKey(dataSourceKey);
        userConfigEntity.setAuthor(commonConfig.getAuthor());
        userConfigEntity.setEmail(commonConfig.getEmail());
        userConfigEntity.setProjectPosition(commonConfig.getProjectPosition());
        return userConfigEntity;
    }

    @Override
    public List<TemplateEntity> templates(String dataSourceKey) {
        return commonConfig.getTemplateList();
    }
}
