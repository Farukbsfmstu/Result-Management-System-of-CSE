package Result_System.Service;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import Result_System.Entity.FirstSemesterEntity;
import Result_System.Entity.myAdmin;
import Result_System.Entity.AddAllResultEntity.EighthSemesterResultEntity;
import Result_System.Entity.AddAllResultEntity.FiveSemesterResultEntity;
import Result_System.Entity.AddAllResultEntity.FourthSemesterResultEntity;
import Result_System.Entity.AddAllResultEntity.SecondSemesterResultEntity;
import Result_System.Entity.AddAllResultEntity.SeventhSemesterResultEntity;
import Result_System.Entity.AddAllResultEntity.SixthSemesterResultEntity;
import Result_System.Entity.AddAllResultEntity.ThirdSemesterResultEntity;
import Result_System.Repository.AdminRepository;
import Result_System.Repository.FirstSemesterRepository;
import Result_System.Repository.SecoundFormFillupRepository;
import Result_System.Repository.AddAllResultRepository.EighthSemesterResultRepository;
import Result_System.Repository.AddAllResultRepository.FivethSemesterResultRepository;
import Result_System.Repository.AddAllResultRepository.FourthSemesterResultRepository;
import Result_System.Repository.AddAllResultRepository.SecondSemesterResultRepository;
import Result_System.Repository.AddAllResultRepository.SeventhSemesterResultRepository;
import Result_System.Repository.AddAllResultRepository.SixthSemesterResultRepository;
import Result_System.Repository.AddAllResultRepository.ThirdSemesterResultRepository;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repo ;
	
	public void Adminpass(myAdmin e) {
		repo.save(e);
	}
