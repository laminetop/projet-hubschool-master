package sn.hubschool.nomenclature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringfoxConfiguration {

  @Bean
  public Docket api(){
    return new Docket(DocumentationType.SWAGGER_2)
        //.groupName("NomenclatureService")
        .select()
          .apis(RequestHandlerSelectors.basePackage("sn.hubschool.nomenclature"))
          .paths(PathSelectors.any())
        .build()
          .apiInfo(new ApiInfo("Nomenclature services",
            "Nomenclature Microservice", "1.0.0", null,
            new Contact("Aly Gueye", "https://twitter.com/aly736", null),null, null));
  }
}
