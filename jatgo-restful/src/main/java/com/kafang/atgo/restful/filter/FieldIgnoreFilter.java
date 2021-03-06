package com.kafang.atgo.restful.filter;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.kafang.atgo.restful.annotation.FastJsonIgnore;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;


/**
 * @author xuejian.sun
 * @date 2018/10/13 18:20
 */
@Slf4j
public class FieldIgnoreFilter implements PropertyFilter {

    @Override
    public boolean apply(Object object, String name, Object value) {
        Field field;
        try {
            field = object.getClass().getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            log.warn("fastJson 序列化 {},未找到{}字段: {}",object.getClass().getName(),name);
            return false;
        }
        return !field.isAnnotationPresent(FastJsonIgnore.class);
    }
}
