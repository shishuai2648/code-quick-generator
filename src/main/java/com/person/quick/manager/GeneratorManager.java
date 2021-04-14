package com.person.quick.manager;

import java.io.File;
import java.util.List;

public interface GeneratorManager {

    List<File> generatorCode(String dataSourceKey, String tableName, String userKey, String moduleName) throws Exception;
}
