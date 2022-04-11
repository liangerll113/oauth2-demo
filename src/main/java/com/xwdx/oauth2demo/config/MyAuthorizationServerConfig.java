package com.xwdx.oauth2demo.config;

import com.xwdx.oauth2demo.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * @author metinkong
 * @date 2022/4/7 10:38
 **/
@Configuration
@EnableAuthorizationServer
public class MyAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("client")
                .redirectUris("http://www.xwdx.site")
                .scopes("read", "write")
                .secret("secret")
                .authorizedGrantTypes("authorization_code", "password", "implicit", "client_credentials","refresh_token");
    }

    @Override
    // 可以不配置，默认只支持post
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                .reuseRefreshTokens(false)
                .userDetailsService(myUserDetailService);
    }

}