//****************************************** First semester result process**************************
	@Autowired
	FirstSemesterRepository firstSemesterRepository;
	
	public double calculateGrade(double subjectValue) {
	    if (subjectValue >= 80 && subjectValue <= 100) {
	        return 4.00;
	    } else if (subjectValue >= 75 && subjectValue <= 79) {
	        return 3.75;
	    } else if (subjectValue >= 70 && subjectValue <= 74) {
	        return 3.50;
	    } else if (subjectValue >= 65 && subjectValue <= 69) {
	        return 3.25;
	    } else if (subjectValue >= 60 && subjectValue <= 64) {
	        return 3.00;
	    } else if (subjectValue >= 55 && subjectValue <= 59) {
	        return 2.75;
	    } else if (subjectValue >= 50 && subjectValue <= 54) {
	        return 2.50;
	    } else if (subjectValue >= 45 && subjectValue <= 49) {
	        return 2.25;
	    } else if (subjectValue >= 40 && subjectValue <= 44) {
	        return 2.00;
	    } else if (subjectValue <= 39) {
	        return 0.00;
	    }
	    return 0.00; // Default value if none of the conditions are metching
	}

	
	
	public void FirstSemester(FirstSemesterEntity firstSemesterEntity) {
		
		
	
		 double ENG1111=firstSemesterEntity.getENG1111() +firstSemesterEntity.getCaENG1111() ;
	
		 double ENG1112 = ((firstSemesterEntity.getENG1112()+firstSemesterEntity.getCaENG1112())*2);
		
		
		 double MATH1111=firstSemesterEntity.getMATH1111()+firstSemesterEntity.getCaMATH1111() ;
		
	
		 double PHY1111=firstSemesterEntity.getPHY1111() +firstSemesterEntity.getCaPHY1111() ;
		

		 double PHY1112=((firstSemesterEntity.getPHY1112()+firstSemesterEntity.getCaPHY1112())*2);
		
	
		 double CSE1111=firstSemesterEntity.getCSE1111() + firstSemesterEntity.getCaCSE1111()  ;
		
	
		 double CSE1112=((firstSemesterEntity.getCSE1112()+firstSemesterEntity.getCaCSE1112())*2);
	
	
		 double CSE1121=firstSemesterEntity.getCSE1121()+firstSemesterEntity.getCACSE1121(); 
		
	
		 double CSE1122=((firstSemesterEntity.getCSE1122()+firstSemesterEntity.getCACSE1122())*2);
		 
		  String Session=firstSemesterEntity.getSession();
	
	     
	      double cgpa ;
	      
	      //logic for ENG1111
	      
	      double[] subjects= {ENG1111,ENG1112,MATH1111,PHY1111,PHY1112,CSE1111,CSE1112,CSE1121,CSE1122};
	      for (int i = 0; i < subjects.length; i++) {
	    	    double grade = calculateGrade(subjects[i]);
	    	    switch (i) {
	    	        case 0:
	    	            firstSemesterEntity.setENG1111(grade);
	    	            ENG1111=grade*2;
	    	            break;
	    	        case 1:
	    	            firstSemesterEntity.setENG1112(grade);
	    	            ENG1112=grade*1.5;
	    	            break;
	    	        case 2:
	    	            firstSemesterEntity.setMATH1111(grade);
	    	            MATH1111=grade*3;
	    	            break;
	    	        case 3:
	    	            firstSemesterEntity.setPHY1111(grade);
	    	            PHY1111=grade*3;
	    	            break;
	    	        case 4:
	    	            firstSemesterEntity.setPHY1112(grade);
	    	            PHY1112=grade*1.5;
	    	            break;
	    	        case 5:
	    	            firstSemesterEntity.setCSE1111(grade);
	    	            CSE1111=grade*3;
	    	            break;
	    	        case 6:
	    	            firstSemesterEntity.setCSE1112(grade);
	    	            CSE1112=grade*1.5;
	    	            break;
	    	        case 7:
	    	            firstSemesterEntity.setCSE1121(grade);
	    	            CSE1121=grade*3;
	    	            break;
	    	        case 8:
	    	            firstSemesterEntity.setCSE1122(grade);
	    	            CSE1122=grade*1.5;
	    	            break;
	    	        // Add cases for other subjects if necessary
	    	    }
	    	}
	      
	      cgpa= ((ENG1111+ENG1112+MATH1111+PHY1111+PHY1112+CSE1111+CSE1112+CSE1121+CSE1122)/20);

	      DecimalFormat format = new DecimalFormat("0.0000");
	      double CGPA = Double.parseDouble(format.format(cgpa));
	     

	      firstSemesterEntity.setCGPA(CGPA);
	      
	      firstSemesterRepository.save(firstSemesterEntity);
	      
	      
//	   if(ENG1111>=80 && ENG1111<=100) {
//		   ENG1111=4;
//		   firstSemesterEntity.setENG1111(ENG1111);
//	   }
//	   else if(ENG1111>=75 && ENG1111<=79) {
//		   ENG1111=3.75;
//		   firstSemesterEntity.setENG1111(ENG1111);
//	   }
//	   
//	   else if(ENG1111>=70 && ENG1111<=74) {
//		   ENG1111=3.50;
//		   firstSemesterEntity.setENG1111(ENG1111);
//	   }
//	   
//	   else if(ENG1111>=65 && ENG1111<=69) {
//		   ENG1111=3.25;
//		   firstSemesterEntity.setENG1111(ENG1111);
//	   }
//
//	   else if(ENG1111>=60 && ENG1111<=64) {
//		   ENG1111=3.00;
//		   firstSemesterEntity.setENG1111(ENG1111);
//	   }
//	   else if(ENG1111>=55 && ENG1111<=59) {
//		   ENG1111=2.75;
//		   firstSemesterEntity.setENG1111(ENG1111);
//	   }
//	   else if(ENG1111>=50 && ENG1111<=54) {
//		   ENG1111=2.50;
//		   firstSemesterEntity.setENG1111(ENG1111);
//	   }
//	   else if(ENG1111>=45 && ENG1111<=49) {
//		   ENG1111=2.25;
//		   firstSemesterEntity.setENG1111(ENG1111);
//	   }
//	   else if(ENG1111>=40 && ENG1111<=44) {
//		   ENG1111=2.00;
//		   firstSemesterEntity.setENG1111(ENG1111);
//	   }
//	   else if(ENG1111<=39) {
//		   ENG1111=0.00;
//		   firstSemesterEntity.setENG1111(ENG1111);
//	   }
	      
	
	}

	  @Autowired
	  SecondSemesterResultRepository  secondSemesterResultRepository;

	public void SecondSemesterResult(SecondSemesterResultEntity secondSemesterResultEntity) {
		// TODO Auto-generated method stub
		
		 double ECON1211=secondSemesterResultEntity.getECON1211() + secondSemesterResultEntity.getCAECON1211();
		
		
		 double STAT1211=secondSemesterResultEntity.getSTAT1211() + secondSemesterResultEntity.getCASTAT1211() ;
		
		
		 double MATH1211=secondSemesterResultEntity.getMATH1211() + secondSemesterResultEntity.getCAMATH1211();
		
		
		 double CHEM1211=secondSemesterResultEntity.getCHEM1211() + secondSemesterResultEntity.getCACHEM1211();
		
		
		 double CSE1211=secondSemesterResultEntity.getCSE1211() +secondSemesterResultEntity.getCACSE1211();
		

		 double CSE1212=(secondSemesterResultEntity.getCSE1212()+secondSemesterResultEntity.getCACSE1212())*2;
		
	
		 double CSE1221=secondSemesterResultEntity.getCSE1221()+secondSemesterResultEntity.getCACSE1221();
		
		
		 double CSE1222=(secondSemesterResultEntity.getCSE1222() +secondSemesterResultEntity.getCACSE1222())*2;
		 
		 
		 double cgpa ;
	      
	      //logic for ENG1111
	      
	      double[] subjects= {ECON1211,STAT1211,MATH1211,CHEM1211,CSE1211,CSE1212,CSE1221,CSE1222};
	      for (int i = 0; i < subjects.length; i++) {
	    	    double grade = calculateGrade(subjects[i]);
	    	    switch (i) {
	    	        case 0:
	    	        	secondSemesterResultEntity.setECON1211(grade);
	    	        	ECON1211=grade*2;
	    	            break;
	    	        case 1:
	    	        	secondSemesterResultEntity.setSTAT1211(grade);
	    	        	STAT1211=grade*3;
	    	            break;
	    	        case 2:
	    	        	secondSemesterResultEntity.setMATH1211(grade);
	    	        	MATH1211=grade*3;
	    	            break;
	    	        case 3:
	    	        	secondSemesterResultEntity.setCHEM1211(grade);
	    	        	CHEM1211=grade*3;
	    	            break;
	    	        case 4:
	    	        	secondSemesterResultEntity.setCSE1211(grade);
	    	        	CSE1211=grade*3;
	    	            break;
	    	        case 5:
	    	        	secondSemesterResultEntity.setCSE1212(grade);
	    	        	CSE1212=grade*1.5;
	    	            break;
	    	        case 6:
	    	        	secondSemesterResultEntity.setCSE1221(grade);
	    	        	CSE1221=grade*3;
	    	            break;
	    	        case 7:
	    	        	secondSemesterResultEntity.setCSE1222(grade);
	    	        	CSE1222=grade*1.5;
	    	            break;
	    	        
	    	    }
	    	}
	      
	      cgpa= ((ECON1211+STAT1211+MATH1211+CHEM1211+CSE1211+CSE1212+CSE1221+CSE1222)/20);

	      DecimalFormat format = new DecimalFormat("0.0000");
	      double CGPA = Double.parseDouble(format.format(cgpa));
	     

	      secondSemesterResultEntity.setCGPA(CGPA);
		
	      secondSemesterResultRepository.save(secondSemesterResultEntity);
		
	}

