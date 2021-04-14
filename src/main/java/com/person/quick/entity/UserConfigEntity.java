package com.person.quick.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_config")
public class UserConfigEntity {

    private String userConfigId;
    private String userKey;
    private String dataSourceKey;
    private String author;
    private String email;
    private String projectPosition;
}
