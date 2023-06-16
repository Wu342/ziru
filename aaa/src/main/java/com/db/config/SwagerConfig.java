package com.db.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


/**
 * @author swedsn
 * @version 1.0
 * @date 2023-06-05 09:24
 */
@Configuration // 配置类
@EnableSwagger2
@EnableOpenApi
public class SwagerConfig {

    @Bean
    // 配置swagger的docket的bean实例
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //用于生成API信息
                .apiInfo(apiInfo())
                //select()函数返回一个ApiSelectorBuilder实例,用来控制接口被swagger做成文档
                .select()
                //用于指定扫描哪个包下的接口
                .apis(RequestHandlerSelectors.basePackage("com.db.controller"))
                //选择所有的API,如果你想只为部分API生成文档，可以配置这里
                .paths(PathSelectors.any())
                .build();
    }

    /*
     *用于定义API主界面的信息，比如可以声明所有的API的总标题、描述、版本
     */
    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("swedsn","https://swedsn.github.io/","1627319559@qq.com");
        return new ApiInfoBuilder()
                //用来自定义API的标题
                .title("自如项目的API文档")
                //用来描述整体的API
                .description("自如项目的API文档")
                //创建人信息
                .contact(contact)
                .version("1.0") //可以用来定义版本
                .build();
    }
}