//**************************Add third semester Result****************************************************
   @Autowired
   ThirdSemesterResultRepository thirdSemesterResultRepository;
	
	public void ThirdSemesterResult(ThirdSemesterResultEntity thirdSemesterResultEntity) {
		
		 double ACCO2111=thirdSemesterResultEntity.getACCO2111()+thirdSemesterResultEntity.getCaACCO2111();
		
	
		 double HUM2111=thirdSemesterResultEntity.getHUM2111()+thirdSemesterResultEntity.getCaHUM2111();
		
		
		 double MATH2111=thirdSemesterResultEntity.getMATH2111()+thirdSemesterResultEntity.getCaMATH2111();
		
	
		 double CSE2111=thirdSemesterResultEntity.getCSE2111()+thirdSemesterResultEntity.getCaCSE2111();
		
	
		 double CSE2121=thirdSemesterResultEntity.getCSE2121()+thirdSemesterResultEntity.getCaCSE2121();
		
	
		 double CSE2122=(thirdSemesterResultEntity.getCSE2122()+thirdSemesterResultEntity.getCaCSE2122())*2;
		
	
		 double CSE2131=thirdSemesterResultEntity.getCSE2131()+thirdSemesterResultEntity.getCaCSE2131() ;
		
		
		 double CSE2132=(thirdSemesterResultEntity.getCSE2132()+thirdSemesterResultEntity.getCaCSE2132())*2;
		
		 double cgpa ;
		 
		 
		 //logic for ENG1111
	      
	      double[] subjects= {ACCO2111,HUM2111,MATH2111,CSE2111,CSE2121,CSE2122,CSE2131,CSE2132};
	      for (int i = 0; i < subjects.length; i++) {
	    	    double grade = calculateGrade(subjects[i]);
	    	    switch (i) {
	    	        case 0:
	    	        	thirdSemesterResultEntity.setACCO2111(grade) ;
	    	        	ACCO2111=grade*2;
	    	            break;
	    	        case 1:
	    	        	thirdSemesterResultEntity.setHUM2111(grade);
	    	        	HUM2111=grade*3;
	    	            break;
	    	        case 2:
	    	        	thirdSemesterResultEntity.setMATH2111(grade);
	    	        	MATH2111=grade*3;
	    	            break;
	    	        case 3:
	    	        	thirdSemesterResultEntity.setCSE2111(grade);
	    	        	CSE2111=grade*3;
	    	            break;
	    	        case 4:
	    	        	thirdSemesterResultEntity.setCSE2121(grade);
	    	        	CSE2121=grade*3;
	    	            break;
	    	        case 5:
	    	        	thirdSemesterResultEntity.setCSE2122(grade);
	    	        	CSE2122=grade*1.5;
	    	            break;
	    	        case 6:
	    	        	thirdSemesterResultEntity.setCSE2131(grade);
	    	        	CSE2131=grade*3;
	    	            break;
	    	        case 7:
	    	        	thirdSemesterResultEntity.setCSE2132(grade);
	    	        	CSE2132=grade*1.5;
	    	            break;
	    	        
	    	    }
	    	}
	      
	      cgpa= ((ACCO2111+HUM2111+MATH2111+CSE2111+CSE2121+CSE2122+CSE2131+CSE2132)/20);

	      DecimalFormat format = new DecimalFormat("0.0000");
	      double CGPA = Double.parseDouble(format.format(cgpa));
	     

	      thirdSemesterResultEntity.setCGPA(CGPA);
		
	      thirdSemesterResultRepository.save(thirdSemesterResultEntity);
		
	}

