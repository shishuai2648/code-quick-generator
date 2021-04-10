package com.person.quick.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.person.quick.entity.TemplateEntity;
import com.person.quick.mapper.TemplateMapper;
import com.person.quick.service.TemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateMapper, TemplateEntity> implements TemplateService {

    @Resource
    private TemplateMapper templateMapper;

    @Override
    public List<TemplateEntity> getTemplateByKey(String dataSourceKey) {
        return templateMapper.selectList(new QueryWrapper<TemplateEntity>().eq("data_source_key", dataSourceKey));
    }
}
