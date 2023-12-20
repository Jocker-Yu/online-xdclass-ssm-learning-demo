package com.xdclass.net.onlinexdclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xdclass.net.onlinexdclass.mapper")
public class OnlineXdclassSsmLearningDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineXdclassSsmLearningDemoApplication.class, args);
	}

}
