package com.ruicheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
//声明一个zuul代理，该代理使用Ribbon来定位注册在Eureka server中的微服务，
//同时该代理还整合了Hystrix，实现容错，所有经过Zuul的请求都会在Hystrix命令中执行
@EnableZuulProxy
@SpringBootApplication
public class ZuulServerApplication {

    public static void  main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }

    /**
     * 解决前后端分离跨域问题
     *
     * @return
     */
 /*   @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
*/
}
