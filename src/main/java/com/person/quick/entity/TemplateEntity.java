package com.person.quick.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class TemplateEntity {

    @TableId
    private String templateId;
    private String dataSourceKey;
    private String templateName;
    private String templatePosition;
    private Integer templateSuffix;
    private Integer existReplace;
    private String tableNameRex;
    private String modulePackage;
    private String projectCodeRelativePosition;
    private Integer moduleNameShow;
    private Integer extNameShow;
}
