package com.person.quick.manager.impl;

import com.person.quick.adapter.GeneratorAdapter;
import com.person.quick.entity.ColumnAttrRelEntity;
import com.person.quick.entity.DataSourceEntity;
import com.person.quick.entity.TableEntity;
import com.person.quick.entity.TemplateEntity;
import com.person.quick.entity.UserConfigEntity;
import com.person.quick.manager.GeneratorManager;
import com.person.quick.model.TableModel;
import com.person.quick.service.ColumnAttrRelService;
import com.person.quick.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GeneratorManagerImpl implements GeneratorManager {

    @Autowired
    private GeneratorAdapter generatorAdapter;

    @Autowired
    private ColumnAttrRelService columnAttrRelService;


    @Override
    public List<File> generatorCode(String dataSourceKey, String tableName, String userKey, String moduleName) throws Exception {


        DataSourceEntity database = generatorAdapter.getDatabase(dataSourceKey);

        TableEntity tableEntity = generatorAdapter.getTableInfo(dataSourceKey, database, tableName);

        List<TemplateEntity> templates = generatorAdapter.templates(dataSourceKey);

        UserConfigEntity userConfig = generatorAdapter.getUserConfig(dataSourceKey, userKey);

        Map<String, Object> params = generatorAdapter.loadProperties(dataSourceKey);

        List<ColumnAttrRelEntity> all = columnAttrRelService.getAll();
        Map<String, String> columnAttrMap = all.stream().collect(Collectors.toMap(ColumnAttrRelEntity::getColumnType, ColumnAttrRelEntity::getColumnType));

        for (TemplateEntity template : templates) {

            moduleName = generatorAdapter.tableNameToModule(tableName, template, userConfig, moduleName);
            TableModel tableModel = generatorAdapter.formatTable(tableEntity, template, userConfig, moduleName, columnAttrMap);
            params.putAll(MapUtils.objectToMap(tableModel));

            StringWriter stringWriter = generatorAdapter.renderPage(dataSourceKey, template.getTemplatePosition(), params);

            generatorAdapter.writePosition(dataSourceKey, template, userConfig, tableModel, stringWriter);
        }


        return null;
    }
}
