package com.person.quick.utils;

import com.person.quick.entity.ColumnEntity;
import com.person.quick.entity.TableEntity;
import com.person.quick.entity.TemplateEntity;
import com.person.quick.entity.UserConfigEntity;
import com.person.quick.enums.Constants;
import com.person.quick.enums.YesNo;
import com.person.quick.model.ColumnModel;
import com.person.quick.model.TableModel;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableModuleUtil {

    private static final Pattern pattern = Pattern.compile("[a-zA-Z][a-zA-Z_0-9]+");

    public static TableModel formatTable(TableEntity tableEntity, TemplateEntity templateEntity, UserConfigEntity userConfigEntity, String moduleName, Map<String, String> columnAttrMap) throws Exception {

        String tableName = getTableName(tableEntity, templateEntity, moduleName);

        TableModel tableModel = new TableModel();
        tableModel.setTableName(tableEntity.getTableName());
        tableModel.setTableComment(tableEntity.getTableComment());
        tableModel.setClassName(getClassName(tableName));
        tableModel.setClassname(getClassname(tableName));
        tableModel.setAuthor(userConfigEntity.getAuthor());
        tableModel.setEmail(userConfigEntity.getEmail());
        tableModel.setModuleName(moduleName);

        tableModel.setClassPackage(getClassPackage(tableEntity, templateEntity, moduleName));
        tableModel.setClassPackageName(tableModel.getClassPackage() + "." + tableModel.getClassName() + templateEntity.getTemplateFileName());

        List<ColumnModel> columns = getColumns(tableEntity, templateEntity, userConfigEntity, columnAttrMap);

        tableModel.setColumns(columns);

        return tableModel;
    }

    public static List<ColumnModel> getColumns(TableEntity tableEntity, TemplateEntity templateEntity, UserConfigEntity userConfigEntity, Map<String, String> columnAttrMap) throws Exception {
        List<ColumnEntity> columns = tableEntity.getColumns();

        List<ColumnModel> columnModels = new ArrayList<>();

        for (ColumnEntity column : columns) {

            ColumnModel columnModel = new ColumnModel();
            columnModel.setDataType(column.getDataType());
            columnModel.setColumnName(column.getColumnName());
            columnModel.setColumnComment(column.getColumnComment());
            columnModel.setColumnKey(column.getColumnKey());
            columnModel.setExtra(column.getExtra());

            String attrType = columnAttrMap.get(column.getDataType());
            if (StringUtils.isBlank(attrType)) {
                throw new Exception("出现未知属性类型，请配置后重试");
            }
            columnModel.setAttrType(attrType);

            String columnJavaName = columnToJava(column.getColumnName());
            columnModel.setAttrname(columnJavaName);

            //是否主键
            if ("PRI".equalsIgnoreCase(column.getColumnKey())) {
                columnModel.setIsPK(Boolean.TRUE);
            }
            columnModels.add(columnModel);
        }
        return columnModels;
    }

    /**
     * 列名转换成Java属性名
     */
    public static String columnToJava(String columnName) {
        return StringUtils.uncapitalize(WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", ""));
    }


    public static String getClassPackage(TableEntity tableEntity, TemplateEntity templateEntity, String moduleName) {
        String modulePackage = templateEntity.getModulePackage();
        return modulePackage.replace(Constants.MODULE_NAME_REX, moduleName);
    }

    public static String getTableName(TableEntity tableEntity, TemplateEntity templateEntity, String moduleName) {
        String tableName = tableEntity.getTableName();
        if (YesNo.NO.getValue().equals(templateEntity.getModuleNameShow())) {
            tableName = tableName.replace(moduleName, "").replace("__", "_");
        }

        Matcher matcher = pattern.matcher(tableName);

        if (matcher.find()) {
            tableName = matcher.group();
        }
        return tableName;
    }

    public static String getClassName(String tableName) {
        return WordUtils.capitalizeFully(tableName, new char[]{'_'}).replace("_", "");

    }

    public static String getClassname(String tableName) {
        return StringUtils.uncapitalize(getClassName(tableName));
    }


    public static String getModuleName(String tableNameRex, String tableName) {
        String handlerTableName = tableName.toLowerCase();
        for (String suffix : Constants.SUFFIX) {
            handlerTableName = handlerTableName.replace(suffix, "");
        }

        String[] split = tableNameRex.split("_");

        if (StringUtils.isBlank(tableNameRex)) {
            return split[0];
        }

        int i = 0;
        for (; i < split.length; i++) {
            if (Constants.MODULE_NAME_REX.equals(split[i])) {
                break;
            }
        }

        String[] handler = handlerTableName.split("_");

        if (handler.length - 1 >= i) {
            return handler[i];
        }
        return handler[0];

    }
}