//********************************Fourth Semester result section**************************************************
   @Autowired
   FourthSemesterResultRepository fourthSemesterResultRepository;
	public void FourthSemesterResult(FourthSemesterResultEntity fourthSemesterResultEntity) {
		System.out.println("This is Cacse2211="+fourthSemesterResultEntity.getCaCSE2211());
		 double LAW2211=fourthSemesterResultEntity.getLAW2211()+fourthSemesterResultEntity.getCaLAW2211();
		
		
		 double MATH2211 =fourthSemesterResultEntity.getMATH2211()+fourthSemesterResultEntity.getCaMATH2211() ;
		
		
		 double CSE2211=fourthSemesterResultEntity.getCSE2211()+fourthSemesterResultEntity.getCaCSE2211() ;
		
	
		 double CSE2212=(fourthSemesterResultEntity.getCSE2212()+fourthSemesterResultEntity.getCaCSE2212())*2 ;
		

		 double CSE2221=fourthSemesterResultEntity.getCSE2221()+fourthSemesterResultEntity.getCaCSE2221() ;
		
	
		 double CSE2222=(fourthSemesterResultEntity.getCSE2222()+fourthSemesterResultEntity.getCaCSE2222())*2 ;
		

		 double CSE2231=fourthSemesterResultEntity.getCSE2231()+fourthSemesterResultEntity.getCaCSE2231() ;
		
	
		 double CSE2232=(fourthSemesterResultEntity.getCSE2232()+fourthSemesterResultEntity.getCaCSE2232())*2;
		 
		 
		 double cgpa ;
		 
		 
		 //logic for ENG1111
	      
	      double[] subjects= {LAW2211,MATH2211,CSE2211,CSE2212,CSE2221,CSE2222,CSE2231,CSE2232};
	      for (int i = 0; i < subjects.length; i++) {
	    	    double grade = calculateGrade(subjects[i]);
	    	    switch (i) {
	    	        case 0:
	    	        	fourthSemesterResultEntity.setLAW2211(grade) ;
	    	        	LAW2211=grade*2;
	    	            break;
	    	        case 1:
	    	        	fourthSemesterResultEntity.setMATH2211(grade);
	    	        	MATH2211=grade*3;
	    	            break;
	    	        case 2:
	    	        	fourthSemesterResultEntity.setCSE2211(grade);
	    	        	CSE2211=grade*3;
	    	            break;
	    	        case 3:
	    	        	fourthSemesterResultEntity.setCSE2212(grade);
	    	        	CSE2212=grade*1.5;
	    	            break;
	    	        case 4:
	    	        	fourthSemesterResultEntity.setCSE2221(grade);
	    	        	CSE2221=grade*3;
	    	            break;
	    	        case 5:
	    	        	fourthSemesterResultEntity.setCSE2222(grade);
	    	        	CSE2222=grade*1.5;
	    	            break;
	    	        case 6:
	    	        	fourthSemesterResultEntity.setCSE2231(grade);
	    	        	CSE2231=grade*3;
	    	            break;
	    	        case 7:
	    	        	fourthSemesterResultEntity.setCSE2232(grade);
	    	        	CSE2232=grade*1.5;
	    	            break;
	    	        
	    	    }
	    	}
	      
	      cgpa= ((LAW2211+MATH2211+CSE2211+CSE2212+CSE2221+CSE2222+CSE2231+CSE2232)/20);

	      DecimalFormat format = new DecimalFormat("0.0000");
	      double CGPA = Double.parseDouble(format.format(cgpa));
	     

	      fourthSemesterResultEntity.setCGPA(CGPA);
		
	      fourthSemesterResultRepository.save(fourthSemesterResultEntity);
		
     
	}

