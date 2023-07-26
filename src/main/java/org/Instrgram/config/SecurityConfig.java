package org.Instrgram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 빈 등록(Ioc관리)빈등록 :  스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@EnableWebSecurity // 시큐리티에 필터가 등록이 된다. 설정은 아래에서 하면된다.
public class SecurityConfig {


	 // encode() 를 호출하면 new BCryptPasswordEncoder() 객체를 리턴받을 수 있다.
    @Bean
    BCryptPasswordEncoder encode() {
			 return new BCryptPasswordEncoder(); //스프링관리 , 필요할때마다 가져다가 사용하면 된다.
		 }
		
		@Bean 
		SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	          
		    http.csrf(t->t.disable());
		    	
            http.authorizeRequests(t -> t
                    .antMatchers("/", "/user/**", "/image/**", "/follow/**", "/comment/**")
                    .access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")   
                    // ROLE_USER or ROLE_ADMIN 만 허용 / authenticated:로그인하면 허용/
                    .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                    .anyRequest()
                    .permitAll())
                    .formLogin(login -> login
                            .loginPage("/auth/login")
                            .loginProcessingUrl("/login") // 스프링 시큐리티가 로그인을 가로챈다.
                            .defaultSuccessUrl("/")); // 정상적으로 요청이 완료
        
		        return http.build();
		    }
}