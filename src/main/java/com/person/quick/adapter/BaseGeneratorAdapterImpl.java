package com.person.quick.adapter;

import com.person.quick.entity.TableEntity;
import com.person.quick.entity.TemplateEntity;
import com.person.quick.entity.UserConfigEntity;
import com.person.quick.model.TableModel;
import com.person.quick.utils.DateUtils;
import com.person.quick.utils.TableModuleUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author shishuai04
 */
public abstract class BaseGeneratorAdapterImpl implements GeneratorAdapter {

    @Override
    public String tableNameToModule(String tableName, TemplateEntity templateEntity, UserConfigEntity userConfigEntity, String moduleName) {
        if (StringUtils.isNotBlank(moduleName)) {
            return moduleName;
        }

        String tableNameRex = templateEntity.getTableNameRex();
        return TableModuleUtil.getModuleName(tableNameRex, tableName);
    }

    @Override
    public Map<String, Object> loadProperties(String dataSourceKey) {
        Map<String, Object> param = new HashMap<>();
        param.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        return param;
    }


    @Override
    public TableModel formatTable(TableEntity tableEntity, TemplateEntity templateEntity, UserConfigEntity userConfigEntity, String moduleName, Map<String, String> columnAttrMap) throws Exception {
        return TableModuleUtil.formatTable(tableEntity, templateEntity, userConfigEntity, moduleName, columnAttrMap);
    }


    @Override
    public StringWriter renderPage(String dataSourceKey, String templatePosition, Map<String, Object> params) {

        VelocityContext context = new VelocityContext(params);

        StringWriter sw = new StringWriter();

        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);

        Template template = Velocity.getTemplate(templatePosition, "UTF-8");
        template.merge(context, sw);
        return sw;
    }

    @Override
    public void writePosition(String dataSourceKey, TemplateEntity templateEntity, UserConfigEntity userConfigEntity, TableModel tableModel, StringWriter writer) throws FileNotFoundException {

        String projectPosition = userConfigEntity.getProjectPosition();
        String projectCodeRelativePosition = templateEntity.getProjectCodeRelativePosition();
        String classPackagePath = tableModel.getClassPackageName().replace(".", File.separator);

        String filePath = projectPosition + File.separator + projectCodeRelativePosition + File.separator + classPackagePath + templateEntity.getTemplateSuffix();

//        String s = writer.toString();
//        System.out.println(s);
        System.out.println(filePath);
    }

}
