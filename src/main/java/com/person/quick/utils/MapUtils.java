package com.person.quick.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    public static Map<String, Object> objectToMap(Object obj) {

        Map<String, Object> map = new HashMap<>();
        try {
            String json = JsonUtils.objectToJson(obj);
            JSONObject jsonObject = JSONObject.parseObject(json);
            map.putAll(jsonObject);

        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        return map;

    }

}
