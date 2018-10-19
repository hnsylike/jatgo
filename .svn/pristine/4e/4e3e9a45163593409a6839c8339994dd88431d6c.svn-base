package com.kafang.atgo.restful.util;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author xuejian.sun
 * @date 2018/10/10 14:00
 */
public final class HttpStatusConvert {

    public static Response.Status fromCode(int code) {
        Optional<Response.Status> optional = Arrays.stream(Response.Status.values()).filter(status -> status.getStatusCode() == code
        ).findFirst();
        return Optional
                .ofNullable(optional.get())
                .orElse(Response.Status.INTERNAL_SERVER_ERROR);
    }
}
