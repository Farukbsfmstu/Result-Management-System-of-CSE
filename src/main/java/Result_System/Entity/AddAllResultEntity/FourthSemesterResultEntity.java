package Result_System.Entity.AddAllResultEntity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name="Fourth_Semesters_Result")
public class FourthSemesterResultEntity {
	private String Session;
	@Id
	private Long ID;
	
	private String name;
	private double LAW2211;
	@Transient
	private double CaLAW2211 ;
	private double MATH2211 ;
	@Transient
	private double CaMATH2211 ;
	private double CSE2211 ;
	@Transient
	private double CaCSE2211 ;
	private double CSE2212 ;
	@Transient
	private double CaCSE2212 ;
	private double CSE2221 ;
	@Transient
	private double CaCSE2221;
	private double CSE2222 ;
	@Transient
	private double CaCSE2222;
	private double CSE2231 ;
	@Transient
	private double CaCSE2231 ;
	private double CSE2232 ;
	@Transient
	private double CaCSE2232 ;
	
	private String year;
	private double CGPA;
	 @Temporal(TemporalType.DATE)
	 private LocalDate Date;
	 
	 
	public FourthSemesterResultEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FourthSemesterResultEntity(String session, Long iD, String name, double lAW2211, double caLAW2211,
			double mATH2211, double caMATH2211, double cSE2211, double caCSE2211, double cSE2212, double caCSE2212,
			double cSE2221, double caCSE2221, double cSE2222, double caCSE2222, double cSE2231, double caCSE2231,
			double cSE2232, double caCSE2232, String year, double cGPA, LocalDate date) {
		super();
		Session = session;
		ID = iD;
		this.name = name;
		LAW2211 = lAW2211;
		CaLAW2211 = caLAW2211;
		MATH2211 = mATH2211;
		CaMATH2211 = caMATH2211;
		CSE2211 = cSE2211;
		CaCSE2211 = caCSE2211;
		CSE2212 = cSE2212;
		CaCSE2212 = caCSE2212;
		CSE2221 = cSE2221;
		CaCSE2221 = caCSE2221;
		CSE2222 = cSE2222;
		CaCSE2222 = caCSE2222;
		CSE2231 = cSE2231;
		CaCSE2231 = caCSE2231;
		CSE2232 = cSE2232;
		CaCSE2232 = caCSE2232;
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


	public double getLAW2211() {
		return LAW2211;
	}


	public void setLAW2211(double lAW2211) {
		LAW2211 = lAW2211;
	}


	public double getCaLAW2211() {
		return CaLAW2211;
	}


	public void setCaLAW2211(double caLAW2211) {
		CaLAW2211 = caLAW2211;
	}


	public double getMATH2211() {
		return MATH2211;
	}


	public void setMATH2211(double mATH2211) {
		MATH2211 = mATH2211;
	}


	public double getCaMATH2211() {
		return CaMATH2211;
	}


	public void setCaMATH2211(double caMATH2211) {
		CaMATH2211 = caMATH2211;
	}


	public double getCSE2211() {
		return CSE2211;
	}


	public void setCSE2211(double cSE2211) {
		CSE2211 = cSE2211;
	}


	public double getCaCSE2211() {
		return CaCSE2211;
	}


	public void setCaCSE2211(double caCSE2211) {
		CaCSE2211 = caCSE2211;
	}


	public double getCSE2212() {
		return CSE2212;
	}


	public void setCSE2212(double cSE2212) {
		CSE2212 = cSE2212;
	}


	public double getCaCSE2212() {
		return CaCSE2212;
	}


	public void setCaCSE2212(double caCSE2212) {
		CaCSE2212 = caCSE2212;
	}


	public double getCSE2221() {
		return CSE2221;
	}


	public void setCSE2221(double cSE2221) {
		CSE2221 = cSE2221;
	}


	public double getCaCSE2221() {
		return CaCSE2221;
	}


	public void setCaCSE2221(double caCSE2221) {
		CaCSE2221 = caCSE2221;
	}


	public double getCSE2222() {
		return CSE2222;
	}


	public void setCSE2222(double cSE2222) {
		CSE2222 = cSE2222;
	}


	public double getCaCSE2222() {
		return CaCSE2222;
	}


	public void setCaCSE2222(double caCSE2222) {
		CaCSE2222 = caCSE2222;
	}


	public double getCSE2231() {
		return CSE2231;
	}


	public void setCSE2231(double cSE2231) {
		CSE2231 = cSE2231;
	}


	public double getCaCSE2231() {
		return CaCSE2231;
	}


	public void setCaCSE2231(double caCSE2231) {
		CaCSE2231 = caCSE2231;
	}


	public double getCSE2232() {
		return CSE2232;
	}


	public void setCSE2232(double cSE2232) {
		CSE2232 = cSE2232;
	}


	public double getCaCSE2232() {
		return CaCSE2232;
	}


	public void setCaCSE2232(double caCSE2232) {
		CaCSE2232 = caCSE2232;
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
		return "FourthSemesterResultEntity [Session=" + Session + ", ID=" + ID + ", name=" + name + ", LAW2211="
				+ LAW2211 + ", CaLAW2211=" + CaLAW2211 + ", MATH2211=" + MATH2211 + ", CaMATH2211=" + CaMATH2211
				+ ", CSE2211=" + CSE2211 + ", CaCSE2211=" + CaCSE2211 + ", CSE2212=" + CSE2212 + ", CaCSE2212="
				+ CaCSE2212 + ", CSE2221=" + CSE2221 + ", CaCSE2221=" + CaCSE2221 + ", CSE2222=" + CSE2222
				+ ", CaCSE2222=" + CaCSE2222 + ", CSE2231=" + CSE2231 + ", CaCSE2231=" + CaCSE2231 + ", CSE2232="
				+ CSE2232 + ", CaCSE2232=" + CaCSE2232 + ", year=" + year + ", CGPA=" + CGPA + ", Date=" + Date + "]";
	}
	
	
	
	
}
