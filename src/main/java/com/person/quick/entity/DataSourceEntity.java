package com.person.quick.entity;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author shishuai04
 */
@Data
@TableName("data_source")
public class DataSourceEntity {

    @TableId
    private String dataSourceId;
    private String dataSourceKey;
    private String dataSourceUrl;
    private String dataSourceUsername;
    private String dataSourcePassword;
    private String dataSourceDriver;
    private String dataSourceType;

    public DataSourceProperty toDataSourceProperty(){
        DataSourceProperty dataSourceProperty = new DataSourceProperty();

        dataSourceProperty.setUrl(this.dataSourceUrl);
        dataSourceProperty.setUsername(this.dataSourceUsername);
        dataSourceProperty.setPassword(this.dataSourcePassword);
        dataSourceProperty.setDriverClassName(this.dataSourceDriver);

        return dataSourceProperty;
    }

}
