package com.devsuperior.dscatalog.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.devsuperior.dscatalog.components.JwtTokenEnhancer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConf extends AuthorizationServerConfigurerAdapter {
	
	// valores das minhas variaveis no meu application.properties
	@Value("${security.oauth2.client.client-id}")
	private String clientId;
	
	@Value("${security.oauth2.client.client-secret}")
	private String clientSecret;
	
	@Value("${jwt.duration}")
	private Integer jwtDuration;

	// BCrypt que esta na minha class AppConfig
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	// beans que esta na minha class AppConfig
	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;
	
	// beans que esta na minha class AppConfig
	@Autowired
	private JwtTokenStore tokenStore;
	
	// beans que esta na minha class SecurityConfig
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenEnhancer tokenEnhancer;
	
	// esse metodos dessa class são escritos pelo override

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
          security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	// neste metodo que vai ser definido como sera a autenticação e quais são os dados do cliente
	// e neste metodo que são declaradas as predenciais da aplicação
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()// diz que o processo sera feito em memoria
		.withClient(clientId)//defini o nome da aplicaçaõ, sera usado da minha aplicação como o nome do usuario ou o username
		.secret(passwordEncoder.encode(clientSecret))// defini a senha da aplicação, sera usado como senha ou password
		.scopes("read","write")// como vai ser o acesso
		.authorizedGrantTypes("password")// tipo do grandType
		.accessTokenValiditySeconds(jwtDuration);// tempo de duração, quando leva para expirar
	}

	// aqui eu falo quem que vai autorizar e como sera o formato do token
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain chain = new TokenEnhancerChain();
		chain.setTokenEnhancers(Arrays.asList(accessTokenConverter, tokenEnhancer));
		
		endpoints.authenticationManager(authenticationManager)// quem vai fazer a autenticação "authenticationManager"
		.tokenStore(tokenStore)// quem vai processar o token "tokenStore"
		.accessTokenConverter(accessTokenConverter)// quem vai converter "accessTokenConverter"
		.tokenEnhancer(chain);
	}
	
	
}
