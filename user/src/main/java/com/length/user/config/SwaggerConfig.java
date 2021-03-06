package com.length.user.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //开启在线文档
public class SwaggerConfig {

    // 声明api 文档的属性 构建器
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("marrycode")
                .description("xxgc_hui")
                .termsOfServiceUrl("http://www.baidu.com")
                .version("1.0.0")
                .build();
    }

    // 核心配置信息
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.length.user.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}