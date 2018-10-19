package com.kafang.atgo.persistence.json;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;

import io.ffreedom.common.charset.Charsets;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class JsonSerializationUtil {

	public static String InputStreamToJson(InputStream in) throws IOException {
		return IOUtils.toString(in, Charsets.UTF8);
	}

	public static String objToJson(Object obj) {
		return JSON.toJSONString(obj);
	}

	public static <T> T jsonToObj(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}

	public static <T> List<T> jsonToList(String json, Class<T> clazz) {
		return JSON.parseArray(json, clazz);
	}

	public static void main(String[] args) {
		log.info(System.getProperty("user.dir"));
	}

}
