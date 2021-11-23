package com.project.yumyum;

import com.project.yumyum.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class YumyumApplication {

	public static void main(String[] args) {
		SpringApplication.run(YumyumApplication.class, args);
	}

}