//*****************************Five semester result section*******************************************
 
	@Autowired
	FivethSemesterResultRepository fivethSemesterResultRepository;
	
	public void FivethSemesterResult(FiveSemesterResultEntity fiveSemesterResultEntity) {
		
		 double CSE3111=fiveSemesterResultEntity.getCSE3111()+fiveSemesterResultEntity.getCaCSE3111();
		
		 double CSE3112=(fiveSemesterResultEntity.getCSE3112()+fiveSemesterResultEntity.getCaCSE3112())*2;
		
		 double CSE3121=fiveSemesterResultEntity.getCSE3121()+fiveSemesterResultEntity.getCaCSE3121();
		
		 double CSE3122=(fiveSemesterResultEntity.getCSE3122()+fiveSemesterResultEntity.getCaCSE3122())*2 ;
		
		 double CSE3131=fiveSemesterResultEntity.getCSE3131()+fiveSemesterResultEntity.getCaCSE3131();
		
		 double CSE3132=(fiveSemesterResultEntity.getCSE3132()+fiveSemesterResultEntity.getCaCSE3132())*2 ;
		
		 double CSE3141=fiveSemesterResultEntity.getCSE3141()+fiveSemesterResultEntity.getCaCSE3141();
		
		 double CSE3142=(fiveSemesterResultEntity.getCSE3142()+fiveSemesterResultEntity.getCaCSE3142())*2;
		
		 double CSE3152=(fiveSemesterResultEntity.getCSE3152()+fiveSemesterResultEntity.getCaCSE3152())*2 ;
		 
		 
 double cgpa ;
		 
		 
		 //logic for ENG1111
	      
	      double[] subjects= {CSE3111,CSE3112,CSE3121,CSE3122,CSE3131,CSE3132,CSE3141,CSE3142,CSE3152};
	      for (int i = 0; i < subjects.length; i++) {
	    	    double grade = calculateGrade(subjects[i]);
	    	    switch (i) {
	    	        case 0:
	    	        	fiveSemesterResultEntity.setCSE3111(grade) ;
	    	        	CSE3111=grade*3;
	    	            break;
	    	        case 1:
	    	        	fiveSemesterResultEntity.setCSE3112(grade);
	    	        	CSE3112=grade*1.5;
	    	            break;
	    	        case 2:
	    	        	fiveSemesterResultEntity.setCSE3121(grade);
	    	        	CSE3121=grade*3;
	    	            break;
	    	        case 3:
	    	        	fiveSemesterResultEntity.setCSE3122(grade);
	    	        	CSE3122=grade*1.5;
	    	            break;
	    	        case 4:
	    	        	fiveSemesterResultEntity.setCSE3131(grade);
	    	        	CSE3131=grade*3;
	    	            break;
	    	        case 5:
	    	        	fiveSemesterResultEntity.setCSE3132(grade);
	    	        	CSE3132=grade*1.5;
	    	            break;
	    	        case 6:
	    	        	fiveSemesterResultEntity.setCSE3141(grade);
	    	        	CSE3141=grade*3;
	    	            break;
	    	        case 7:
	    	        	fiveSemesterResultEntity.setCSE3142(grade);
	    	        	CSE3142=grade*1.5;
	    	            break;
	    	        case 8:
	    	        	fiveSemesterResultEntity.setCSE3152(grade);
	    	        	CSE3152=grade*1;
	    	            break;
	    	        
	    	    }
	    	}
	      
	      cgpa= ((CSE3111+CSE3112+CSE3121+CSE3122+CSE3131+CSE3132+CSE3141+CSE3142+CSE3152)/19);

	      DecimalFormat format = new DecimalFormat("0.0000");
	      double CGPA = Double.parseDouble(format.format(cgpa));
	     

	      fiveSemesterResultEntity.setCGPA(CGPA);
		
	      fivethSemesterResultRepository.save(fiveSemesterResultEntity);
	
	}

