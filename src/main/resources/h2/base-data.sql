INSERT INTO `column_attr_rel` (`column_type`, `attr_type`)
VALUES
('tinyint', 'Integer'),
('smallint', 'Integer'),
('mediumint', 'Integer'),
('int', 'Integer'),
('integer', 'Integer'),
('bigint', 'Long'),
('float', 'Float'),
('double', 'Double'),
('decimal', 'BigDecimal'),
('char', 'String'),
('varchar', 'String'),
('tinytext', 'String'),
('text', 'String'),
('mediumtext', 'String'),
('longtext', 'String'),
('date', 'Date'),
('datetime', 'Date'),
('timestamp', 'Date');


INSERT INTO `data_source` (`data_source_key`, `data_source_url`, `data_source_username`, `data_source_password`, `data_source_driver`, `data_source_type`, `data_source_file_path`)
VALUES
('hrc', 'jdbc:mysql://120.48.31.80:3306/hrc?useUnicode=true&characterEncoding=utf8&useSSL=false&zeroDateTimeBehavior=CONVERT_TO_NULL&connectTimeout=2000&autoReconnect=true&maxReconnects=5&serverTimezone=Asia/Shanghai', 'ss', '123', 'com.mysql.cj.jdbc.Driver', 'mysql', '');


INSERT INTO `template_info` (`data_source_key`, `template_name`, `template_file_name`, `template_suffix`, `template_position`, `exist_replace`, `table_name_rex`, `module_package`, `project_code_relative_position`, `module_name_show`, `ext_name_show`)
VALUES
('hrc', 'Entity.java.vm', 'Entity', '.java', 'template/Entity.java.vm', 1, '${moduleName}', 'com.shishuai.${moduleName}.entity', 'src\\main\\java', 0, 1),
('hrc', 'Dao.java.vm', 'Mapper', '.java', 'template/Dao.java.vm', 1, '${moduleName}', 'com.shishuai.${moduleName}.Dao', 'src\\main\\java', 1, 1);

INSERT INTO `user_config` (`user_key`, `template_id`, `author`, `email`, `project_position`)
VALUES
('test', '1', 'shishuai', 'shishuai', 'D:\\code-quick-generator-bate'),
('test', '2', 'shishuia', 'shishuai', 'D:\\code-quick-generator-bate');
