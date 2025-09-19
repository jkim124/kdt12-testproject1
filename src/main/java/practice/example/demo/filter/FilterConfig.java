package practice.example.demo.filter;

import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
  @Bean
  public FilterRegistrationBean<Filter> firstFilter() {
    FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

    bean.setFilter(new FirstFilter()); // 적용할 필터 지정
    bean.setOrder(1);  // 필터 실행 순서
    bean.addUrlPatterns("/test");  // 어떤 url에 적용할지

    return bean;
  }

  @Bean
  public FilterRegistrationBean<Filter> secondFilter() {
    FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

    bean.setFilter(new SecondFilter());
    bean.setOrder(2);
    bean.addUrlPatterns("/test");

    return bean;
  }
/*
  @Bean
  public FilterRegistrationBean<Filter> thirdFilter() {
    FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

    bean.setFilter(new ThirdFilter());
    bean.setOrder(3);
    bean.addUrlPatterns("/test");

    return bean;
  }*/
}