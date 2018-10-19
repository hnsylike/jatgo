package com.kafang.atgo.restful.sql;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xuejian.sun
 * @date 2018/10/17 21:03
 */
@Sql(
        scripts = "classpath:database/clean-client-table",
        config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED),
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
@Sql(
        scripts = "classpath:database/clean-client-table",
        config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED),
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CleanClientTable {
}
