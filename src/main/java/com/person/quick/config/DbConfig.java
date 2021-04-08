package com.person.quick.config;

import com.baomidou.dynamic.datasource.processor.DsHeaderProcessor;
import com.baomidou.dynamic.datasource.processor.DsProcessor;
import com.person.quick.mapper.BaseSqlQueryMapper;
import com.person.quick.mapper.MySqlQueryMapper;
import com.person.quick.processor.DataSourceProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DbConfig {

    @Bean
    @ConditionalOnMissingBean
    public DsProcessor dsProcessor() {
        DsHeaderProcessor headerProcessor = new DsHeaderProcessor();
        DataSourceProcessor dataSourceProcessor = new DataSourceProcessor();
        headerProcessor.setNextProcessor(dataSourceProcessor);
        return headerProcessor;
    }


}
