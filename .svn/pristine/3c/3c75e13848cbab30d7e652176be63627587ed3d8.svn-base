package com.kafang.atgo.restful.filter;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import java.io.IOException;

/**
 * Created by xuejian.sun on 2018/9/21.
 */
@Slf4j
public class RequestFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        log.info("============== from web request ==============");
        log.info("method:{} | path:{}",containerRequestContext.getMethod(),containerRequestContext.getUriInfo().getPath());
    }
}
