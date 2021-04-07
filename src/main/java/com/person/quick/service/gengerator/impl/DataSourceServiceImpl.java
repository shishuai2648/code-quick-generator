package com.person.quick.service.gengerator.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.person.quick.entity.DataSourceEntity;
import com.person.quick.mapper.DataSourceMapper;
import com.person.quick.service.gengerator.DataSourceService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shishuai04
 */
@Service
public class DataSourceServiceImpl implements DataSourceService {

    @Resource
    private DataSourceMapper dataSourceMapper;

    @Override
    public DataSourceEntity getDataSourceByKey(String dataSourceKey) {
        List<DataSourceEntity> selectList = dataSourceMapper.selectList(new QueryWrapper<DataSourceEntity>().eq("data_source_key", dataSourceKey));
        if (!CollectionUtils.isEmpty(selectList)) {
            return selectList.get(0);
        }
        return null;
    }
}
