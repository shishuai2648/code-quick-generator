package com.person.quick.entity;

import lombok.Data;

@Data
public class UserConfigEntity {

    private String userConfigId;
    private String userKey;
    private String templateId;
    private String author;
    private String email;
    private String projectPosition;
}
