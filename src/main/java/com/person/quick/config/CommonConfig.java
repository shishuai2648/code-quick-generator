package com.person.quick.config;

import com.person.quick.entity.TemplateEntity;
import com.person.quick.enums.GeneratorType;
import lombok.Data;

import java.util.List;

/**
 * @author shishuai04
 */
@Data
public class CommonConfig {

    private GeneratorType method;

    private String dataSourceKey;

    private String dataSourceType;

    private List<String> tableNames;

    private String author;

    private String email;

    private String projectPosition;

    private List<TemplateEntity> templateList;
}
