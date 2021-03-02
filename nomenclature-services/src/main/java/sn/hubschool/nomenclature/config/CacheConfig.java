package sn.hubschool.nomenclature.config;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by alygueye on 29/12/2016.
 */
@Configuration
public class CacheConfig {

  @Bean
  public EhCacheManagerFactoryBean ehcache() {
    EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
    cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
    cmfb.setShared(true);
    return cmfb;
  }


  @Bean
  public EhCacheCacheManager cacheManager() {
    return new EhCacheCacheManager(ehcache().getObject());
  }

  @Bean(name = "service-cache")
  public EhCacheFactoryBean serviceCache() {
    EhCacheFactoryBean ehCacheFactoryBean = new EhCacheFactoryBean();
    ehCacheFactoryBean.setCacheManager(ehcache().getObject());
    ehCacheFactoryBean.setCacheName("service");
    return ehCacheFactoryBean;
  }

  @Bean(name = "service-cacheDate")
  public EhCacheFactoryBean serviceCacheDate() {
    EhCacheFactoryBean ehCacheFactoryBean = new EhCacheFactoryBean();
    ehCacheFactoryBean.setCacheManager(ehcache().getObject());
    ehCacheFactoryBean.setCacheName("service_date");
    return ehCacheFactoryBean;
  }

  @Bean(name = "facade-cache")
  public EhCacheFactoryBean facadeCache() {
    EhCacheFactoryBean ehCacheFactoryBean = new EhCacheFactoryBean();
    ehCacheFactoryBean.setCacheManager(ehcache().getObject());
    ehCacheFactoryBean.setCacheName("transport");
    return ehCacheFactoryBean;
  }


}