//******************************Sixth semester Result section*********************************************

	@Autowired
	SixthSemesterResultRepository sixthSemesterResultRepository;
	public void SixthSemesterResult(SixthSemesterResultEntity sixthSemesterResultEntity) {
	
		
		 double  CSE3211=sixthSemesterResultEntity.getCSE3211()+sixthSemesterResultEntity.getCaCSE3211() ;
	
		 double  CSE3212=(sixthSemesterResultEntity.getCSE3212()+sixthSemesterResultEntity.getCaCSE3212())*2;
	
		 double  CSE3221=sixthSemesterResultEntity.getCSE3221()+sixthSemesterResultEntity.getCaCSE3221();

		 double  CSE3222=(sixthSemesterResultEntity.getCSE3222()+sixthSemesterResultEntity.getCaCSE3222())*2;

		 double  CSE3231=sixthSemesterResultEntity.getCSE3231()+sixthSemesterResultEntity.getCaCSE3231();

		 double  CSE3232=(sixthSemesterResultEntity.getCSE3232()+sixthSemesterResultEntity.getCaCSE3232())*2;

		 double  CSE3241=sixthSemesterResultEntity.getCSE3241()+sixthSemesterResultEntity.getCaCSE3241();

		 double  CSE3242=(sixthSemesterResultEntity.getCSE3242()+sixthSemesterResultEntity.getCaCSE3242())*2;
		
		 double  CSE3251=sixthSemesterResultEntity.getCSE3251()+sixthSemesterResultEntity.getCaCSE3251();
	
		
        double cgpa ;
		 
		 
		 //logic for ENG1111
	      
	      double[] subjects= {CSE3211,CSE3212,CSE3221,CSE3222,CSE3231,CSE3232,CSE3241,CSE3242,CSE3251};
	      for (int i = 0; i < subjects.length; i++) {
	    	    double grade = calculateGrade(subjects[i]);
	    	    switch (i) {
	    	        case 0:
	    	        	sixthSemesterResultEntity.setCSE3211(grade) ;
	    	        	CSE3211=grade*3;
	    	            break;
	    	        case 1:
	    	        	sixthSemesterResultEntity.setCSE3212(grade);
	    	        	CSE3212=grade*1.5;
	    	            break;
	    	        case 2:
	    	        	sixthSemesterResultEntity.setCSE3221(grade);
	    	        	CSE3221=grade*3;
	    	            break;
	    	        case 3:
	    	        	sixthSemesterResultEntity.setCSE3222(grade);
	    	        	CSE3222=grade*1.5;
	    	            break;
	    	        case 4:
	    	        	sixthSemesterResultEntity.setCSE3231(grade);
	    	        	CSE3231=grade*3;
	    	            break;
	    	        case 5:
	    	        	sixthSemesterResultEntity.setCSE3232(grade);
	    	        	CSE3232=grade*1.5;
	    	            break;
	    	        case 6:
	    	        	sixthSemesterResultEntity.setCSE3241(grade);
	    	        	CSE3241=grade*3;
	    	            break;
	    	        case 7:
	    	        	sixthSemesterResultEntity.setCSE3242(grade);
	    	        	CSE3242=grade*1.5;
	    	            break;
	    	        case 8:
	    	        	sixthSemesterResultEntity.setCSE3251(grade);
	    	        	CSE3251=grade*3;
	    	            break;
	    	        
	    	    }
	    	}
	      
	      cgpa= ((CSE3211+CSE3212+CSE3221+CSE3222+CSE3231+CSE3232+CSE3241+CSE3242+CSE3251)/21);
	      
	      DecimalFormat format = new DecimalFormat("0.0000");
	      double CGPA = Double.parseDouble(format.format(cgpa));
	     

	      sixthSemesterResultEntity.setCGPA(CGPA);
		
	      sixthSemesterResultRepository.save(sixthSemesterResultEntity);
	
	}

