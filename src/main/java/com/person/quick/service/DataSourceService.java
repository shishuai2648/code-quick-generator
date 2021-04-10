package com.person.quick.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.person.quick.entity.DataSourceEntity;

/**
 * @author shishuai04
 */
public interface DataSourceService extends IService<DataSourceEntity> {

    /**
     *
     * @param dataSourceKey
     * @return
     */
    DataSourceEntity getDataSourceByKey(String dataSourceKey);
}
