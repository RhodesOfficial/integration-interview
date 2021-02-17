package com.calpis.interview.mmybatis;

import com.calpis.interview.mmybatis.service.HelloService;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.mmybatis.spring.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/16 23:47
 */
@ComponentScan("com.calpis")
@Import(MyImportBeanDefinitionRegistrar.class)
public class MyApplication {

    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        // todo
        return new DefaultSqlSessionFactory(new Configuration());
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MyApplication.class);
        applicationContext.refresh();
        HelloService helloService = (HelloService) applicationContext.getBean("HelloService");
        helloService.sayHello();
    }
}
