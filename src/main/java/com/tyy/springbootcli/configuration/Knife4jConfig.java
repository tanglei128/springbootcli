package com.tyy.springbootcli.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Knife4jConfig {
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        String groupName="3.X版本";
        Docket docket=new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        .title("这是knife4j API ")
                        .description("# 这里记录服务端所有的接口的入参，出参等等信息")
                        .termsOfServiceUrl("http://blog.oyqf.ltd")
                        .contact(new Contact("sky","http://blog.oyqf.ltd","2773289115@qq.com"))
                        .version("3.0")
                        .build())
                //分组名称
                .groupName(groupName)
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.tyy.springbootcli.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    private ApiInfo adminApiInfo() {

        //网页的相关属性
        return new ApiInfoBuilder()
                .title("后台管理系统-API文档")
                .description("本文档描述了后台管理系统服务接口定义")
                .version("1.0")
                .contact(new Contact("sky", "http://www.baidu.com", "783567954@qq.com"))
                .build();
    }
}


