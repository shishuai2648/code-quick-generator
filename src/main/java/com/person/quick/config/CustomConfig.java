package com.person.quick.config;

import com.person.quick.entity.TemplateEntity;
import lombok.Data;

import java.util.List;

/**
 * @author shishuai04
 */
@Data
public class CustomConfig {

    private String method;

    private String dataSourceKey;

    private String datasourceType;

    private List<String> tableNames;

    private String author;

    private String email;

    private String projectPosition;

    private List<TemplateEntity> templateList;
}
