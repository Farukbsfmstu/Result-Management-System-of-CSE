package Result_System.Entity.AddAllResultEntity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name="Sixth_Semesters_Result")
public class SixthSemesterResultEntity {

	private String Session;
	@Id
	private Long ID;
	
	private String name;
	
	private double  CSE3211 ;
	@Transient
	private double CaCSE3211;
	private double  CSE3212;
	@Transient
	private double  CaCSE3212;
	private double  CSE3221;
	@Transient
	private double  CaCSE3221;
	private double  CSE3222;
	@Transient
	private double  CaCSE3222;
	private double  CSE3231;
	@Transient
	private double  CaCSE3231;
	private double  CSE3232;
	@Transient
	private double  CaCSE3232;
	private double  CSE3241;
	@Transient
	private double  CaCSE3241;
	private double  CSE3242;
	@Transient
	private double  CaCSE3242;
	private double  CSE3251;
	@Transient
	private double  CaCSE3251;
	
	private String year;
	private double CGPA;
	 @Temporal(TemporalType.DATE)
	 private LocalDate Date;
	 
	 
	public SixthSemesterResultEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SixthSemesterResultEntity(String session, Long iD, String name, double cSE3211, double caCSE3211,
			double cSE3212, double caCSE3212, double cSE3221, double caCSE3221, double cSE3222, double caCSE3222,
			double cSE3231, double caCSE3231, double cSE3232, double caCSE3232, double cSE3241, double caCSE3241,
			double cSE3242, double caCSE3242, double cSE3251, double caCSE3251, String year, double cGPA,
			LocalDate date) {
		super();
		Session = session;
		ID = iD;
		this.name = name;
		CSE3211 = cSE3211;
		CaCSE3211 = caCSE3211;
		CSE3212 = cSE3212;
		CaCSE3212 = caCSE3212;
		CSE3221 = cSE3221;
		CaCSE3221 = caCSE3221;
		CSE3222 = cSE3222;
		CaCSE3222 = caCSE3222;
		CSE3231 = cSE3231;
		CaCSE3231 = caCSE3231;
		CSE3232 = cSE3232;
		CaCSE3232 = caCSE3232;
		CSE3241 = cSE3241;
		CaCSE3241 = caCSE3241;
		CSE3242 = cSE3242;
		CaCSE3242 = caCSE3242;
		CSE3251 = cSE3251;
		CaCSE3251 = caCSE3251;
		this.year = year;
		CGPA = cGPA;
		Date = date;
	}


	public String getSession() {
		return Session;
	}


	public void setSession(String session) {
		Session = session;
	}


	public Long getID() {
		return ID;
	}


	public void setID(Long iD) {
		ID = iD;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getCSE3211() {
		return CSE3211;
	}


	public void setCSE3211(double cSE3211) {
		CSE3211 = cSE3211;
	}


	public double getCaCSE3211() {
		return CaCSE3211;
	}


	public void setCaCSE3211(double caCSE3211) {
		CaCSE3211 = caCSE3211;
	}


	public double getCSE3212() {
		return CSE3212;
	}


	public void setCSE3212(double cSE3212) {
		CSE3212 = cSE3212;
	}


	public double getCaCSE3212() {
		return CaCSE3212;
	}


	public void setCaCSE3212(double caCSE3212) {
		CaCSE3212 = caCSE3212;
	}


	public double getCSE3221() {
		return CSE3221;
	}


	public void setCSE3221(double cSE3221) {
		CSE3221 = cSE3221;
	}


	public double getCaCSE3221() {
		return CaCSE3221;
	}


	public void setCaCSE3221(double caCSE3221) {
		CaCSE3221 = caCSE3221;
	}


	public double getCSE3222() {
		return CSE3222;
	}


	public void setCSE3222(double cSE3222) {
		CSE3222 = cSE3222;
	}


	public double getCaCSE3222() {
		return CaCSE3222;
	}


	public void setCaCSE3222(double caCSE3222) {
		CaCSE3222 = caCSE3222;
	}


	public double getCSE3231() {
		return CSE3231;
	}


	public void setCSE3231(double cSE3231) {
		CSE3231 = cSE3231;
	}


	public double getCaCSE3231() {
		return CaCSE3231;
	}


	public void setCaCSE3231(double caCSE3231) {
		CaCSE3231 = caCSE3231;
	}


	public double getCSE3232() {
		return CSE3232;
	}


	public void setCSE3232(double cSE3232) {
		CSE3232 = cSE3232;
	}


	public double getCaCSE3232() {
		return CaCSE3232;
	}


	public void setCaCSE3232(double caCSE3232) {
		CaCSE3232 = caCSE3232;
	}


	public double getCSE3241() {
		return CSE3241;
	}


	public void setCSE3241(double cSE3241) {
		CSE3241 = cSE3241;
	}


	public double getCaCSE3241() {
		return CaCSE3241;
	}


	public void setCaCSE3241(double caCSE3241) {
		CaCSE3241 = caCSE3241;
	}


	public double getCSE3242() {
		return CSE3242;
	}


	public void setCSE3242(double cSE3242) {
		CSE3242 = cSE3242;
	}


	public double getCaCSE3242() {
		return CaCSE3242;
	}


	public void setCaCSE3242(double caCSE3242) {
		CaCSE3242 = caCSE3242;
	}


	public double getCSE3251() {
		return CSE3251;
	}


	public void setCSE3251(double cSE3251) {
		CSE3251 = cSE3251;
	}


	public double getCaCSE3251() {
		return CaCSE3251;
	}


	public void setCaCSE3251(double caCSE3251) {
		CaCSE3251 = caCSE3251;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public double getCGPA() {
		return CGPA;
	}


	public void setCGPA(double cGPA) {
		CGPA = cGPA;
	}


	public LocalDate getDate() {
		return Date;
	}


	public void setDate(LocalDate date) {
		Date = date;
	}


	@Override
	public String toString() {
		return "SixthSemesterResultEntity [Session=" + Session + ", ID=" + ID + ", name=" + name + ", CSE3211="
				+ CSE3211 + ", CaCSE3211=" + CaCSE3211 + ", CSE3212=" + CSE3212 + ", CaCSE3212=" + CaCSE3212
				+ ", CSE3221=" + CSE3221 + ", CaCSE3221=" + CaCSE3221 + ", CSE3222=" + CSE3222 + ", CaCSE3222="
				+ CaCSE3222 + ", CSE3231=" + CSE3231 + ", CaCSE3231=" + CaCSE3231 + ", CSE3232=" + CSE3232
				+ ", CaCSE3232=" + CaCSE3232 + ", CSE3241=" + CSE3241 + ", CaCSE3241=" + CaCSE3241 + ", CSE3242="
				+ CSE3242 + ", CaCSE3242=" + CaCSE3242 + ", CSE3251=" + CSE3251 + ", CaCSE3251=" + CaCSE3251 + ", year="
				+ year + ", CGPA=" + CGPA + ", Date=" + Date + "]";
	}
	
	
	
	
}
