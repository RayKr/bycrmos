package org.boya.platform.bycrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
@MapperScan(basePackages = "org.boya.platform.bycrm.impl")
public class BycrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(BycrmApplication.class, args);
	}
}