//*****************************Seventh semester result section*********************************************
 @Autowired
 SeventhSemesterResultRepository seventhSemesterResultRepository;
	public void SeventhSemesterResult(SeventhSemesterResultEntity seventhSemesterResultEntity) {
		
		 double CSE4111=seventhSemesterResultEntity.getCSE4111()+seventhSemesterResultEntity.getCaCSE4111();
		
		 double CSE4112=(seventhSemesterResultEntity.getCSE4112()+seventhSemesterResultEntity.getCaCSE4112())*2;
		
		 double CSE4121=seventhSemesterResultEntity.getCSE4121()+seventhSemesterResultEntity.getCaCSE4121();
		
		 double CSE4122=(seventhSemesterResultEntity.getCSE4122()+seventhSemesterResultEntity.getCaCSE4122())*2;
		
		 double CSE4131=seventhSemesterResultEntity.getCSE4131()+seventhSemesterResultEntity.getCaCSE4131();
		
		 double CSE4132=(seventhSemesterResultEntity.getCSE4132()+seventhSemesterResultEntity.getCaCSE4132())*2;
		
		 double CSE4141=seventhSemesterResultEntity.getCSE4141()+seventhSemesterResultEntity.getCaCSE4141();
		
		 double CSE4142=(seventhSemesterResultEntity.getCSE4142()+seventhSemesterResultEntity.getCaCSE4142())*2;
		 double CSE4180=(seventhSemesterResultEntity.getCSE4180()+seventhSemesterResultEntity.getCaCSE4180())*2;
		 double cgpa ;
		 //logic for ENG1111
	      
	      double[] subjects= {CSE4111,CSE4112,CSE4121,CSE4122,CSE4131,CSE4132,CSE4141,CSE4142,CSE4180};
	      for (int i = 0; i < subjects.length; i++) {
	    	    double grade = calculateGrade(subjects[i]);
	    	    switch (i) {
	    	        case 0:
	    	        	seventhSemesterResultEntity.setCSE4111(grade) ;
	    	        	CSE4111=grade*3;
	    	            break;
	    	        case 1:
	    	        	seventhSemesterResultEntity.setCSE4112(grade);
	    	        	CSE4112=grade*1.5;
	    	            break;
	    	        case 2:
	    	        	seventhSemesterResultEntity.setCSE4121(grade);
	    	        	CSE4121=grade*3;
	    	            break;
	    	        case 3:
	    	        	seventhSemesterResultEntity.setCSE4122(grade);
	    	        	CSE4122=grade*1.5;
	    	            break;
	    	        case 4:
	    	        	seventhSemesterResultEntity.setCSE4131(grade);
	    	        	CSE4131=grade*3;
	    	            break;
	    	        case 5:
	    	        	seventhSemesterResultEntity.setCSE4132(grade);
	    	        	CSE4132=grade*1.5;
	    	            break;
	    	        case 6:
	    	        	seventhSemesterResultEntity.setCSE4141(grade);
	    	        	CSE4141=grade*3;
	    	            break;
	    	        case 7:
	    	        	seventhSemesterResultEntity.setCSE4142(grade);
	    	        	CSE4142=grade*1.5;
	    	            break;
	    	        case 8:
	    	        	seventhSemesterResultEntity.setCSE4180(grade);
	    	        	CSE4180=grade*2;
	    	            break;
	    	        
	    	    }
	    	}
	      
	      cgpa= ((CSE4111+CSE4112+CSE4121+CSE4122+CSE4131+CSE4132+CSE4141+CSE4142+CSE4180)/20);
	      
	      DecimalFormat format = new DecimalFormat("0.0000");
	      double CGPA = Double.parseDouble(format.format(cgpa));
	     

	      seventhSemesterResultEntity.setCGPA(CGPA);
	      
		
	      seventhSemesterResultRepository.save(seventhSemesterResultEntity);
		 
	}

