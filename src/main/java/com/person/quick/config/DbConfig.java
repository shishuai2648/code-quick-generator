package com.person.quick.config;

import com.baomidou.dynamic.datasource.processor.DsHeaderProcessor;
import com.baomidou.dynamic.datasource.processor.DsProcessor;
import com.person.quick.adapter.GeneratorAdapter;
import com.person.quick.adapter.impl.MySqlGeneratorAdapterImpl;
import com.person.quick.adapter.impl.YmlGeneratorAdapterImpl;
import com.person.quick.enums.GeneratorType;
import com.person.quick.processor.DataSourceProcessor;
import com.person.quick.service.DataSourceService;
import com.person.quick.service.TemplateService;
import com.person.quick.service.UserConfigService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
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

    @Bean
    @ConfigurationProperties(prefix = "common")
    public CommonConfig customConfig() {
        return new CommonConfig();
    }

    @Bean
    @Primary
    public GeneratorAdapter generatorAdapter(CommonConfig commonConfig, DataSourceService dataSourceService, TemplateService templateService, UserConfigService userConfigService) {
        if (GeneratorType.YML_CONFIG.equals(commonConfig.getMethod())) {
            return new YmlGeneratorAdapterImpl(commonConfig);
        }
        return new MySqlGeneratorAdapterImpl(dataSourceService, templateService, userConfigService);
    }

}
