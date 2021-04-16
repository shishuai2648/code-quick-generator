package com.person.quick.adapter.impl;

import com.person.quick.adapter.BaseGeneratorAdapterImpl;
import com.person.quick.entity.DataSourceEntity;
import com.person.quick.entity.TableEntity;
import com.person.quick.entity.TemplateEntity;
import com.person.quick.entity.UserConfigEntity;

import java.util.List;

/**
 * @author shishuai04
 */
public class YmlGeneratorAdapterImpl extends BaseGeneratorAdapterImpl {

    @Override
    public DataSourceEntity getDatabase(String dataSourceKey) {
        return null;
    }

    @Override
    public TableEntity getTableInfo(String dataSourceKey, DataSourceEntity dataSourceEntity, String tableName) {
        return null;
    }

    @Override
    public UserConfigEntity getUserConfig(String dataSourceKey, String userKey) {
        return null;
    }

    @Override
    public List<TemplateEntity> templates(String dataSourceKey) {
        return null;
    }
}
