package com.person.quick.service;

import java.io.File;
import java.util.List;

public interface GeneratorService {

    List<File> generatorCode(String dataSourceKey, String tableName, String userKey, String moduleName) throws Exception;
}
