package com.anzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;  
/**
 * 1、@SpringBootApplication 默认扫描同包或子包下内容
 * 2、默认端口号8080
 * @author anzy
 *
 */
@MapperScan(basePackages = { "com.anzy.bussiness.*.dao" }, sqlSessionFactoryRef = "sqlSessionFactory"	)
@SpringBootApplication
public class Application {
	public static void main(String[] args) {  
		SpringApplication.run(Application.class, args);
    }

//	@Override
//	public void customize(ConfigurableEmbeddedServletContainer arg0) {
//		// TODO Auto-generated method stub
//		arg0.setPort(8088);
//		arg0.setSessionTimeout(8000);
//		
//	}  
}
