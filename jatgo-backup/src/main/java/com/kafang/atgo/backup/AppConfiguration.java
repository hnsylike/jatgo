package com.kafang.atgo.backup;

import com.kafang.atgo.persistence.factory.ConnectionFactory;
import com.kafang.atgo.persistence.factory.OrmliteDaoFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AppConfiguration {

	@Value("${atgo.db.url}")
	private String dbUrl;

	@Value("${atgo.db.max.conn.free:10}")
	private int dbMaxConnFree;

	@Bean
	public OrmliteDaoFactory daoFactory() {
		log.info("Setting dbUrl as {}", dbUrl);
		ConnectionFactory connectionFactory = new ConnectionFactory(dbUrl, dbMaxConnFree);
		return new OrmliteDaoFactory(connectionFactory);
	}

}
