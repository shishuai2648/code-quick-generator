package com.person.quick.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.person.quick.entity.DataSourceEntity;
import com.person.quick.entity.UserConfigEntity;
import com.person.quick.mapper.UserConfigMapper;
import com.person.quick.service.UserConfigService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserConfigServiceImpl extends ServiceImpl<UserConfigMapper, UserConfigEntity> implements UserConfigService {

    @Resource
    private UserConfigMapper userConfigMapper;

    @Override
    public UserConfigEntity getUserConfigByKey(String dataSourceKey, String userKey) {

        List<UserConfigEntity> userConfigList = userConfigMapper.selectList(new QueryWrapper<UserConfigEntity>().eq("user_key", userKey).eq("data_source_key", dataSourceKey));

        if (!CollectionUtils.isEmpty(userConfigList)) {
            return userConfigList.get(0);
        }
        return null;
    }
}
