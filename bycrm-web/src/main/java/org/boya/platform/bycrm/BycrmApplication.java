package org.boya.platform.bycrm;

import org.hswebframework.web.authorization.listener.event.AuthorizingHandleBeforeEvent;
import org.hswebframework.web.loggin.aop.EnableAccessLogger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * main class
 * @author jzl
 */
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableCaching
@EnableAccessLogger
@ComponentScan("org.boya.platform.bycrm")
@MapperScan(basePackages = "org.boya.platform.bycrm.impl")
public class BycrmApplication implements ApplicationListener<AuthorizingHandleBeforeEvent> {

	public static void main(String[] args) {
		SpringApplication.run(BycrmApplication.class, args);
	}

	@Override
	public void onApplicationEvent(AuthorizingHandleBeforeEvent event) {
		//admin 拥有所有权限
		if(event.getContext().getAuthentication().getUser().getUsername().equals("admin")){
			event.setAllow(true);
		}
	}
}
