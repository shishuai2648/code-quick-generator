package com.person.quick.factory;

import com.person.quick.enums.DbType;
import com.person.quick.mapper.BaseSqlQueryMapper;
import com.person.quick.mapper.MySqlQueryMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shishuai04
 */
@Component
public class BaseSqlQueryFactory {

    @Resource
    private MySqlQueryMapper mySqlQueryMapper;

    private static Map<DbType, BaseSqlQueryMapper> sqlQueryMapperMap = new HashMap<>();

    @PostConstruct
    public void init() {
        sqlQueryMapperMap.put(DbType.MYSQL, mySqlQueryMapper);
    }

    public static BaseSqlQueryMapper getSqlQueryMapper(DbType dbType) {
        return sqlQueryMapperMap.get(dbType);
    }
}