//******************************Eight semester result section*-*******************************************

	@Autowired
	EighthSemesterResultRepository eighthSemesterResultRepository;
	
	public void EighthSemesterResult(EighthSemesterResultEntity eighthSemesterResultEntity) {
		
		 double CSE4211 =eighthSemesterResultEntity.getCSE4211()+eighthSemesterResultEntity.getCaCSE4211() ;
		
		 double CSE4212 =(eighthSemesterResultEntity.getCSE4212()+eighthSemesterResultEntity.getCaCSE4212())*2;
	
		 double CSE4221 =eighthSemesterResultEntity.getCSE4221()+eighthSemesterResultEntity.getCaCSE4221();
	
		 double CSE4222 =(eighthSemesterResultEntity.getCSE4222()+eighthSemesterResultEntity.getCaCSE4222())*2;
	
		 double CSE4231 =eighthSemesterResultEntity.getCSE4231()+eighthSemesterResultEntity.getCaCSE4231();
	
		 double CSE4271 =eighthSemesterResultEntity.getCSE4271()+eighthSemesterResultEntity.getCaCSE4271();
	
		 double CSE4272 =(eighthSemesterResultEntity.getCSE4272()+eighthSemesterResultEntity.getCaCSE4272())*2;
	
		 double CSE4270 =(eighthSemesterResultEntity.getCSE4270()+eighthSemesterResultEntity.getCaCSE4270())*2;
	
		 double CSE4280 =(eighthSemesterResultEntity.getCSE4280()+eighthSemesterResultEntity.getCaCSE4280())*2;
	
		 double CSE4290 =(eighthSemesterResultEntity.getCSE4290())*2;
		 
		 double cgpa ;
		 //logic for 
	      
	      double[] subjects= {CSE4211,CSE4212,CSE4221,CSE4222,CSE4231,CSE4271,CSE4272,CSE4270,CSE4280,CSE4290};
	      for (int i = 0; i < subjects.length; i++) {
	    	    double grade = calculateGrade(subjects[i]);
	    	    switch (i) {
	    	        case 0:
	    	        	eighthSemesterResultEntity.setCSE4211(grade) ;
	    	        	CSE4211=grade*3;
	    	            break;
	    	        case 1:
	    	        	eighthSemesterResultEntity.setCSE4212(grade);
	    	        	CSE4212=grade*1.5;
	    	            break;
	    	        case 2:
	    	        	eighthSemesterResultEntity.setCSE4221(grade);
	    	        	CSE4221=grade*3;
	    	            break;
	    	        case 3:
	    	        	eighthSemesterResultEntity.setCSE4222(grade);
	    	        	CSE4222=grade*1.5;
	    	            break;
	    	        case 4:
	    	        	eighthSemesterResultEntity.setCSE4231(grade);
	    	        	CSE4231=grade*3;
	    	            break;
	    	        case 5:
	    	        	eighthSemesterResultEntity.setCSE4271(grade);
	    	        	CSE4271=grade*3;
	    	            break;
	    	        case 6:
	    	        	eighthSemesterResultEntity.setCSE4272(grade);
	    	        	CSE4272=grade*1.5;
	    	            break;
	    	        case 7:
	    	        	eighthSemesterResultEntity.setCSE4270(grade);
	    	        	CSE4270=grade*1;
	    	            break;
	    	        case 8:
	    	        	eighthSemesterResultEntity.setCSE4280(grade);
	    	        	CSE4280=grade*2;
	    	            break;
	    	        case 9:
	    	        	eighthSemesterResultEntity.setCSE4290(grade);
	    	        	CSE4290=grade*2;
	    	            break;
	    	        
	    	        
	    	    }
	    	}
	      
	      cgpa= ((CSE4211+CSE4212+CSE4221+CSE4222+CSE4231+CSE4271+CSE4272+CSE4270+CSE4280+CSE4290)/21.5);
	      
	      DecimalFormat format = new DecimalFormat("0.0000");
	      double CGPA = Double.parseDouble(format.format(cgpa));
	     

	      eighthSemesterResultEntity.setCGPA(CGPA);
		
	      eighthSemesterResultRepository.save(eighthSemesterResultEntity);
		 
		
	}
		
	

	
	
}
