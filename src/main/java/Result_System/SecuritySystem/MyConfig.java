package Result_System.SecuritySystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import Result_System.Entity.SingupEntityStudent;
import Result_System.Repository.SignUpRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class MyConfig  {
	
	@Autowired
	private RedirectHandler successHandler;

	private SingupEntityStudent signupinfo;
	  @Bean
	    public UserDetailsService customStudentDetailsService() {
	     
	      return new StudentDetailsService();
	    }
	  

	  @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	  

	    @Bean
	    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception{
	    	return configuration.getAuthenticationManager();
	    }

	  
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(this.customStudentDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	        
	        return authProvider;
	    }
//	private SignUpRepository signupRepository;
//	@Autowired
//	private SingupEntityStudent student;
//
//	@Bean
//    //authentication
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//		
//		
//		
//		
//		
//        UserDetails admin = User.withUsername("abc")
//                .password(encoder.encode("456"))
//                .roles("STUDENT","ADMIN","HR")
//                .build(); 
//        
//        UserDetails  user = User.withUsername(student.getUsername())
//        		.password(student.getPassword())
//        		.roles(student.getRole()) 
//                .build(); 
//       
//        return new InMemoryUserDetailsManager(admin);
//      
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	  http.csrf(csrf -> csrf.disable())
    	  .authorizeHttpRequests((authz) -> authz
          .requestMatchers("/admin/**").hasRole("ADMIN")
              .requestMatchers("/student/**").hasRole("STUDENT")
              .anyRequest().permitAll()   //.authenticated()
              
          )
    	  
          .formLogin((formLogin) ->
              formLogin
             .loginPage("/login").loginProcessingUrl("/login").successHandler(successHandler)
                  .permitAll()
          )
          .logout((logout) ->
              logout
                  .permitAll()
          );
    	 
      return http.build();
    }
    
    
    
   } 

