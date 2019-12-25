package com.emergon.config;

/*
References:
https://www.javaspringclub.com/spring-mvc-hibernate-mysql-example/

Optional:
http://www.javasavvy.com/spring-4-mvc-hibernate-jpa-java-config-tutorial/
https://howtodoinjava.com/jpa/spring-hibernate-jpa-configuration-example/   Full XML Example
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.emergon")
public class MyWebAppConfig implements WebMvcConfigurer {//WebMvcConfigurerAdapter is deprecated in Spring 5
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        //viewResolver.setViewClass(JstlView.class);//Not any more required
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        registry.viewResolver(viewResolver);
//    }
}
