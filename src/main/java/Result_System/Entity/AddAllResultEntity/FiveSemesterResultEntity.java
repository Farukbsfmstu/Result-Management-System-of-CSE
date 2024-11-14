package Result_System.Entity.AddAllResultEntity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name="Five_Semesters_Result")
public class FiveSemesterResultEntity {

	private String Session;
	@Id
	private Long ID;
	
	private String name;
	
	private double CSE3111;
	@Transient
	private double CaCSE3111 ;
	private double CSE3112;
	@Transient
	private double CaCSE3112;
	private double CSE3121;
	@Transient
	private double CaCSE3121 ;
	private double CSE3122 ;
	@Transient
	private double CaCSE3122 ;
	private double CSE3131;
	@Transient
	private double CaCSE3131;
	private double CSE3132 ;
	@Transient
	private double CaCSE3132 ;
	private double CSE3141;
	@Transient
	private double CaCSE3141 ;
	private double CSE3142;
	@Transient
	private double CaCSE3142 ;
	private double CSE3152 ;
	@Transient
	private double CaCSE3152 ;
	
	private String year;
	private double CGPA;
	 @Temporal(TemporalType.DATE)
	 private LocalDate Date;
	 
	 
	public FiveSemesterResultEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FiveSemesterResultEntity(String session, Long iD, String name, double cSE3111, double caCSE3111,
			double cSE3112, double caCSE3112, double cSE3121, double caCSE3121, double cSE3122, double caCSE3122,
			double cSE3131, double caCSE3131, double cSE3132, double caCSE3132, double cSE3141, double caCSE3141,
			double cSE3142, double caCSE3142, double cSE3152, double caCSE3152, String year, double cGPA,
			LocalDate date) {
		super();
		Session = session;
		ID = iD;
		this.name = name;
		CSE3111 = cSE3111;
		CaCSE3111 = caCSE3111;
		CSE3112 = cSE3112;
		CaCSE3112 = caCSE3112;
		CSE3121 = cSE3121;
		CaCSE3121 = caCSE3121;
		CSE3122 = cSE3122;
		CaCSE3122 = caCSE3122;
		CSE3131 = cSE3131;
		CaCSE3131 = caCSE3131;
		CSE3132 = cSE3132;
		CaCSE3132 = caCSE3132;
		CSE3141 = cSE3141;
		CaCSE3141 = caCSE3141;
		CSE3142 = cSE3142;
		CaCSE3142 = caCSE3142;
		CSE3152 = cSE3152;
		CaCSE3152 = caCSE3152;
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


	public double getCSE3111() {
		return CSE3111;
	}


	public void setCSE3111(double cSE3111) {
		CSE3111 = cSE3111;
	}


	public double getCaCSE3111() {
		return CaCSE3111;
	}


	public void setCaCSE3111(double caCSE3111) {
		CaCSE3111 = caCSE3111;
	}


	public double getCSE3112() {
		return CSE3112;
	}


	public void setCSE3112(double cSE3112) {
		CSE3112 = cSE3112;
	}


	public double getCaCSE3112() {
		return CaCSE3112;
	}


	public void setCaCSE3112(double caCSE3112) {
		CaCSE3112 = caCSE3112;
	}


	public double getCSE3121() {
		return CSE3121;
	}


	public void setCSE3121(double cSE3121) {
		CSE3121 = cSE3121;
	}


	public double getCaCSE3121() {
		return CaCSE3121;
	}


	public void setCaCSE3121(double caCSE3121) {
		CaCSE3121 = caCSE3121;
	}


	public double getCSE3122() {
		return CSE3122;
	}


	public void setCSE3122(double cSE3122) {
		CSE3122 = cSE3122;
	}


	public double getCaCSE3122() {
		return CaCSE3122;
	}


	public void setCaCSE3122(double caCSE3122) {
		CaCSE3122 = caCSE3122;
	}


	public double getCSE3131() {
		return CSE3131;
	}


	public void setCSE3131(double cSE3131) {
		CSE3131 = cSE3131;
	}


	public double getCaCSE3131() {
		return CaCSE3131;
	}


	public void setCaCSE3131(double caCSE3131) {
		CaCSE3131 = caCSE3131;
	}


	public double getCSE3132() {
		return CSE3132;
	}


	public void setCSE3132(double cSE3132) {
		CSE3132 = cSE3132;
	}


	public double getCaCSE3132() {
		return CaCSE3132;
	}


	public void setCaCSE3132(double caCSE3132) {
		CaCSE3132 = caCSE3132;
	}


	public double getCSE3141() {
		return CSE3141;
	}


	public void setCSE3141(double cSE3141) {
		CSE3141 = cSE3141;
	}


	public double getCaCSE3141() {
		return CaCSE3141;
	}


	public void setCaCSE3141(double caCSE3141) {
		CaCSE3141 = caCSE3141;
	}


	public double getCSE3142() {
		return CSE3142;
	}


	public void setCSE3142(double cSE3142) {
		CSE3142 = cSE3142;
	}


	public double getCaCSE3142() {
		return CaCSE3142;
	}


	public void setCaCSE3142(double caCSE3142) {
		CaCSE3142 = caCSE3142;
	}


	public double getCSE3152() {
		return CSE3152;
	}


	public void setCSE3152(double cSE3152) {
		CSE3152 = cSE3152;
	}


	public double getCaCSE3152() {
		return CaCSE3152;
	}


	public void setCaCSE3152(double caCSE3152) {
		CaCSE3152 = caCSE3152;
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
		return "FiveSemesterResultEntity [Session=" + Session + ", ID=" + ID + ", name=" + name + ", CSE3111=" + CSE3111
				+ ", CaCSE3111=" + CaCSE3111 + ", CSE3112=" + CSE3112 + ", CaCSE3112=" + CaCSE3112 + ", CSE3121="
				+ CSE3121 + ", CaCSE3121=" + CaCSE3121 + ", CSE3122=" + CSE3122 + ", CaCSE3122=" + CaCSE3122
				+ ", CSE3131=" + CSE3131 + ", CaCSE3131=" + CaCSE3131 + ", CSE3132=" + CSE3132 + ", CaCSE3132="
				+ CaCSE3132 + ", CSE3141=" + CSE3141 + ", CaCSE3141=" + CaCSE3141 + ", CSE3142=" + CSE3142
				+ ", CaCSE3142=" + CaCSE3142 + ", CSE3152=" + CSE3152 + ", CaCSE3152=" + CaCSE3152 + ", year=" + year
				+ ", CGPA=" + CGPA + ", Date=" + Date + "]";
	}
	
	
	
}
