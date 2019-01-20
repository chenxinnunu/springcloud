package com.ruicheng.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author: 594781919@qq.com
 * @date: 2018/5/24
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 访问下面路径无需Token认证
                .antMatchers("/auth-server/**", "/webjars/**", "/swagger-resources/**", "/**/v2/api-docs")
                .permitAll()
                // 除了上面配置的路径都需要Token认证
                .anyRequest()
                .authenticated()
                .and()
                // 暂时禁用CSRF，否则无法提交表单
                .csrf().disable();
    }
}
