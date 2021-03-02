package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SpringfoxConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                // .groupName("NomenclatureService")
                .select()
                // .apis(RequestHandlerSelectors.basePackage("org.springframework.data.rest.webmvc"))

                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(new ApiInfo("Users services",
                        "Ecoles Microservice", "1.0.0", null,
                        new Contact("TOP Lamine", "https://twitter.com/lamzo", null), null, null));
    }
}
