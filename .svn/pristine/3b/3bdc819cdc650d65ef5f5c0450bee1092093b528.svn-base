package com.kafang.atgo.restful.config;

import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.jaxrs.FastJsonProvider;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 * @author xuejian.sun
 * @date 2018/10/13 18:45
 */
@Slf4j
@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FastJsonHttpMessageConvert extends FastJsonProvider {

    public FastJsonHttpMessageConvert(SerializeFilter... serializeFilter){
        super();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializeFilters(serializeFilter);
        super.setFastJsonConfig(config);
        super.setPretty(true);
    }

    public FastJsonHttpMessageConvert() {
        super();
    }
}
