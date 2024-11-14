package Result_System.Entity;




import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Student_Signup")
public class SingupEntityStudent {
	@Id
	private Long ID;
	@Column(unique=true)
	private String username;
	private String password ;
	private String role ;
	 @Temporal(TemporalType.DATE)
    private LocalDate Date;
	
	public SingupEntityStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SingupEntityStudent(Long iD, String username, String password, String role) {
		super();
		ID = iD;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	public LocalDate getDate() {
		return Date;
	}

	public void setDate(LocalDate date) {
		Date = date;
	}


	@Override
	public String toString() {
		return "SingupEntityStudent [ID=" + ID + ", username=" + username + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
	
		
	
}
