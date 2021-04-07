package com.person.quick.config;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.person.quick.entity.DataSourceEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Set;

@Component
public class DataSourceConfig {

    @Resource
    private DataSource dataSource;

    @Resource
    protected DefaultDataSourceCreator dataSourceCreator;

    public Set<String> addDataSource(DataSourceEntity dataSourceEntity) {
        DataSourceProperty dataSourceProperty = dataSourceEntity.toDataSourceProperty();
        DataSource dataSource = dataSourceCreator.createDataSource(dataSourceProperty);

        DynamicRoutingDataSource dynamicRoutingDataSource = (DynamicRoutingDataSource) this.dataSource;

        dynamicRoutingDataSource.addDataSource(dataSourceEntity.getDataSourceKey(), dataSource);
        return dynamicRoutingDataSource.getCurrentDataSources().keySet();
    }

    public String remove(String name) {
        DynamicRoutingDataSource dynamicRoutingDataSource = (DynamicRoutingDataSource) dataSource;

        dynamicRoutingDataSource.removeDataSource(name);
        return "删除成功";
    }

    public Set<String> list() {
        DynamicRoutingDataSource dynamicRoutingDataSource = (DynamicRoutingDataSource) dataSource;

        return dynamicRoutingDataSource.getCurrentDataSources().keySet();
    }


}
