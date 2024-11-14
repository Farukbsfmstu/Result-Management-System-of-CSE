package Result_System.SecuritySystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import Result_System.Entity.SingupEntityStudent;
import Result_System.Repository.SignUpRepository;
//import Result_System.SecuritySystem.CustomStudentDetails;
@Component
public class StudentDetailsService implements UserDetailsService {
	
	@Autowired
	private SignUpRepository signupRepository;
	 @Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		SingupEntityStudent student = signupRepository.getStudentByUsername(username);
		System.out.print("Hy i am student getStudentByUsername: "+student);
		
		if(student==null) {
			 throw new UsernameNotFoundException("Student not found");
		}
		
		CustomStudentDetails details=new CustomStudentDetails(student);
		 return details ;
	}
        
} 
