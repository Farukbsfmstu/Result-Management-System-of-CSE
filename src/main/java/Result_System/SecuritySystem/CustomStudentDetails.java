package Result_System.SecuritySystem;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import Result_System.Entity.SingupEntityStudent;

public class CustomStudentDetails implements UserDetails {

	private SingupEntityStudent signupinfo;
	
	
	 public CustomStudentDetails(SingupEntityStudent signupinfo) {
	        this.signupinfo = signupinfo;
	    }

	 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		SimpleGrantedAuthority simpleGrantedAuthority =new SimpleGrantedAuthority(signupinfo.getRole());
		 System.out.print("Hy i am role: "+signupinfo.getRole());
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		 System.out.println("Hy i am password: "+signupinfo.getPassword());
		return signupinfo.getPassword();
	
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		
		return signupinfo.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
