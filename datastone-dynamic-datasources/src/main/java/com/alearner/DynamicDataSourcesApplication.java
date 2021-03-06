package com.alearner;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-14 12:44
 **/
@EnableSwagger2
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableTransactionManagement(order=2)  //设置事务执行顺序(需要在切换数据源之后，否则只走默认库)
@MapperScan(basePackages = "com.alearner.mappers.*")
@EnableEurekaClient
public class DynamicDataSourcesApplication {
    public static void main(String [] args){
        SpringApplication.run(DynamicDataSourcesApplication.class,args);
    }
}
