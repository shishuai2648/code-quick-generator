package com.person.quick.service.impl;

import com.person.quick.entity.ColumnAttrRelEntity;
import com.person.quick.entity.TableEntity;
import com.person.quick.entity.TemplateEntity;
import com.person.quick.entity.UserConfigEntity;
import com.person.quick.model.TableModel;
import com.person.quick.service.ColumnAttrRelService;
import com.person.quick.service.DataHandlerService;
import com.person.quick.service.GeneratorService;
import com.person.quick.service.TemplateService;
import com.person.quick.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.io.File;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    private DataHandlerService dataHandlerService;

    @Autowired
    private ColumnAttrRelService columnAttrRelService;


    @Override
    public List<File> generatorCode(String dataSourceKey, String tableName, String userKey, String moduleName) throws Exception {

        TableEntity tableEntity = dataHandlerService.getDatabase(dataSourceKey, tableName);

        List<TemplateEntity> templates = dataHandlerService.templates(dataSourceKey);

        UserConfigEntity userConfig = dataHandlerService.getUserConfig(userKey);

        Map<String, Object> params = dataHandlerService.loadProperties(dataSourceKey);

        List<ColumnAttrRelEntity> all = columnAttrRelService.getAll();
        Map<String, String> columnAttrMap = all.stream().collect(Collectors.toMap(ColumnAttrRelEntity::getColumnType, ColumnAttrRelEntity::getColumnType));

        for (TemplateEntity template : templates) {

            moduleName = dataHandlerService.tableNameToModule(tableName, template, userConfig, moduleName);
            TableModel tableModel = dataHandlerService.formatTable(tableEntity, template, userConfig, moduleName, columnAttrMap);
            params.putAll(MapUtils.objectToMap(tableModel));

            StringWriter stringWriter = dataHandlerService.renderPage(dataSourceKey, template.getTemplatePosition(), params);

            dataHandlerService.writePosition(dataSourceKey, template, userConfig, tableModel, stringWriter);
        }


        return null;
    }
}
