package Result_System.Entity.AddAllResultEntity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name="Eighth_Semesters_Result")
public class EighthSemesterResultEntity {

	private String Session;
	@Id
	private Long ID;
	
	private String name;
	
	private double CSE4211 ;
	@Transient
	private double CaCSE4211 ;
	private double CSE4212 ;
	@Transient
	private double CaCSE4212 ;
	private double CSE4221 ;
	@Transient
	private double CaCSE4221 ;
	private double CSE4222 ;
	@Transient
	private double CaCSE4222 ;
	private double CSE4231 ;
	@Transient
	private double CaCSE4231 ;
	private double CSE4271 ;
	@Transient
	private double CaCSE4271 ;
	private double CSE4272 ;
	@Transient
	private double CaCSE4272 ;
	private double CSE4270 ;
	@Transient
	private double CaCSE4270 ;
	private double CSE4280 ;
	@Transient
	private double CaCSE4280 ;
	private double CSE4290 ;
	
	private String year;
	private double CGPA;
	 @Temporal(TemporalType.DATE)
	 private LocalDate Date;
	 
	public EighthSemesterResultEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EighthSemesterResultEntity(String session, Long iD, String name, double cSE4211, double caCSE4211,
			double cSE4212, double caCSE4212, double cSE4221, double caCSE4221, double cSE4222, double caCSE4222,
			double cSE4231, double caCSE4231, double cSE4271, double caCSE4271, double cSE4272, double caCSE4272,
			double cSE4270, double caCSE4270, double cSE4280, double caCSE4280, double cSE4290, String year,
			double cGPA, LocalDate date) {
		super();
		Session = session;
		ID = iD;
		this.name = name;
		CSE4211 = cSE4211;
		CaCSE4211 = caCSE4211;
		CSE4212 = cSE4212;
		CaCSE4212 = caCSE4212;
		CSE4221 = cSE4221;
		CaCSE4221 = caCSE4221;
		CSE4222 = cSE4222;
		CaCSE4222 = caCSE4222;
		CSE4231 = cSE4231;
		CaCSE4231 = caCSE4231;
		CSE4271 = cSE4271;
		CaCSE4271 = caCSE4271;
		CSE4272 = cSE4272;
		CaCSE4272 = caCSE4272;
		CSE4270 = cSE4270;
		CaCSE4270 = caCSE4270;
		CSE4280 = cSE4280;
		CaCSE4280 = caCSE4280;
		CSE4290 = cSE4290;
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

	public double getCSE4211() {
		return CSE4211;
	}

	public void setCSE4211(double cSE4211) {
		CSE4211 = cSE4211;
	}

	public double getCaCSE4211() {
		return CaCSE4211;
	}

	public void setCaCSE4211(double caCSE4211) {
		CaCSE4211 = caCSE4211;
	}

	public double getCSE4212() {
		return CSE4212;
	}

	public void setCSE4212(double cSE4212) {
		CSE4212 = cSE4212;
	}

	public double getCaCSE4212() {
		return CaCSE4212;
	}

	public void setCaCSE4212(double caCSE4212) {
		CaCSE4212 = caCSE4212;
	}

	public double getCSE4221() {
		return CSE4221;
	}

	public void setCSE4221(double cSE4221) {
		CSE4221 = cSE4221;
	}

	public double getCaCSE4221() {
		return CaCSE4221;
	}

	public void setCaCSE4221(double caCSE4221) {
		CaCSE4221 = caCSE4221;
	}

	public double getCSE4222() {
		return CSE4222;
	}

	public void setCSE4222(double cSE4222) {
		CSE4222 = cSE4222;
	}

	public double getCaCSE4222() {
		return CaCSE4222;
	}

	public void setCaCSE4222(double caCSE4222) {
		CaCSE4222 = caCSE4222;
	}

	public double getCSE4231() {
		return CSE4231;
	}

	public void setCSE4231(double cSE4231) {
		CSE4231 = cSE4231;
	}

	public double getCaCSE4231() {
		return CaCSE4231;
	}

	public void setCaCSE4231(double caCSE4231) {
		CaCSE4231 = caCSE4231;
	}

	public double getCSE4271() {
		return CSE4271;
	}

	public void setCSE4271(double cSE4271) {
		CSE4271 = cSE4271;
	}

	public double getCaCSE4271() {
		return CaCSE4271;
	}

	public void setCaCSE4271(double caCSE4271) {
		CaCSE4271 = caCSE4271;
	}

	public double getCSE4272() {
		return CSE4272;
	}

	public void setCSE4272(double cSE4272) {
		CSE4272 = cSE4272;
	}

	public double getCaCSE4272() {
		return CaCSE4272;
	}

	public void setCaCSE4272(double caCSE4272) {
		CaCSE4272 = caCSE4272;
	}

	public double getCSE4270() {
		return CSE4270;
	}

	public void setCSE4270(double cSE4270) {
		CSE4270 = cSE4270;
	}

	public double getCaCSE4270() {
		return CaCSE4270;
	}

	public void setCaCSE4270(double caCSE4270) {
		CaCSE4270 = caCSE4270;
	}

	public double getCSE4280() {
		return CSE4280;
	}

	public void setCSE4280(double cSE4280) {
		CSE4280 = cSE4280;
	}

	public double getCaCSE4280() {
		return CaCSE4280;
	}

	public void setCaCSE4280(double caCSE4280) {
		CaCSE4280 = caCSE4280;
	}

	public double getCSE4290() {
		return CSE4290;
	}

	public void setCSE4290(double cSE4290) {
		CSE4290 = cSE4290;
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
		return "EighthSemesterResultEntity [Session=" + Session + ", ID=" + ID + ", name=" + name + ", CSE4211="
				+ CSE4211 + ", CaCSE4211=" + CaCSE4211 + ", CSE4212=" + CSE4212 + ", CaCSE4212=" + CaCSE4212
				+ ", CSE4221=" + CSE4221 + ", CaCSE4221=" + CaCSE4221 + ", CSE4222=" + CSE4222 + ", CaCSE4222="
				+ CaCSE4222 + ", CSE4231=" + CSE4231 + ", CaCSE4231=" + CaCSE4231 + ", CSE4271=" + CSE4271
				+ ", CaCSE4271=" + CaCSE4271 + ", CSE4272=" + CSE4272 + ", CaCSE4272=" + CaCSE4272 + ", CSE4270="
				+ CSE4270 + ", CaCSE4270=" + CaCSE4270 + ", CSE4280=" + CSE4280 + ", CaCSE4280=" + CaCSE4280
				+ ", CSE4290=" + CSE4290 + ", year=" + year + ", CGPA=" + CGPA + ", Date=" + Date + "]";
	}
	 
	 
	
	
	
	
	
}
