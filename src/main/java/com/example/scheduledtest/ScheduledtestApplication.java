package com.example.scheduledtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ServletComponentScan
@MapperScan("com.example.scheduledtest.dao")
public class ScheduledtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledtestApplication.class, args);
	}

}
