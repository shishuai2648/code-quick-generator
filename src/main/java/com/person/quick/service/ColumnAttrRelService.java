package com.person.quick.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.person.quick.entity.ColumnAttrRelEntity;

import java.util.List;

public interface ColumnAttrRelService extends IService<ColumnAttrRelEntity> {

    List<ColumnAttrRelEntity> getAll();
}
