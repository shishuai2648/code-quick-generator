CREATE SCHEMA IF NOT EXISTS "base";

-- Create syntax for TABLE 'column_attr_rel'
CREATE TABLE `column_attr_rel`
(
    `column_attr_rel_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `column_type`        varchar(32) NOT NULL COMMENT '字段类型',
    `attr_type`          varchar(32) NOT NULL COMMENT '对应属性类型',
    PRIMARY KEY (`column_attr_rel_id`)
);

-- Create syntax for TABLE 'data_source'
CREATE TABLE `data_source`
(
    `data_source_id`        bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `data_source_key`       varchar(128)  NOT NULL DEFAULT '' COMMENT '数据源名称',
    `data_source_url`       varchar(1024) NOT NULL DEFAULT '' COMMENT '数据源地址',
    `data_source_username`  varchar(128)  NOT NULL DEFAULT '' COMMENT '数据源连接名',
    `data_source_password`  varchar(128)  NOT NULL DEFAULT '' COMMENT '数据源连接密码',
    `data_source_driver`    varchar(128)  NOT NULL DEFAULT '' COMMENT '驱动器',
    `data_source_type`      varchar(128)  NOT NULL DEFAULT '' COMMENT '数据库类型',
    `data_source_file_path` varchar(128)  NOT NULL DEFAULT '' COMMENT '文件存放地址',
    PRIMARY KEY (`data_source_id`)
);

-- Create syntax for TABLE 'template_info'
CREATE TABLE `template_info`
(
    `template_id`                    bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `data_source_key`                varchar(32)  NOT NULL COMMENT '对应datasource',
    `template_name`                  varchar(32)  NOT NULL COMMENT '模板名称',
    `template_file_name`             varchar(32) DEFAULT NULL COMMENT '文件名',
    `template_suffix`                varchar(32)  NOT NULL COMMENT '后缀',
    `template_position`              varchar(32)  NOT NULL COMMENT '存储位置',
    `exist_replace`                  int(11) NOT NULL DEFAULT '1' COMMENT '0 不替换;1 替换;',
    `table_name_rex`                 varchar(32)  NOT NULL COMMENT '名字表达式',
    `module_package`                 varchar(128) NOT NULL COMMENT '模块名,支持使用#{moduleName}从表名中获取',
    `project_code_relative_position` varchar(32)  NOT NULL COMMENT '项目相对于代码路径',
    `module_name_show`               int(11) NOT NULL DEFAULT '1' COMMENT '模块名称是否展示 0 不展示 1 展示',
    `ext_name_show`                  int(11) NOT NULL DEFAULT '1' COMMENT '扩展名是否展示 0 不展示 1 展示',
    PRIMARY KEY (`template_id`)
);

-- Create syntax for TABLE 'user_config'
CREATE TABLE `user_config`
(
    `user_config_id`   bigint(20) NOT NULL AUTO_INCREMENT,
    `user_key`         varchar(32) NOT NULL,
    `data_source_key`  varchar(32) NOT NULL,
    `author`           varchar(32) NOT NULL,
    `email`            varchar(32) NOT NULL,
    `project_position` varchar(32) NOT NULL,
    PRIMARY KEY (`user_config_id`)
);