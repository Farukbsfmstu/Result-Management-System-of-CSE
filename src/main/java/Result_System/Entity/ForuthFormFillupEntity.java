package Result_System.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Fourth_Semester_FormFillup")
public class ForuthFormFillupEntity {
	
	@Id  
    private Long ID;
    private String session;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String hall;
    private String coursename;
    private String coursecode;
    private String coursenredit;
    @Temporal(TemporalType.DATE)
    private LocalDate Date;
    private String submissionID ;
    
    
	public ForuthFormFillupEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ForuthFormFillupEntity(Long iD, String session, String name, String address, String email, String phone,
			String hall, String coursename, String coursecode, String coursenredit, LocalDate date,
			String submissionID) {
		super();
		ID = iD;
		this.session = session;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.hall = hall;
		this.coursename = coursename;
		this.coursecode = coursecode;
		this.coursenredit = coursenredit;
		Date = date;
		this.submissionID = submissionID;
	}


	public Long getID() {
		return ID;
	}


	public void setID(Long iD) {
		ID = iD;
	}


	public String getSession() {
		return session;
	}


	public void setSession(String session) {
		this.session = session;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getHall() {
		return hall;
	}


	public void setHall(String hall) {
		this.hall = hall;
	}


	public String getCoursename() {
		return coursename;
	}


	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}


	public String getCoursecode() {
		return coursecode;
	}


	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}


	public String getCoursenredit() {
		return coursenredit;
	}


	public void setCoursenredit(String coursenredit) {
		this.coursenredit = coursenredit;
	}


	public LocalDate getDate() {
		return Date;
	}


	public void setDate(LocalDate date) {
		Date = date;
	}


	public String getSubmissionID() {
		return submissionID;
	}


	public void setSubmissionID(String submissionID) {
		this.submissionID = submissionID;
	}


	@Override
	public String toString() {
		return "ForuthFormFillupEntity [ID=" + ID + ", session=" + session + ", name=" + name + ", address=" + address
				+ ", email=" + email + ", phone=" + phone + ", hall=" + hall + ", coursename=" + coursename
				+ ", coursecode=" + coursecode + ", coursenredit=" + coursenredit + ", Date=" + Date + ", submissionID="
				+ submissionID + "]";
	}
    
    
	

}
