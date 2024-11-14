package Result_System.Entity.AddAllResultEntity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name="Second_Semesters_Result")
public class SecondSemesterResultEntity {
	
	private String Session;
	@Id
	private Long ID;
	
	private String name;
	
	private double ECON1211 ;
	@Transient
	private double CAECON1211 ;
	private double STAT1211 ;
	@Transient
	private double CASTAT1211 ;
	private double MATH1211;
	@Transient
	private double CAMATH1211;
	private double CHEM1211;
	@Transient
	private double CACHEM1211;
	private double CSE1211;
	@Transient
	private double CACSE1211;
	private double CSE1212;
	@Transient
	private double CACSE1212;
	private double CSE1221;
	@Transient
	private double CACSE1221;
	private double CSE1222 ;
	@Transient
	private double CACSE1222 ;
	
	private String year;
	private double CGPA;
	 @Temporal(TemporalType.DATE)
	 private LocalDate Date;
	 
	 
	public SecondSemesterResultEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SecondSemesterResultEntity(String session, Long iD, String name, double eCON1211, double cAECON1211,
			double sTAT1211, double cASTAT1211, double mATH1211, double cAMATH1211, double cHEM1211, double cACHEM1211,
			double cSE1211, double cACSE1211, double cSE1212, double cACSE1212, double cSE1221, double cACSE1221,
			double cSE1222, double cACSE1222, String year, double cGPA, LocalDate date) {
		super();
		Session = session;
		ID = iD;
		this.name = name;
		ECON1211 = eCON1211;
		CAECON1211 = cAECON1211;
		STAT1211 = sTAT1211;
		CASTAT1211 = cASTAT1211;
		MATH1211 = mATH1211;
		CAMATH1211 = cAMATH1211;
		CHEM1211 = cHEM1211;
		CACHEM1211 = cACHEM1211;
		CSE1211 = cSE1211;
		CACSE1211 = cACSE1211;
		CSE1212 = cSE1212;
		CACSE1212 = cACSE1212;
		CSE1221 = cSE1221;
		CACSE1221 = cACSE1221;
		CSE1222 = cSE1222;
		CACSE1222 = cACSE1222;
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


	public double getECON1211() {
		return ECON1211;
	}


	public void setECON1211(double eCON1211) {
		ECON1211 = eCON1211;
	}


	public double getCAECON1211() {
		return CAECON1211;
	}


	public void setCAECON1211(double cAECON1211) {
		CAECON1211 = cAECON1211;
	}


	public double getSTAT1211() {
		return STAT1211;
	}


	public void setSTAT1211(double sTAT1211) {
		STAT1211 = sTAT1211;
	}


	public double getCASTAT1211() {
		return CASTAT1211;
	}


	public void setCASTAT1211(double cASTAT1211) {
		CASTAT1211 = cASTAT1211;
	}


	public double getMATH1211() {
		return MATH1211;
	}


	public void setMATH1211(double mATH1211) {
		MATH1211 = mATH1211;
	}


	public double getCAMATH1211() {
		return CAMATH1211;
	}


	public void setCAMATH1211(double cAMATH1211) {
		CAMATH1211 = cAMATH1211;
	}


	public double getCHEM1211() {
		return CHEM1211;
	}


	public void setCHEM1211(double cHEM1211) {
		CHEM1211 = cHEM1211;
	}


	public double getCACHEM1211() {
		return CACHEM1211;
	}


	public void setCACHEM1211(double cACHEM1211) {
		CACHEM1211 = cACHEM1211;
	}


	public double getCSE1211() {
		return CSE1211;
	}


	public void setCSE1211(double cSE1211) {
		CSE1211 = cSE1211;
	}


	public double getCACSE1211() {
		return CACSE1211;
	}


	public void setCACSE1211(double cACSE1211) {
		CACSE1211 = cACSE1211;
	}


	public double getCSE1212() {
		return CSE1212;
	}


	public void setCSE1212(double cSE1212) {
		CSE1212 = cSE1212;
	}


	public double getCACSE1212() {
		return CACSE1212;
	}


	public void setCACSE1212(double cACSE1212) {
		CACSE1212 = cACSE1212;
	}


	public double getCSE1221() {
		return CSE1221;
	}


	public void setCSE1221(double cSE1221) {
		CSE1221 = cSE1221;
	}


	public double getCACSE1221() {
		return CACSE1221;
	}


	public void setCACSE1221(double cACSE1221) {
		CACSE1221 = cACSE1221;
	}


	public double getCSE1222() {
		return CSE1222;
	}


	public void setCSE1222(double cSE1222) {
		CSE1222 = cSE1222;
	}


	public double getCACSE1222() {
		return CACSE1222;
	}


	public void setCACSE1222(double cACSE1222) {
		CACSE1222 = cACSE1222;
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
		return "SecondSemesterResultEntity [Session=" + Session + ", ID=" + ID + ", name=" + name + ", ECON1211="
				+ ECON1211 + ", CAECON1211=" + CAECON1211 + ", STAT1211=" + STAT1211 + ", CASTAT1211=" + CASTAT1211
				+ ", MATH1211=" + MATH1211 + ", CAMATH1211=" + CAMATH1211 + ", CHEM1211=" + CHEM1211 + ", CACHEM1211="
				+ CACHEM1211 + ", CSE1211=" + CSE1211 + ", CACSE1211=" + CACSE1211 + ", CSE1212=" + CSE1212
				+ ", CACSE1212=" + CACSE1212 + ", CSE1221=" + CSE1221 + ", CACSE1221=" + CACSE1221 + ", CSE1222="
				+ CSE1222 + ", CACSE1222=" + CACSE1222 + ", year=" + year + ", CGPA=" + CGPA + ", Date=" + Date + "]";
	}
	 
	 

}
