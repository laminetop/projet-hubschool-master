package sn.hubschool.nomenclature.config;

import sn.hubschool.nomenclature.exception.ExceptionFactory;
import sn.hubschool.nomenclature.exception.IExceptionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alygueye on 30/12/2016.
 */
@Configuration
public class TransverseConfig {

    @Bean
    public IExceptionFactory factory() {
        return new ExceptionFactory();
    }
}
