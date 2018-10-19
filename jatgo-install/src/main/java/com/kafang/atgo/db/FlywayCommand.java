package com.kafang.atgo.db;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author xuejian.sun
 * @date 2018/10/15
 */
@Slf4j
public enum FlywayCommand {
    /**
     *migrate
     */
    MIGRATE("migrate","数据库升级"),
    /**
     * clean
     */
    CLEAN("clean","数据库清理"),
    /**
     * info
     */
    INFO("info","数据库详情"),
    /**
     * validate
     */
    VALIDATE("validate","校验基本配置");

    private String command;

    private String description;

    FlywayCommand(String command,String description) {
        this.command = command;
        this.description = description;
    }

    public static Optional<FlywayCommand> from(String command) {
        return Arrays.stream(FlywayCommand.values())
                .filter(flywayCommand
                        -> flywayCommand.name().equals(command)
                        || flywayCommand.command.equals(command))
                .findFirst();
    }

    public static void printCommand(){
        log.info("======================== 数据库操作COMMAND ==================================");
        Arrays.stream(FlywayCommand.values())
                .forEach((flywayCommand -> log.info("指令:[{},{}] =========>> {}",flywayCommand.name(),flywayCommand.command,flywayCommand.description)));
    }
}
