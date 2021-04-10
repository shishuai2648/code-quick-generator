package com.person.quick.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.person.quick.entity.ColumnAttrRelEntity;
import com.person.quick.mapper.ColumnAttrRelMapper;
import com.person.quick.service.ColumnAttrRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ColumnAttrRelServiceImpl extends ServiceImpl<ColumnAttrRelMapper, ColumnAttrRelEntity> implements ColumnAttrRelService {

    @Resource
    private ColumnAttrRelMapper columnAttrRelMapper;

    @Override
    public List<ColumnAttrRelEntity> getAll() {
        return columnAttrRelMapper.selectList(new QueryWrapper<>());
    }
}
