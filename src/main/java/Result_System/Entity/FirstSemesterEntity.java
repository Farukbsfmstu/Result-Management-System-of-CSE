package Result_System.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name="First_Semesters_Result")
public class FirstSemesterEntity {
	
	@Column(name = "session")
	private String Session;
	@Id
	private Long ID;
	
	private String name;
	private double ENG1111 ;
	@Transient 
	private double CaENG1111 ;
	private double ENG1112 ;
	@Transient 
	private double CaENG1112 ;
	private double MATH1111 ;
	@Transient 
	private double CaMATH1111 ;
	private double PHY1111 ;
	@Transient 
	private double CaPHY1111 ;
	private double PHY1112;
	@Transient 
	private double CaPHY1112;
	private double CSE1111 ;
	@Transient 
	private double CaCSE1111 ;
	private double CSE1112;
	@Transient 
	private double CaCSE1112;
	private double CSE1121; 
	@Transient 
	private double CACSE1121; 
	private double CSE1122;
	@Transient 
	private double CACSE1122;
	private String year;
	private double CGPA;
	 @Temporal(TemporalType.DATE)
	 private LocalDate Date;
	
	
	public FirstSemesterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FirstSemesterEntity(String session, Long iD, String name, double eNG1111, double caENG1111, double eNG1112,
			double caENG1112, double mATH1111, double caMATH1111, double pHY1111, double caPHY1111, double pHY1112,
			double caPHY1112, double cSE1111, double caCSE1111, double cSE1112, double caCSE1112, double cSE1121,
			double cACSE1121, double cSE1122, double cACSE1122, String year, double cGPA, LocalDate date) {
		super();
		Session = session;
		ID = iD;
		this.name = name;
		ENG1111 = eNG1111;
		CaENG1111 = caENG1111;
		ENG1112 = eNG1112;
		CaENG1112 = caENG1112;
		MATH1111 = mATH1111;
		CaMATH1111 = caMATH1111;
		PHY1111 = pHY1111;
		CaPHY1111 = caPHY1111;
		PHY1112 = pHY1112;
		CaPHY1112 = caPHY1112;
		CSE1111 = cSE1111;
		CaCSE1111 = caCSE1111;
		CSE1112 = cSE1112;
		CaCSE1112 = caCSE1112;
		CSE1121 = cSE1121;
		CACSE1121 = cACSE1121;
		CSE1122 = cSE1122;
		CACSE1122 = cACSE1122;
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


	public double getENG1111() {
		return ENG1111;
	}


	public void setENG1111(double eNG1111) {
		ENG1111 = eNG1111;
	}


	public double getCaENG1111() {
		return CaENG1111;
	}


	public void setCaENG1111(double caENG1111) {
		CaENG1111 = caENG1111;
	}


	public double getENG1112() {
		return ENG1112;
	}


	public void setENG1112(double eNG1112) {
		ENG1112 = eNG1112;
	}


	public double getCaENG1112() {
		return CaENG1112;
	}


	public void setCaENG1112(double caENG1112) {
		CaENG1112 = caENG1112;
	}


	public double getMATH1111() {
		return MATH1111;
	}


	public void setMATH1111(double mATH1111) {
		MATH1111 = mATH1111;
	}


	public double getCaMATH1111() {
		return CaMATH1111;
	}


	public void setCaMATH1111(double caMATH1111) {
		CaMATH1111 = caMATH1111;
	}


	public double getPHY1111() {
		return PHY1111;
	}


	public void setPHY1111(double pHY1111) {
		PHY1111 = pHY1111;
	}


	public double getCaPHY1111() {
		return CaPHY1111;
	}


	public void setCaPHY1111(double caPHY1111) {
		CaPHY1111 = caPHY1111;
	}


	public double getPHY1112() {
		return PHY1112;
	}


	public void setPHY1112(double pHY1112) {
		PHY1112 = pHY1112;
	}


	public double getCaPHY1112() {
		return CaPHY1112;
	}


	public void setCaPHY1112(double caPHY1112) {
		CaPHY1112 = caPHY1112;
	}


	public double getCSE1111() {
		return CSE1111;
	}


	public void setCSE1111(double cSE1111) {
		CSE1111 = cSE1111;
	}


	public double getCaCSE1111() {
		return CaCSE1111;
	}


	public void setCaCSE1111(double caCSE1111) {
		CaCSE1111 = caCSE1111;
	}


	public double getCSE1112() {
		return CSE1112;
	}


	public void setCSE1112(double cSE1112) {
		CSE1112 = cSE1112;
	}


	public double getCaCSE1112() {
		return CaCSE1112;
	}


	public void setCaCSE1112(double caCSE1112) {
		CaCSE1112 = caCSE1112;
	}


	public double getCSE1121() {
		return CSE1121;
	}


	public void setCSE1121(double cSE1121) {
		CSE1121 = cSE1121;
	}


	public double getCACSE1121() {
		return CACSE1121;
	}


	public void setCACSE1121(double cACSE1121) {
		CACSE1121 = cACSE1121;
	}


	public double getCSE1122() {
		return CSE1122;
	}


	public void setCSE1122(double cSE1122) {
		CSE1122 = cSE1122;
	}


	public double getCACSE1122() {
		return CACSE1122;
	}


	public void setCACSE1122(double cACSE1122) {
		CACSE1122 = cACSE1122;
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
		return "FirstSemesterEntity [Session=" + Session + ", ID=" + ID + ", name=" + name + ", ENG1111=" + ENG1111
				+ ", CaENG1111=" + CaENG1111 + ", ENG1112=" + ENG1112 + ", CaENG1112=" + CaENG1112 + ", MATH1111="
				+ MATH1111 + ", CaMATH1111=" + CaMATH1111 + ", PHY1111=" + PHY1111 + ", CaPHY1111=" + CaPHY1111
				+ ", PHY1112=" + PHY1112 + ", CaPHY1112=" + CaPHY1112 + ", CSE1111=" + CSE1111 + ", CaCSE1111="
				+ CaCSE1111 + ", CSE1112=" + CSE1112 + ", CaCSE1112=" + CaCSE1112 + ", CSE1121=" + CSE1121
				+ ", CACSE1121=" + CACSE1121 + ", CSE1122=" + CSE1122 + ", CACSE1122=" + CACSE1122 + ", year=" + year
				+ ", CGPA=" + CGPA + ", Date=" + Date + "]";
	}






	

	
	

}
