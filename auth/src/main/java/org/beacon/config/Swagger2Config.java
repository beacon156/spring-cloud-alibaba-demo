package org.beacon.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableKnife4j
public class Swagger2Config {


    @Bean
    public Docket createRestApi() {
        List<Parameter> paraList = new ArrayList<>();
        ParameterBuilder paraBuilder = new ParameterBuilder();
        springfox.documentation.service.Parameter param1 =
                paraBuilder
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .required(false)
                        .build();
        paraList.add(param1);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.beacon"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(paraList);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("响应式布局")
                .description("响应式布局")
                .termsOfServiceUrl("http://localhost:11101/")
                .contact(new Contact("vinshine", "http://vinshine.cn", "vinshine@aliyun.com"))
                .version("0.0.1")
                .build();
    }
}