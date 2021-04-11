package com.person.quick.service.impl;

import com.person.quick.entity.*;
import com.person.quick.enums.DbType;
import com.person.quick.factory.BaseSqlQueryFactory;
import com.person.quick.mapper.BaseSqlQueryMapper;
import com.person.quick.model.TableModel;
import com.person.quick.service.DataSourceService;
import com.person.quick.service.DataHandlerService;
import com.person.quick.service.TemplateService;
import com.person.quick.service.UserConfigService;
import com.person.quick.utils.TableModuleUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.stereotype.Service;
import sun.security.util.Resources;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author shishuai04
 */
@Service
public class DataHandlerServiceImpl implements DataHandlerService {

    @Resource
    private DataSourceService dataSourceService;

    @Resource
    private TemplateService templateService;

    @Resource
    private UserConfigService userConfigService;

    @Override
    public TableEntity getDatabase(String dataSourceKey, String tableName) {
        DataSourceEntity dataSourceEntity = dataSourceService.getDataSourceByKey(dataSourceKey);
        BaseSqlQueryMapper sqlQueryMapper = BaseSqlQueryFactory.getSqlQueryMapper(DbType.getByType(dataSourceEntity.getDataSourceType()));
        TableEntity tableEntity = sqlQueryMapper.queryTable(dataSourceKey, tableName);

        List<ColumnEntity> columns = sqlQueryMapper.queryColumns(dataSourceKey, tableName);
        tableEntity.setColumns(columns);

        return tableEntity;
    }

    @Override
    public String tableNameToModule(String tableName, TemplateEntity templateEntity, UserConfigEntity userConfigEntity, String moduleName) {
        if (StringUtils.isNotBlank(moduleName)) {
            return moduleName;
        }

        String tableNameRex = templateEntity.getTableNameRex();
        return TableModuleUtil.getModuleName(tableNameRex, tableName);
    }

    @Override
    public List<TemplateEntity> templates(String dataSourceKey) {
        return templateService.getTemplateByKey(dataSourceKey);
    }

    @Override
    public TableModel formatTable(TableEntity tableEntity, TemplateEntity templateEntity, UserConfigEntity userConfigEntity, String moduleName, Map<String, String> columnAttrMap) throws Exception {
        return TableModuleUtil.formatTable(tableEntity, templateEntity, userConfigEntity, moduleName, columnAttrMap);
    }

    @Override
    public UserConfigEntity getUserConfig(String userKey) {
        return userConfigService.getUserConfigByKey(userKey);
    }


    @Override
    public Map<String, Object> loadProperties(String dataSourceKey) {
        return new HashMap<>();
    }

    @Override
    public StringWriter renderPage(String dataSourceKey, String templateName, Map<String, Object> params) {

        VelocityContext context = new VelocityContext(params);

        StringWriter sw = new StringWriter();

        URL resource = this.getClass().getClassLoader().getResource("template/Entity.java.vm");
        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);

        Template template = Velocity.getTemplate("template/Entity.java.vm", "UTF-8");
        template.merge(context, sw);
        return sw;
    }

    @Override
    public void writePosition(String dataSourceKey, TemplateEntity templateEntity, UserConfigEntity userConfigEntity, TableModel tableModel, StringWriter writer) throws FileNotFoundException {
        String filePath = templateEntity.getTemplatePosition() + File.separator + templateEntity.getProjectCodeRelativePosition() + File.separator + tableModel.getClassPackageName().replace(".", File.separator);
        filePath = filePath.replaceAll("\\.", File.separator) + ".java";

        String s = writer.toString();
        System.out.println(s);
        System.out.println(filePath);
    }

}
