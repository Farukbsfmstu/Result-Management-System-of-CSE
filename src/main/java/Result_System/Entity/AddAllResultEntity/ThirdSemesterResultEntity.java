package Result_System.Entity.AddAllResultEntity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name="Third_Semesters_Result")
public class ThirdSemesterResultEntity {
	
	private String Session;
	@Id
	private Long ID;
	
	private String name;
	
	private double ACCO2111;
	@Transient
	private double CaACCO2111;
	private double HUM2111;
	@Transient
	private double CaHUM2111 ;
	private double MATH2111;
	@Transient
	private double CaMATH2111;
	private double CSE2111;
	@Transient
	private double CaCSE2111 ;
	private double CSE2121;
	@Transient
	private double CaCSE2121 ;
	private double CSE2122;
	@Transient
	private double CaCSE2122 ;
	private double CSE2131 ;
	@Transient
	private double CaCSE2131 ;
	private double CSE2132;
	@Transient
	private double CaCSE2132 ;
	
	private String year;
	private double CGPA;
	 @Temporal(TemporalType.DATE)
	 private LocalDate Date;
	 
	 
	public ThirdSemesterResultEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ThirdSemesterResultEntity(String session, Long iD, String name, double aCCO2111, double caACCO2111,
			double hUM2111, double caHUM2111, double mATH2111, double caMATH2111, double cSE2111, double caCSE2111,
			double cSE2121, double caCSE2121, double cSE2122, double caCSE2122, double cSE2131, double caCSE2131,
			double cSE2132, double caCSE2132, String year, double cGPA, LocalDate date) {
		super();
		Session = session;
		ID = iD;
		this.name = name;
		ACCO2111 = aCCO2111;
		CaACCO2111 = caACCO2111;
		HUM2111 = hUM2111;
		CaHUM2111 = caHUM2111;
		MATH2111 = mATH2111;
		CaMATH2111 = caMATH2111;
		CSE2111 = cSE2111;
		CaCSE2111 = caCSE2111;
		CSE2121 = cSE2121;
		CaCSE2121 = caCSE2121;
		CSE2122 = cSE2122;
		CaCSE2122 = caCSE2122;
		CSE2131 = cSE2131;
		CaCSE2131 = caCSE2131;
		CSE2132 = cSE2132;
		CaCSE2132 = caCSE2132;
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


	public double getACCO2111() {
		return ACCO2111;
	}


	public void setACCO2111(double aCCO2111) {
		ACCO2111 = aCCO2111;
	}


	public double getCaACCO2111() {
		return CaACCO2111;
	}


	public void setCaACCO2111(double caACCO2111) {
		CaACCO2111 = caACCO2111;
	}


	public double getHUM2111() {
		return HUM2111;
	}


	public void setHUM2111(double hUM2111) {
		HUM2111 = hUM2111;
	}


	public double getCaHUM2111() {
		return CaHUM2111;
	}


	public void setCaHUM2111(double caHUM2111) {
		CaHUM2111 = caHUM2111;
	}


	public double getMATH2111() {
		return MATH2111;
	}


	public void setMATH2111(double mATH2111) {
		MATH2111 = mATH2111;
	}


	public double getCaMATH2111() {
		return CaMATH2111;
	}


	public void setCaMATH2111(double caMATH2111) {
		CaMATH2111 = caMATH2111;
	}


	public double getCSE2111() {
		return CSE2111;
	}


	public void setCSE2111(double cSE2111) {
		CSE2111 = cSE2111;
	}


	public double getCaCSE2111() {
		return CaCSE2111;
	}


	public void setCaCSE2111(double caCSE2111) {
		CaCSE2111 = caCSE2111;
	}


	public double getCSE2121() {
		return CSE2121;
	}


	public void setCSE2121(double cSE2121) {
		CSE2121 = cSE2121;
	}


	public double getCaCSE2121() {
		return CaCSE2121;
	}


	public void setCaCSE2121(double caCSE2121) {
		CaCSE2121 = caCSE2121;
	}


	public double getCSE2122() {
		return CSE2122;
	}


	public void setCSE2122(double cSE2122) {
		CSE2122 = cSE2122;
	}


	public double getCaCSE2122() {
		return CaCSE2122;
	}


	public void setCaCSE2122(double caCSE2122) {
		CaCSE2122 = caCSE2122;
	}


	public double getCSE2131() {
		return CSE2131;
	}


	public void setCSE2131(double cSE2131) {
		CSE2131 = cSE2131;
	}


	public double getCaCSE2131() {
		return CaCSE2131;
	}


	public void setCaCSE2131(double caCSE2131) {
		CaCSE2131 = caCSE2131;
	}


	public double getCSE2132() {
		return CSE2132;
	}


	public void setCSE2132(double cSE2132) {
		CSE2132 = cSE2132;
	}


	public double getCaCSE2132() {
		return CaCSE2132;
	}


	public void setCaCSE2132(double caCSE2132) {
		CaCSE2132 = caCSE2132;
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
		return "ThirdSemesterResultEntity [Session=" + Session + ", ID=" + ID + ", name=" + name + ", ACCO2111="
				+ ACCO2111 + ", CaACCO2111=" + CaACCO2111 + ", HUM2111=" + HUM2111 + ", CaHUM2111=" + CaHUM2111
				+ ", MATH2111=" + MATH2111 + ", CaMATH2111=" + CaMATH2111 + ", CSE2111=" + CSE2111 + ", CaCSE2111="
				+ CaCSE2111 + ", CSE2121=" + CSE2121 + ", CaCSE2121=" + CaCSE2121 + ", CSE2122=" + CSE2122
				+ ", CaCSE2122=" + CaCSE2122 + ", CSE2131=" + CSE2131 + ", CaCSE2131=" + CaCSE2131 + ", CSE2132="
				+ CSE2132 + ", CaCSE2132=" + CaCSE2132 + ", year=" + year + ", CGPA=" + CGPA + ", Date=" + Date + "]";
	}
	 
	 

}
