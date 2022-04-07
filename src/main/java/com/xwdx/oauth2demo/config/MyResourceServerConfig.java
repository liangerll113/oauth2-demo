package com.xwdx.oauth2demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author metinkong
 * @date 2022/4/7 10:32
 **/
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/hello").authorizeRequests()
                .antMatchers(HttpMethod.GET, "/hello/read").access("#oauth2.hasScope('read')")
                .antMatchers(HttpMethod.GET, "/hello/write").access("#oauth2.hasScope('write')");
    }

}
