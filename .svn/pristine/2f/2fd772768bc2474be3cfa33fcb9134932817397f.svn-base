package com.kafang.atgo.restful.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.origin.OriginTrackedValue;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

/**
 * system env print
 *
 * @author xuejian.sun
 * @date 2018/10/12 20:36
 */
@Slf4j
@Component
public class ApplicationEnvironmentPrint implements ApplicationListener<ApplicationPreparedEvent> {

    private static final String defaultProfileName = "application.properties";

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {

        ConfigurableEnvironment environment = applicationPreparedEvent.getApplicationContext().getEnvironment();

        String profileName = defaultProfileName;

        String[] activeProfiles = environment.getActiveProfiles();

        if(activeProfiles != null && activeProfiles.length == 1) {
            profileName = String.format("application-%s.properties", activeProfiles[0]);
        }
        /**
         * 输出 active file 内容
         */
        propertyContentPrint(getProperty(profileName,environment), profileName);

        log.info("--");
        log.info("--");

        if(!profileName.equals(defaultProfileName)) {
            //输出 default profile 内容
            propertyContentPrint(getProperty(defaultProfileName,environment), "default");
            log.info("--");
            log.info("--");
        }

        log.info("======================= System Environment =======================");
        environment
                .getSystemEnvironment()
                .forEach((k, v) -> log.info("{} ====================>>: {}", k, v));

        log.info("======================= System Environment =======================");
    }

    private void propertyContentPrint(LinkedHashMap<String, OriginTrackedValue> profile, String profileName) {
        if(profile == null){
            log.warn("{} not exists",profileName);
            return;
        }

        log.info("======================= {} Profile Environment =======================", profileName);

        profile
                .forEach((k, v) -> log.info("{} ====================>>: {}", k, v.getValue()));

        log.info("======================= {} Profile Environment =======================", profileName);
    }

    /**
     * 获取properties文件内容
     * @param profileName
     * @param environment
     * @return
     */
    private LinkedHashMap<String, OriginTrackedValue> getProperty(String profileName, ConfigurableEnvironment environment){

        return (LinkedHashMap<String, OriginTrackedValue>)
                environment.getPropertySources()
                        .get("applicationConfig: [classpath:/" + profileName + "]")
                        .getSource();
    }
}
