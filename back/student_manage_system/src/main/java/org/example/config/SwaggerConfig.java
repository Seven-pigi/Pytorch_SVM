package org.example.config;

import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
@SuppressWarnings("all")
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                ;
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("churry", "http://localhost:8001/#/", "1344081281@qq.com");
        return new ApiInfo("学生管理系统API文档",
                "我命由我不由天",
                "v1.0",
                "http://localhost:8001/#/",
                 contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}
