package upc.edu.pe.webdevs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import upc.edu.pe.webdevs.service.Impl.JpaUserDetailsService;



@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().
		antMatchers("/login", "/css/**", "/js/**", "/img/**" ,"/","/error_403").permitAll()
		.antMatchers("/organizers/add**").hasAnyRole("ORGANIZER")
		.antMatchers("/organizers/list**").hasAnyRole("ORGANIZER")
		.antMatchers("/events/add**").hasAnyRole("ORGANIZER")
		.antMatchers("/events/list**").hasAnyRole("ORGANIZER", "ARTIST")
		.antMatchers("/artists/add**").hasAnyRole("ARTIST")
		.antMatchers("/artists/list**").hasAnyRole("ARTIST")
		
		.anyRequest()
				.authenticated().and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/events/list").and().
				
		logout()
	
          .permitAll()
          .logoutSuccessUrl("/login?logout").and()
          .exceptionHandling().accessDeniedPage("/error_403");
	}
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {

		//build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		PasswordEncoder encoder = passwordEncoder();
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		
		builder.inMemoryAuthentication()
        .withUser(users.username("organizer1").password("12345").roles("ORGANIZER"))
        .withUser(users.username("alvaro").password("12345").roles("ORGANIZER"))
        .withUser(users.username("artist").password("12345").roles("ARTIST"))
        ;
	}

}
