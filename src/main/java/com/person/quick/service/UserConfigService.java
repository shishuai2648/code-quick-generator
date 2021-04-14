package com.person.quick.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.person.quick.entity.UserConfigEntity;

public interface UserConfigService extends IService<UserConfigEntity> {

    /**
     * @param userKey
     * @return
     */
    UserConfigEntity getUserConfigByKey(String dataSourceKey, String userKey);
}
