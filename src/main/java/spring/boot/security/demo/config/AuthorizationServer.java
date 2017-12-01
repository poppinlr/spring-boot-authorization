package spring.boot.security.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    private PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // @formatter:off
        clients.inMemory().withClient("tonr")
//                .resourceIds(CommonConstant.SPARKLR_RESOURCE_ID)
                .authorizedGrantTypes("authorization_code")
//                .authorities("ROLE_CLIENT")
                .scopes("read", "write")
                .secret(encoder.encode("secret"))
                .and()
                .withClient("tonr2")
//                .resourceIds(CommonConstant.SPARKLR_RESOURCE_ID)
                .authorizedGrantTypes("client_credentials")
//                .authorities("ROLE_CLIENT")
                .scopes("read", "write")
                .secret(encoder.encode("secret2"))

//                .withClient("tonr2")
//                .resourceIds(CommonConstant.SPARKLR_RESOURCE_ID)
//                .authorizedGrantTypes("client_credentials", "refresh_token")
////                .authorities("ROLE_CLIENT")
//                .scopes("read", "write")
//                .secret(encoder.encode("secret2"))
//                .withClient("tonr-with-redirect")
//                .resourceIds(SPARKLR_RESOURCE_ID)
//                .authorizedGrantTypes("authorization_code", "implicit")
//                .authorities("ROLE_CLIENT")
//                .scopes("read", "write")
//                .secret("secret")
//                .redirectUris(tonrRedirectUri)
//                .and()
//                .withClient("my-client-with-registered-redirect")
//                .resourceIds(SPARKLR_RESOURCE_ID)
//                .authorizedGrantTypes("authorization_code", "client_credentials")
//                .authorities("ROLE_CLIENT")
//                .scopes("read", "trust")
//                .redirectUris("http://anywhere?key=value")
//                .and()
//                .withClient("my-trusted-client")
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//                .scopes("read", "write", "trust")
//                .accessTokenValiditySeconds(60)
//                .and()
//                .withClient("my-trusted-client-with-secret")
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//                .scopes("read", "write", "trust")
//                .secret("somesecret")
//                .and()
//                .withClient("my-less-trusted-client")
//                .authorizedGrantTypes("authorization_code", "implicit")
//                .authorities("ROLE_CLIENT")
//                .scopes("read", "write", "trust")
//                .and()
//                .withClient("my-less-trusted-autoapprove-client")
//                .authorizedGrantTypes("implicit")
//                .authorities("ROLE_CLIENT")
//                .scopes("read", "write", "trust")
                .autoApprove(true);
        // @formatter:on
    }

}
