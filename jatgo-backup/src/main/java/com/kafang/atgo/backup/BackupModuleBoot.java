package com.kafang.atgo.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class BackupModuleBoot {

	public static void main(String[] args) {
		log.info("BackupModuleBoot starting....");
		SpringApplication.run(BackupModuleBoot.class, args);
	}

}
