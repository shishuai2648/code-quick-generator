package com.person.quick.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.person.quick.entity.DataSourceEntity;
import com.person.quick.entity.TemplateEntity;

import java.util.List;

public interface TemplateService extends IService<TemplateEntity> {

    List<TemplateEntity> getTemplateByKey(String dataSourceKey);
}
