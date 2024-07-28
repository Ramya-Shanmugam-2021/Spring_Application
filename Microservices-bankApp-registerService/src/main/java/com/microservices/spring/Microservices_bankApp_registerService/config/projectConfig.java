package com.microservices.spring.Microservices_bankApp_registerService.config;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

//import com.microservices.spring.Microservices_bankApp_registerService.filter.CsrfCookieFilter;

import jakarta.servlet.DispatcherType;

@Configuration
public class projectConfig {
	

	@Bean 
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
	{ 
		 http.csrf(csrf -> csrf.disable()) 
				.authorizeHttpRequests((authorize) -> authorize 
						.requestMatchers(
								"/bankApp/getUser/**").permitAll()
						.requestMatchers("bankApp/getUsers","/bankApp/removeInfo/**").authenticated());
						//.anyRequest().authenticated() );
		 return http.build();
	}
	//.hasRole("USER")
//	@Bean
//	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
////		CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
////        requestHandler.setCsrfRequestAttributeName("_csrf");
////        
//        http.csrf((csrf) -> csrf.disable())
//        .authorizeHttpRequests((authorize) -> authorize
//        		.requestMatchers("/bankApp/getUsers").hasRole("USER")
//        		.anyRequest().authenticated())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//
//		
//		return http.build();
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	 
}
////.requestMatchers("/bankApp/removeInfo/**","/bankApp/userRegistration","/bankApp/updateCustomer/**","/bankApp/getAccount").permitAll()

//.requestMatchers("/bankApp/getUsers").permitAll())
// .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()

//.anyRequest().authenticated())
//http.csrf((csrf) -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/bankApp/userRegistration","/bankApp/getUsers","/bankApp/getUser/**","/bankApp/updateCustomer/**")
//.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
//.addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
//.authorizeHttpRequests((requests) -> requests  
//	.requestMatchers("/bankApp/getUsers").hasAnyRole("USER", "ADMIN")  // Ensure "USER" role is allowed
// .requestMatchers("/bankApp/getUser/**").permitAll()
//	.requestMatchers("/bankApp/userRegistration").authenticated())
//.formLogin(Customizer.withDefaults())
//.httpBasic(Customizer.withDefaults());


//
//	.requestMatchers("/bankApp/removeInfo/**","/bankApp/userRegistration","/bankApp/updateCustomer/**","/bankApp/getAccount").permitAll()
//	.requestMatchers("/userR","/bankApp/userLogin","/bankApp/getUsers","/bankApp/getUser/**").authenticated())

//@Bean
//SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//    http.csrf((csrf) -> csrf.disable())
//            .authorizeHttpRequests((requests) -> requests
//                    .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
//                    .requestMatchers("/notices", "/contact", "/register").permitAll())
//            .formLogin(Customizer.withDefaults())
//            .httpBasic(Customizer.withDefaults());
//    return http.build();
//}
//
//@Bean
//public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//}

//.requestMatchers("/bankApp/userLogin").hasRole("admin")