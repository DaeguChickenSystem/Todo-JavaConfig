package com.java_config_practice.conf.interceptor;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.apress.springrecipes.court")
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(measurementInterceptor())
                .excludePathPatterns("/loginProcess",  "/resources/**");
    }

    @Bean
    public AuthtInterceptor measurementInterceptor() {
        return new AuthtInterceptor();
    }

   
}
