package com.simon.ss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = "com.simon.ss.dao")
@EnableTransactionManagement
@SpringBootApplication
public class ShardingjdbcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingjdbcDemoApplication.class, args);
	}

}
