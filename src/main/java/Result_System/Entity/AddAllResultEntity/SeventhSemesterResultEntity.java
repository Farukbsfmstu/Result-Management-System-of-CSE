package Result_System.Entity.AddAllResultEntity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name="Seventh_Semesters_Result")
public class SeventhSemesterResultEntity {
	
	private String Session;
	@Id
	private Long ID;
	
	private String name;
	private double CSE4111;
	@Transient
	private double CaCSE4111;
	private double CSE4112;
	@Transient
	private double CaCSE4112;
	private double CSE4121;
	@Transient
	private double CaCSE4121;
	private double CSE4122;
	@Transient
	private double CaCSE4122;
	private double CSE4131;
	@Transient
	private double CaCSE4131;
	private double CSE4132;
	@Transient
	private double CaCSE4132;
	private double CSE4141;
	@Transient
	private double CaCSE4141;
	private double CSE4142;
	@Transient
	private double CaCSE4142;
	private double CSE4180;
	@Transient
	private double CaCSE4180;
	
	private String year;
	private double CGPA;
	 @Temporal(TemporalType.DATE)
	 private LocalDate Date;
	 
	 
	public SeventhSemesterResultEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SeventhSemesterResultEntity(String session, Long iD, String name, double cSE4111, double caCSE4111,
			double cSE4112, double caCSE4112, double cSE4121, double caCSE4121, double cSE4122, double caCSE4122,
			double cSE4131, double caCSE4131, double cSE4132, double caCSE4132, double cSE4141, double caCSE4141,
			double cSE4142, double caCSE4142, double cSE4180, double caCSE4180, String year, double cGPA,
			LocalDate date) {
		super();
		Session = session;
		ID = iD;
		this.name = name;
		CSE4111 = cSE4111;
		CaCSE4111 = caCSE4111;
		CSE4112 = cSE4112;
		CaCSE4112 = caCSE4112;
		CSE4121 = cSE4121;
		CaCSE4121 = caCSE4121;
		CSE4122 = cSE4122;
		CaCSE4122 = caCSE4122;
		CSE4131 = cSE4131;
		CaCSE4131 = caCSE4131;
		CSE4132 = cSE4132;
		CaCSE4132 = caCSE4132;
		CSE4141 = cSE4141;
		CaCSE4141 = caCSE4141;
		CSE4142 = cSE4142;
		CaCSE4142 = caCSE4142;
		CSE4180 = cSE4180;
		CaCSE4180 = caCSE4180;
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


	public double getCSE4111() {
		return CSE4111;
	}


	public void setCSE4111(double cSE4111) {
		CSE4111 = cSE4111;
	}


	public double getCaCSE4111() {
		return CaCSE4111;
	}


	public void setCaCSE4111(double caCSE4111) {
		CaCSE4111 = caCSE4111;
	}


	public double getCSE4112() {
		return CSE4112;
	}


	public void setCSE4112(double cSE4112) {
		CSE4112 = cSE4112;
	}


	public double getCaCSE4112() {
		return CaCSE4112;
	}


	public void setCaCSE4112(double caCSE4112) {
		CaCSE4112 = caCSE4112;
	}


	public double getCSE4121() {
		return CSE4121;
	}


	public void setCSE4121(double cSE4121) {
		CSE4121 = cSE4121;
	}


	public double getCaCSE4121() {
		return CaCSE4121;
	}


	public void setCaCSE4121(double caCSE4121) {
		CaCSE4121 = caCSE4121;
	}


	public double getCSE4122() {
		return CSE4122;
	}


	public void setCSE4122(double cSE4122) {
		CSE4122 = cSE4122;
	}


	public double getCaCSE4122() {
		return CaCSE4122;
	}


	public void setCaCSE4122(double caCSE4122) {
		CaCSE4122 = caCSE4122;
	}


	public double getCSE4131() {
		return CSE4131;
	}


	public void setCSE4131(double cSE4131) {
		CSE4131 = cSE4131;
	}


	public double getCaCSE4131() {
		return CaCSE4131;
	}


	public void setCaCSE4131(double caCSE4131) {
		CaCSE4131 = caCSE4131;
	}


	public double getCSE4132() {
		return CSE4132;
	}


	public void setCSE4132(double cSE4132) {
		CSE4132 = cSE4132;
	}


	public double getCaCSE4132() {
		return CaCSE4132;
	}


	public void setCaCSE4132(double caCSE4132) {
		CaCSE4132 = caCSE4132;
	}


	public double getCSE4141() {
		return CSE4141;
	}


	public void setCSE4141(double cSE4141) {
		CSE4141 = cSE4141;
	}


	public double getCaCSE4141() {
		return CaCSE4141;
	}


	public void setCaCSE4141(double caCSE4141) {
		CaCSE4141 = caCSE4141;
	}


	public double getCSE4142() {
		return CSE4142;
	}


	public void setCSE4142(double cSE4142) {
		CSE4142 = cSE4142;
	}


	public double getCaCSE4142() {
		return CaCSE4142;
	}


	public void setCaCSE4142(double caCSE4142) {
		CaCSE4142 = caCSE4142;
	}


	public double getCSE4180() {
		return CSE4180;
	}


	public void setCSE4180(double cSE4180) {
		CSE4180 = cSE4180;
	}


	public double getCaCSE4180() {
		return CaCSE4180;
	}


	public void setCaCSE4180(double caCSE4180) {
		CaCSE4180 = caCSE4180;
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
		return "SeventhSemesterResultEntity [Session=" + Session + ", ID=" + ID + ", name=" + name + ", CSE4111="
				+ CSE4111 + ", CaCSE4111=" + CaCSE4111 + ", CSE4112=" + CSE4112 + ", CaCSE4112=" + CaCSE4112
				+ ", CSE4121=" + CSE4121 + ", CaCSE4121=" + CaCSE4121 + ", CSE4122=" + CSE4122 + ", CaCSE4122="
				+ CaCSE4122 + ", CSE4131=" + CSE4131 + ", CaCSE4131=" + CaCSE4131 + ", CSE4132=" + CSE4132
				+ ", CaCSE4132=" + CaCSE4132 + ", CSE4141=" + CSE4141 + ", CaCSE4141=" + CaCSE4141 + ", CSE4142="
				+ CSE4142 + ", CaCSE4142=" + CaCSE4142 + ", CSE4180=" + CSE4180 + ", CaCSE4180=" + CaCSE4180 + ", year="
				+ year + ", CGPA=" + CGPA + ", Date=" + Date + "]";
	}


	 
	 
	
}
