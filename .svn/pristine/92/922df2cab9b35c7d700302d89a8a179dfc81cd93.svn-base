package com.kafang.atgo.restful;

import com.kafang.atgo.persistence.db.dao.api.AgAccountDao;
import com.kafang.atgo.persistence.db.dao.impl.AgAccountDaoImpl;
import com.kafang.atgo.persistence.factory.ConnectionFactory;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import com.kafang.atgo.restful.config.JerseyConfig;
import com.kafang.atgo.restful.config.JerseySwaggerConfig;
import com.kafang.atgo.restful.config.SwaggerProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xuejian.sun on 2018/9/16.
 */
@Slf4j
@Configuration
public class AppConfiguration {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Autowired
    private JerseyConfig jerseyConfig;

    @Value("${atgo.db.url}")
    private String dbUrl;

    @Value("${atgo.db.max.conn.free:10}")
    private int dbMaxConnFree;

    @ConditionalOnProperty(
            name = "jersey.swagger.enable",
            havingValue = "true"
    )
    @Bean
    public JerseySwaggerConfig jerseySwaggerConfig() {
        return new JerseySwaggerConfig(jerseyConfig, swaggerProperties);
    }

    @Bean
    public OrmliteDaoFactory daoFactory() {
        log.info("Setting dbUrl as {}", dbUrl);
        ConnectionFactory connectionFactory = new ConnectionFactory(dbUrl, dbMaxConnFree);
        return new OrmliteDaoFactory(connectionFactory);
    }

    @Bean
    public AgAccountDao agAccountDao() {
        return new AgAccountDaoImpl(daoFactory());
    }
}
