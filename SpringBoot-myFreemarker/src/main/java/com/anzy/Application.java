package com.anzy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;  
/**
 * 1、@SpringBootApplication 默认扫描同包或子包下内容
 * 2、默认端口号8080
 * @author anzy
 *
 */
//@MapperScan( sqlSessionFactoryRef = "sqlSessionFactory"	)
@SpringBootApplication
public class Application {
	public static void main(String[] args) {  
		SpringApplication application = new SpringApplication(Application.class);
        Map<String, Object> defaultProperties = new HashMap<>();
        defaultProperties.put("com.anzy.bussiness.*.dao", "com.baomidou.mybatisplus.mapper");
        application.setDefaultProperties(defaultProperties);
        application.setWebEnvironment(true);
        application.run(args);
    }

//	@Override
//	public void customize(ConfigurableEmbeddedServletContainer arg0) {
//		// TODO Auto-generated method stub
//		arg0.setPort(8088);
//		arg0.setSessionTimeout(8000);
//		
//	}  
}
