package com.person.quick.config;

import lombok.Data;

import java.util.List;

@Data
public class CustomConfig {
    private String dataSourceKey;
    private String moduleName;
    private List<String> tableNames;
    private String projectPosition;
}
