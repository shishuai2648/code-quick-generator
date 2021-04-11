package com.person.quick.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("template_info")
public class TemplateEntity {

    @TableId
    private String templateId;
    private String dataSourceKey;
    private String templateName;
    private String templatePosition;
    private String templateSuffix;
    private Integer existReplace;
    private String tableNameRex;
    private String modulePackage;
    private String projectCodeRelativePosition;
    private Integer moduleNameShow;
    private Integer extNameShow;
}
