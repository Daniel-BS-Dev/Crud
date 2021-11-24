package com.devsuperior.dscatalog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// tera os metodos para libera as rotas
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	// usando o meu BCryptPasswordEncode para saber a senha, esta na classe AppConfig
	@Autowired
	private BCryptPasswordEncoder password;
	
	// usando o meu UserDetilsService para saber quem é o usuario
	@Autowired
	private UserDetailsService user;
	

	// metodo para libera todos os enpointer
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/actuator/**");// actuator é uma biblioteca que o spring securiry usa para passar nas requisições
		//web.ignoring().antMatchers("/**"); ignora todos os enpointer
	}

	//Security 2 passo
	//metodo que eu escrevo clicando no botão direito, source, override, configure
	//esse metodo o spring security usa para pegar a senha criptografada
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Configurando quem é o usuario buscando por email e a senha
		auth.userDetailsService(user).passwordEncoder(password);
	}

	//Security 3 passo
	//metodo que eu escrevo clicando no botão direito, source, override, configure
	// concluido o security vamos para o cloud começar com os beans class AppConfig
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	
}