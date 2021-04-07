package com.person.quick.service.gengerator;

import com.person.quick.entity.DataSourceEntity;

/**
 * @author shishuai04
 */
public interface DataSourceService {

    /**
     *
     * @param dataSourceKey
     * @return
     */
    DataSourceEntity getDataSourceByKey(String dataSourceKey);
}
