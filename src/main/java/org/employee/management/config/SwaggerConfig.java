package org.employee.management.config;

import org.employee.management.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant(Constants.ANT_PATH_SELECTOR))
                .apis(RequestHandlerSelectors.basePackage(Constants.BASE_PACKAGE))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                Constants.API_TITLE,
                Constants.API_DESCRIPTION,
                Constants.API_VERSION,
                Constants.API_TERM_OF_SERVICE,
                new springfox.documentation.service.Contact("Manish Kumar", "HCL Technologies", "dasmanish92@gmail.com"),
                Constants.API_LICENCE,
                Constants.API_LICENCE_URL,
                Collections.emptyList());

    }

}
