package com.person.quick.monitor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.person.quick.config.DataSourceConfig;
import com.person.quick.entity.DataSourceEntity;
import com.person.quick.entity.TableEntity;
import com.person.quick.mapper.DataSourceMapper;
import com.person.quick.service.gengerator.GeneratorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ApplicationMonitor  implements CommandLineRunner {

    @Resource
    private DataSourceMapper dataSourceMapper;

    @Resource
    private DataSourceConfig dataSourceConfig;

    @Resource
    private GeneratorService generatorService;

    @Override
    public void run(String... args) throws Exception {

        List<DataSourceEntity> dataSourceEntities = dataSourceMapper.selectList(new QueryWrapper<>());
        for (DataSourceEntity dataSourceEntity : dataSourceEntities) {
            dataSourceConfig.addDataSource(dataSourceEntity);
        }
    }


}
