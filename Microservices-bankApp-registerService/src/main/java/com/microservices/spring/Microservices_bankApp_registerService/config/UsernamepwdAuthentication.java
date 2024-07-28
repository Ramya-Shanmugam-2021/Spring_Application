package com.microservices.spring.Microservices_bankApp_registerService.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.microservices.spring.Microservices_bankApp_registerService.entity.Customer;
import com.microservices.spring.Microservices_bankApp_registerService.repository.UserRegisterRepository;

@Component
public class UsernamepwdAuthentication implements AuthenticationProvider {

	@Autowired
	private UserRegisterRepository userRegisterRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println(authentication+"  **** //***"); 
		String username = authentication.getName();
	        String pwd = authentication.getCredentials().toString();
	        List<Customer> customer = userRegisterRepository.findByEmail(username);
	        if (customer.size() > 0) {
	            if (passwordEncoder.matches(pwd, customer.get(0).getPassword())) {
	                List<GrantedAuthority> authorities = new ArrayList<>();
	                
	                boolean a = passwordEncoder.matches(pwd, customer.get(0).getPassword());
	                System.out.println(" true or false stmt : "+a+" ././.");
	                System.out.println(" 67676767  "+customer.get(0).getRole()+"   pppp "); 
	                
	                System.out.println(" 6767  "+customer.get(0).getPassword()+"   ggggg "); 
	                System.out.println(" 67676  "+username+"   pppp "); 
	                authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
	                //"ROLE_USER"
	              //  authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
	                System.out.println(" ioioioi  "+customer.get(0).getRole()+"   dfdf "); 
	                
//	                return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
	                
	                return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
	            } else {
	            	
	            	System.out.println(" 89898989  "); 
	                throw new BadCredentialsException("Invalid password!");
	            }
	        }else {
	        	
	        	System.out.println(" 54545454  "); 
	            throw new BadCredentialsException("No user registered with this details!");
	        }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		System.out.println(" 323232323*** jk  "); 
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
