package com.person.quick.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("column_attr_rel")
public class ColumnAttrRelEntity {

    private String columnAttrRelId;
    private String columnType;
    private String attrType;
}
