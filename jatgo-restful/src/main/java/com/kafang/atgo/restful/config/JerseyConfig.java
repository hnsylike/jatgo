package com.kafang.atgo.restful.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.jaxrs.FastJsonProvider;
import com.kafang.atgo.restful.filter.*;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

/**
 * Created by User on 2018/9/17.
 */
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        FastJsonHttpMessageConvert convert = new FastJsonHttpMessageConvert(new FieldIgnoreFilter());

        register(RequestContextFilter.class)
                .register(RequestFilter.class)
                .register(CorsFilter.class)
                .register(convert);
        workaroundPackages("com.kafang.atgo.restful.resource");
//        register(MultiPartFeature.class);
        register(AtgoExceptionMapper.class);
        register(AuthorizationFilter.class);

    }

    //to solve the Spring Boot and Jersey integration issue, as per https://www.jianshu.com/p/b00bdb90b796
    private void workaroundPackages(String scanPackage) {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        // add more annotation filters if you need
        scanner.addIncludeFilter(new AnnotationTypeFilter(Path.class));
        scanner.addIncludeFilter(new AnnotationTypeFilter(Provider.class));
        this.registerClasses(scanner.findCandidateComponents(scanPackage).stream()
                .map(beanDefinition -> ClassUtils
                        .resolveClassName(beanDefinition.getBeanClassName(), this.getClassLoader()))
                .collect(Collectors.toSet()));

    }

    private FastJsonProvider fastJsonProvider(){
        FastJsonProvider fastJsonProvider = new FastJsonProvider();
        fastJsonProvider.setPretty(true);
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializeFilters(new FieldIgnoreFilter());
        fastJsonProvider.setFastJsonConfig(config);
        return fastJsonProvider;
    }
}
