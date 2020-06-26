package com.iwhalecloud.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 优先使用Jackson工具类(基于Jackson), fastjson存在一些问题
 *
 * @author zhenym
 * @date 2015-5-18
 */
public class JacksonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Json字符串转换成Map<String, ?>
     *
     * @param <T>
     * @param jsonStr
     * @return
     * @throws Exception
     */
    public static <T> Map<String, T> json2map(String jsonStr) throws IOException {
        return objectMapper.readValue(jsonStr, new TypeReference<Map<String, T>>() {});
    }

    /**
     * Json字符串转换成Map<String, String>
     *
     * @param jsonStr
     * @return
     * @throws Exception
     */
    public static Map<String, String> json2mapStr(String jsonStr) throws IOException {
        return objectMapper.readValue(jsonStr, new TypeReference<Map<String, String>>() {});
    }

    /**
     * Json字符串转换成Map<String, T>
     *
     * @param <T>
     * @param jsonStr
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz) throws IOException {
        Map<String, Map<String, ?>> map = objectMapper.readValue(jsonStr, new TypeReference<Map<String, Map<String, ?>>>() {
        });
        return map2map(map, clazz);
    }

    /**
     * Map<String, Map<String, ?>>转换成Map<String, T>
     *
     * @param <T>
     * @param fromMap
     * @param clazz
     * @return
     */
    public static <T> Map<String, T> map2map(Map<String, Map<String, ?>> fromMap, Class<T> clazz) {
        Map<String, T> result = new HashMap<String, T>();
        for (Entry<String, Map<String, ?>> entry : fromMap.entrySet()) {
            result.put(entry.getKey(), map2pojo(entry.getValue(), clazz));
        }
        return result;
    }

    /**
     * Map<String, String>转换成T
     *
     * @param <T>
     * @param map
     * @param clazz
     * @return
     */
    public static <T> T map2pojo(Map<String, ?> map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }

    /**
     * Json字符串转换成T
     *
     * @param <T>
     * @param jsonStr
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> T json2pojo(String jsonStr, Class<T> clazz) throws IOException {
        return objectMapper.readValue(jsonStr, clazz);
    }

    /**
     * 对象转换成Json字符串
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public static String obj2json(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * Json字符串转换成List
     *
     * @param <T>
     * @param jsonArrayStr
     * @return
     * @throws Exception
     */
    public static <T> List<T> json2list(String jsonArrayStr) throws IOException {
        return objectMapper.readValue(jsonArrayStr, new TypeReference<List<T>>() {
        });
    }

    /**
     * Json字符串转换成List<T>
     *
     * @param <T>
     * @param jsonArrayStr
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz) throws IOException {
        List<Map<String, ?>> list = objectMapper.readValue(jsonArrayStr, new TypeReference<List<Map<String, ?>>>() {});
        return list2list(list, clazz);
    }

    /**
     * List<Map<String, ?>>转换成List<T>
     *
     * @param <T>
     * @param fromList
     * @param clazz
     * @return
     */
    public static <T> List<T> list2list(List<Map<String, ?>> fromList, Class<T> clazz) {
        List<T> result = new ArrayList<T>();
        for (Map<String, ?> map : fromList) {
            result.add(map2pojo(map, clazz));
        }
        return result;
    }

    /**
     *  判断是否是json 字符串
     * @param jsonStr
     * @return
     */
    public final static boolean isValidJson(String jsonStr ) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(jsonStr);
            return true;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}