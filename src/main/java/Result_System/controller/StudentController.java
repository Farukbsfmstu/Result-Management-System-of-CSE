package Result_System.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Helper.Message;
import Result_System.Entity.EightFormFillupEntity;
import Result_System.Entity.FirstSemesterEntity;
import Result_System.Entity.FiveFormFillupEntity;
import Result_System.Entity.ForuthFormFillupEntity;
import Result_System.Entity.SecoundFormFillupEntity;
import Result_System.Entity.SevenFormFillupEntity;
import Result_System.Entity.SixFormFillupEntity;
import Result_System.Entity.StudentFormFillupEntity;
import Result_System.Entity.ThirdFormFillupEntity;
import Result_System.Entity.AddAllResultEntity.EighthSemesterResultEntity;
import Result_System.Entity.AddAllResultEntity.FiveSemesterResultEntity;
import Result_System.Entity.AddAllResultEntity.FourthSemesterResultEntity;
import Result_System.Entity.AddAllResultEntity.SecondSemesterResultEntity;
import Result_System.Entity.AddAllResultEntity.SeventhSemesterResultEntity;
import Result_System.Entity.AddAllResultEntity.SixthSemesterResultEntity;
import Result_System.Entity.AddAllResultEntity.ThirdSemesterResultEntity;
import Result_System.Repository.EightFormFillupRepository;
import Result_System.Repository.FirstSemesterRepository;
import Result_System.Repository.FiveFormFillupRepository;
import Result_System.Repository.FourthFormFillupRepository;
import Result_System.Repository.SecoundFormFillupRepository;
import Result_System.Repository.SevenFormFillupRepository;
import Result_System.Repository.SignUpRepository;
import Result_System.Repository.SixFormFillupRepository;
import Result_System.Repository.StudentFormFillupRepository;
import Result_System.Repository.ThirdFormFillupRepository;
import Result_System.Repository.AddAllResultRepository.EighthSemesterResultRepository;
import Result_System.Repository.AddAllResultRepository.FivethSemesterResultRepository;
import Result_System.Repository.AddAllResultRepository.FourthSemesterResultRepository;
import Result_System.Repository.AddAllResultRepository.SecondSemesterResultRepository;
import Result_System.Repository.AddAllResultRepository.SeventhSemesterResultRepository;
import Result_System.Repository.AddAllResultRepository.SixthSemesterResultRepository;
import Result_System.Repository.AddAllResultRepository.ThirdSemesterResultRepository;
import Result_System.Service.FormFillupStudentinfoService;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	private SignUpRepository signuprepo ;
	@Autowired
	private FirstSemesterRepository firstSemesterRepository;
	
	@Autowired
	private FormFillupStudentinfoService studentinfo ;
	
	 @Autowired
	    private StudentFormFillupRepository studentFormFillupRepository;

	
	
@RequestMapping("/studentdash")	
public String studentdash() {
	return "students/Student_Dashboard" ;
}

@GetMapping("/commingSoon")
public String commingSoon() {
	   return "students/CommingSoon";
}

@GetMapping("/addstudent")
public String studentinfo() {
	   return "students/AddStudentinfo";
}

@GetMapping("/Semesteroptionstudent")
public String Semesteroptionstudent() {
	   return "students/SemesteriptionStudent";
}



//choose which semester want to fillup the form
@GetMapping("/FormFillup")
public String FormFillup() {
	return "students/SemesterFormFillup";
}

@GetMapping("/formFillup")
public String formFillup(Model model) {
	 List<String> sessions = studentFormFillupRepository.findDistinctSessions();
     model.addAttribute("sessions", sessions);
    
 	return "students/FormFillupStudent";
}


//*********** First semester Student information form fillup collect*************************************************
@PostMapping("/formfillupData")
	   public String AddStudentInfo(@ModelAttribute StudentFormFillupEntity formInfo,Model model,HttpSession session,Principal principal) {
	   try {
		   
			formInfo.setDate(LocalDate.now());
			// *****genate random number**********

			formInfo.setSubmissionID(studentinfo.genareteRandomNumber());
			studentinfo.addstudentinfo(formInfo);

			String mailTo = principal.getName();

			sendEmail(formInfo, mailTo);

			session.setAttribute("message", new Message("Successfully Submitted", "alert-success"));
			model.addAttribute("form", formInfo);

			return "redirect:/student/formFillup";
		   
	   }catch(Exception e) {
		   e.printStackTrace();
		   session.setAttribute("message", new Message("Something went wrong!"+e.getMessage(),"alert-danger"));
		   return "redirect:/student/formFillup" ;
	   }
	
	  
}

private void sendEmail(StudentFormFillupEntity formInfo,String mail) {
	MimeMessage message = emailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
    
    try {
    	
    	helper.setTo(mail);
    	helper.setSubject("Form-Fillup Successful");
    	helper.setText("Thank you for your  First semester Form fillup registering.\n"
    			+ " ! Your submission ID is: " + formInfo.getSubmissionID()+"\nPlease use this Submission ID to pay your fee following the Exam Controller rules.");
    	emailSender.send(message);
    }catch(Exception e) {
    	e.printStackTrace();
    }
}


//*********************************************secound semester***********************

@Autowired
private SecoundFormFillupRepository secoundFormFillupRepository ;

@GetMapping("/SecoundformFillup")
public String SecoundformFillup(Model model) {
	return "students/SecoundFormFillup";
}


@PostMapping("/SecoundformFillupData")
public String formfillupData(@ModelAttribute SecoundFormFillupEntity secoundFormFillupEntity, Model model,HttpSession session,Principal principal) {
	secoundFormFillupEntity.setDate(LocalDate.now());
//***************************************************this part genarete random number****************	
	//String uniqueId = UUID.randomUUID().toString();

  //*************************End  part genarete random number********************************************** 
     
	secoundFormFillupEntity.setSubmissionID(studentinfo.genareteRandomNumber());
	String mailTo=principal.getName();
	
	secoundFormFillupRepository.save(secoundFormFillupEntity) ;
	
	sendEmail(secoundFormFillupEntity,mailTo);
	
	session.setAttribute("message", new Message("Successfully Submitted","alert-success"));
	
	return "students/SecoundFormFillup";
}

//**********************send mail******************

private void sendEmail(SecoundFormFillupEntity secoundFormFillupEntity,String mail) {
	MimeMessage message = emailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
    
    try {
    	
    	helper.setTo(mail);
    	helper.setSubject("Form-Fillup Successful");
    	helper.setText("Thank you for your  Secound semester Form fillup registering.\n"
    			+ " ! Your submission ID is: " + secoundFormFillupEntity.getSubmissionID()+"\nPlease use this Submission ID to pay your fee following the Exam Controller rules.");
    	emailSender.send(message);
    }catch(Exception e) {
    	e.printStackTrace();
    }
}


//*****************************************Third Semester Form Fillup**************************************************
@Autowired
private ThirdFormFillupRepository thirdFormFillupRepository;


@GetMapping("/ThirdformFillup")
public String ThirdformFillup() {
	return "students/ThirdformFillup";
}


@PostMapping("/ThirdformFillupData")
public String ThirdformFillupData(@ModelAttribute ThirdFormFillupEntity thirdFormFillupEntity,HttpSession session,Principal principal  ) {
	
	thirdFormFillupEntity.setDate(LocalDate.now());
	    
     thirdFormFillupEntity.setSubmissionID(studentinfo.genareteRandomNumber());
     String mailTo=principal.getName();
     
     thirdFormFillupRepository.save(thirdFormFillupEntity);
     
     
    sendEmail(thirdFormFillupEntity,mailTo);
 	
 	session.setAttribute("message", new Message("Successfully Submitted","alert-success"));

	return "students/ThirdformFillup";
}


//**********************send mail******************

private void sendEmail(ThirdFormFillupEntity thirdFormFillupEntity,String mail) {
	MimeMessage message = emailSender.createMimeMessage();
  MimeMessageHelper helper = new MimeMessageHelper(message);
  
  try {
  	
  	helper.setTo(mail);
  	helper.setSubject("Form-Fillup Successful");
  	helper.setText("Thank you for your  Third semester Form fillup registering.\n"
  			+ " ! Your submission ID is: " + thirdFormFillupEntity.getSubmissionID()+"\nPlease use this Submission ID to pay your fee following the Exam Controller rules.");
  	emailSender.send(message);
  }catch(Exception e) {
  	e.printStackTrace();
  }
}
//**************************************Fourth Form fillup**********************************************************

@Autowired
private FourthFormFillupRepository fourthFormFillupRepository ;

@GetMapping("/FourthformFillup")
public String FourthformFillup() {
	return "students/FourthformFillup";
}

@PostMapping("/FourthformFillupData")
public String FourthformFillupData(@ModelAttribute ForuthFormFillupEntity foruthFormFillupEntity, HttpSession session,Principal principal) {
	
	foruthFormFillupEntity.setDate(LocalDate.now());
//*****genate random number**********
	
     foruthFormFillupEntity.setSubmissionID(studentinfo.genareteRandomNumber());
     
     fourthFormFillupRepository.save(foruthFormFillupEntity);
     String mailTo=principal.getName();
     sendEmail(foruthFormFillupEntity,mailTo);
  	
  	session.setAttribute("message", new Message("Successfully Submitted","alert-success"));

	
	return "students/FourthformFillup";
}
// sent mail*********
private void sendEmail(ForuthFormFillupEntity foruthFormFillupEntity,String mail) {
	MimeMessage message = emailSender.createMimeMessage();
  MimeMessageHelper helper = new MimeMessageHelper(message);
  
  try {
  	
  	helper.setTo(mail);
  	helper.setSubject("Form-Fillup Successful");
  	helper.setText("Thank you for your  Fourth semester Form fillup registering.\n"
  			+ " ! Your submission ID is: " + foruthFormFillupEntity.getSubmissionID()+"\nPlease use this Submission ID to pay your fee following the Exam Controller rules.");
  	emailSender.send(message);
  }catch(Exception e) {
  	e.printStackTrace();
  }
}

//****************************************Five th form fillup**********************************
@Autowired
private FiveFormFillupRepository fiveFormFillupRepository;

@GetMapping("/FiveformFillup")
public String FiveformFillup() {
	return "students/FiveformFillup" ;
}


@PostMapping("/FiveformFillupData")
public String FiveformFillupData(@ModelAttribute FiveFormFillupEntity fiveFormFillupEntity ,  HttpSession session,Principal principal ) {
	

	fiveFormFillupEntity.setDate(LocalDate.now());
//*****genate random number**********
	
	fiveFormFillupEntity.setSubmissionID(studentinfo.genareteRandomNumber());
     
	fiveFormFillupRepository.save(fiveFormFillupEntity);
     String mailTo=principal.getName();
     sendEmail(fiveFormFillupEntity,mailTo);
  	
  	session.setAttribute("message", new Message("Successfully Submitted","alert-success"));

	
	return "students/FiveformFillup" ;
}


//sent mail*********
private void sendEmail(FiveFormFillupEntity fiveFormFillupEntity,String mail) {
	MimeMessage message = emailSender.createMimeMessage();
MimeMessageHelper helper = new MimeMessageHelper(message);

try {
	
	helper.setTo(mail);
	helper.setSubject("Form-Fillup Successful");
	helper.setText("Thank you for your  Five'th semester Form fillup registering.\n"
			+ " ! Your submission ID is: " + fiveFormFillupEntity.getSubmissionID()+"\nPlease use this Submission ID to pay your fee following the Exam Controller rules.");
	emailSender.send(message);
}catch(Exception e) {
	e.printStackTrace();
}
}

//********************Six th form fillup******************************************************************
@Autowired
private SixFormFillupRepository sixFormFillupRepository;

@GetMapping("/SixFormFillup")
public String SixFormFillup() {
	return "students/SixFormFillup";
}


@PostMapping("/SixFormFillupData")
public String SixFormFillupData(@ModelAttribute SixFormFillupEntity sixFormFillupEntity, HttpSession session,Principal principal) {

	sixFormFillupEntity.setDate(LocalDate.now());
//*****genate random number**********
	
	sixFormFillupEntity.setSubmissionID(studentinfo.genareteRandomNumber());
     
	sixFormFillupRepository.save(sixFormFillupEntity);
     String mailTo=principal.getName();
     sendEmail(sixFormFillupEntity,mailTo);
  	
  	session.setAttribute("message", new Message("Successfully Submitted","alert-success"));
	
	
	return "students/SixFormFillup";
}


//sent mail*********
private void sendEmail(SixFormFillupEntity sixFormFillupEntity, String mail) {
	MimeMessage message = emailSender.createMimeMessage();
	MimeMessageHelper helper = new MimeMessageHelper(message);

	try {

		helper.setTo(mail);
		helper.setSubject("Form-Fillup Successful");
		helper.setText("Thank you for your  Six'th semester Form fillup registering.\n" + " ! Your submission ID is: "
				+ sixFormFillupEntity.getSubmissionID()
				+ "\nPlease use this Submission ID to pay your fee following the Exam Controller rules.");
		emailSender.send(message);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//***************Seven Form fillup**********************************************************************

@Autowired
private SevenFormFillupRepository sevenFormFillupRepository;

@GetMapping("/SevenformFillup")
public String SevenformFillup() {
	return "students/SevenFormFillup" ;
}

@PostMapping("/SevenFormFillupData")
public String SevenFormFillupData(@ModelAttribute SevenFormFillupEntity sevenFormFillupEntity,HttpSession session, Principal principal) {
	
	sevenFormFillupEntity.setDate(LocalDate.now());
	//*****genate random number**********
		
	sevenFormFillupEntity.setSubmissionID(studentinfo.genareteRandomNumber());
	     
	sevenFormFillupRepository.save(sevenFormFillupEntity);
	     String mailTo=principal.getName();
	     sendEmail(sevenFormFillupEntity,mailTo);
	  	
	  	session.setAttribute("message", new Message("Successfully Submitted","alert-success"));
	
	return "students/SevenFormFillup" ;
}

//****email sender*************
private void sendEmail(SevenFormFillupEntity sevenFormFillupEntity, String mail) {
	MimeMessage message = emailSender.createMimeMessage();
	MimeMessageHelper helper = new MimeMessageHelper(message);

	try {

		helper.setTo(mail);
		helper.setSubject("Form-Fillup Successful");
		helper.setText("Thank you for your  Seven'th semester Form fillup registering.\n" + " ! Your submission ID is: "
				+ sevenFormFillupEntity.getSubmissionID()
				+ "\nPlease use this Submission ID to pay your fee following the Exam Controller rules.");
		emailSender.send(message);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//*********************Eight Form fillup**************************************************************
@Autowired
private EightFormFillupRepository eightFormFillupRepository;

@GetMapping("/EightFormFillup")
public String EightFormFillup() {
	return "students/EightFormFillup";
}

@PostMapping("/EightFormFillupData")
public String EightFormFillupData(@ModelAttribute EightFormFillupEntity eightFormFillupEntity,HttpSession session,Principal principal) {
	
	eightFormFillupEntity.setDate(LocalDate.now());
	//*****genate random number**********
		
	eightFormFillupEntity.setSubmissionID(studentinfo.genareteRandomNumber());
	     
	eightFormFillupRepository.save(eightFormFillupEntity);
	     String mailTo=principal.getName();
	     sendEmail(eightFormFillupEntity,mailTo);
	  	
	  	session.setAttribute("message", new Message("Successfully Submitted","alert-success"));
	
	return "students/EightFormFillup";
}

//****email sender*************
private void sendEmail(EightFormFillupEntity eightFormFillupEntity, String mail) {
	MimeMessage message = emailSender.createMimeMessage();
	MimeMessageHelper helper = new MimeMessageHelper(message);

	try {

		helper.setTo(mail);
		helper.setSubject("Form-Fillup Successful");
		helper.setText("Thank you for your  Eight'th semester Form fillup registering.\n" + " ! Your submission ID is: "
				+ eightFormFillupEntity.getSubmissionID()
				+ "\nPlease use this Submission ID to pay your fee following the Exam Controller rules.");
		emailSender.send(message);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//*********************************************FORM FILLUP END***************************************************


//result find all semester here...........................
@GetMapping("/FirstsemesterresultFind")
public String FirstsemesterresultFind() {
return "students/StudentSearchResult" ;     
}

@GetMapping("/secondsemesterresultFind")
public String secondsemesterresultFind() {
return "students/StudentSearchResultSecound" ;     
}

@GetMapping("/ThirdsemesterresultFind")
public String ThirdsemesterresultFind() {
return "students/StudentSearchResultThird" ;     
}


@GetMapping("/FourthsemesterresultFind")
public String FourthsemesterresultFind() {
return "students/StudentSearchResultFourth" ;     
}

@GetMapping("/FivethsemesterresultFind")
public String FivethsemesterresultFind() {
return "students/StudentSearchResultFive" ;     
}

@GetMapping("/SixthsemesterresultFind")
public String SixthsemesterresultFind() {
return "students/StudentSearchResultSixth" ;     
}


@GetMapping("/SeventhsemesterresultFind")
public String SeventhsemesterresultFind() {
return "students/StudentSearchResultSeven" ;     
}

@GetMapping("/EightthsemesterresultFind")
public String EightthsemesterresultFind() {
return "students/StudentSearchResultEight" ;     
}


//result search End....................................

//first semester Individual student result
@PostMapping("/firstSemesterIndividualResult")
public String firstSemesterIndividualResult(@RequestParam("StudentsID") Long fromStudentID, Model model,
		Principal principal, HttpSession session) {
	try {
		String s = principal.getName();
		Long studentIdfind = signuprepo.findStudentIdByUsername(s);

		if (fromStudentID.equals(studentIdfind)) {
			FirstSemesterEntity YourResult = firstSemesterRepository.getStudentResult(fromStudentID);
			if(YourResult ==null) {
				session.setAttribute("message", new Message("Sorry ,Result not published", "alert-danger"));
			}
			model.addAttribute("YourResult", YourResult);

		}

		else {
			session.setAttribute("message", new Message("Sorry ,Provide your own ID", "alert-danger"));
		}

		return "students/StudentSearchResult";

	} catch (Exception e) {
		e.printStackTrace();
		session.setAttribute("message", new Message("Oh! ,something went wrong!", "alert-danger"));
		return "students/StudentSearchResult";
	}

}

//********************************Second semester Individual find result****************************************

@Autowired
SecondSemesterResultRepository  secondSemesterResultRepository;
@PostMapping("/SecoundSemesterIndividualResult")
public String SecoundSemesterIndividualResult(@RequestParam("StudentsID") Long fromStudentID, Model model,
		Principal principal, HttpSession session) {
	try {
		String s = principal.getName();
		Long studentIdfind = signuprepo.findStudentIdByUsername(s);

		if (fromStudentID.equals(studentIdfind)) {
			SecondSemesterResultEntity YourResult = secondSemesterResultRepository.getStudentResult(fromStudentID);
			if(YourResult ==null) {
				session.setAttribute("message", new Message("Sorry ,Result not published", "alert-danger"));
			}
			model.addAttribute("YourResult", YourResult);

		}

		else {
			session.setAttribute("message", new Message("Sorry ,Provide your own ID", "alert-danger"));
		}

		return "students/StudentSearchResultSecound";

	} catch (Exception e) {
		e.printStackTrace();
		session.setAttribute("message", new Message("Oh! ,something went wrong!", "alert-danger"));
		return "students/StudentSearchResultSecound";
	}

}


//********************************Third semester Individual find result****************************************
@Autowired
ThirdSemesterResultRepository thirdSemesterResultRepository;
@PostMapping("/ThirdSemesterIndividualResult")
public String ThirdSemesterIndividualResult(@RequestParam("StudentsID") Long fromStudentID, Model model,
		Principal principal, HttpSession session) {
	try {
		String s = principal.getName();
		Long studentIdfind = signuprepo.findStudentIdByUsername(s);

		if (fromStudentID.equals(studentIdfind)) {
			ThirdSemesterResultEntity YourResult = thirdSemesterResultRepository.getStudentResult(fromStudentID);
			if(YourResult ==null) {
				session.setAttribute("message", new Message("Sorry ,Result not published", "alert-danger"));
			}
			model.addAttribute("YourResult", YourResult);

		}

		else {
			session.setAttribute("message", new Message("Sorry ,Provide your own ID", "alert-danger"));
		}

		return "students/StudentSearchResultThird";

	} catch (Exception e) {
		e.printStackTrace();
		session.setAttribute("message", new Message("Oh! ,something went wrong!", "alert-danger"));
		return "students/StudentSearchResultThird";
	}

}
//********************************Fourth semester Individual find result****************************************

@Autowired
FourthSemesterResultRepository fourthSemesterResultRepository;

@PostMapping("/FourthSemesterIndividualResult")
public String FourthSemesterIndividualResult(@RequestParam("StudentsID") Long fromStudentID, Model model,
		Principal principal, HttpSession session) {
	try {
		String s = principal.getName();
		Long studentIdfind = signuprepo.findStudentIdByUsername(s);

		if (fromStudentID.equals(studentIdfind)) {
			FourthSemesterResultEntity YourResult = fourthSemesterResultRepository.getStudentResult(fromStudentID);
			if(YourResult ==null) {
				session.setAttribute("message", new Message("Sorry ,Result not published", "alert-danger"));
			}
			model.addAttribute("YourResult", YourResult);

		}

		else {
			session.setAttribute("message", new Message("Sorry ,Provide your own ID", "alert-danger"));
		}

		return "students/StudentSearchResultFourth";

	} catch (Exception e) {
		e.printStackTrace();
		session.setAttribute("message", new Message("Oh! ,something went wrong!", "alert-danger"));
		return "students/StudentSearchResultFourth";
	}

}

//********************************Fiveth semester Individual find result****************************************
@Autowired
FivethSemesterResultRepository fivethSemesterResultRepository;

@PostMapping("/FivethSemesterIndividualResult")
public String FivethSemesterIndividualResult(@RequestParam("StudentsID") Long fromStudentID, Model model,
		Principal principal, HttpSession session) {
	try {
		String s = principal.getName();
		Long studentIdfind = signuprepo.findStudentIdByUsername(s);

		if (fromStudentID.equals(studentIdfind)) {
			FiveSemesterResultEntity YourResult = fivethSemesterResultRepository.getStudentResult(fromStudentID);
			
			if(YourResult ==null) {
				session.setAttribute("message", new Message("Sorry ,Result not published", "alert-danger"));
			}
			model.addAttribute("YourResult", YourResult);

		}

		else {
			session.setAttribute("message", new Message("Sorry ,Provide your own ID", "alert-danger"));
		}

		return "students/StudentSearchResultFive";

	} catch (Exception e) {
		e.printStackTrace();
		session.setAttribute("message", new Message("Oh! ,something went wrong!", "alert-danger"));
		return "students/StudentSearchResultFive";
	}

}

//********************************Sixth semester Individual find result****************************************

@Autowired
SixthSemesterResultRepository sixthSemesterResultRepository;

@PostMapping("/SixthSemesterIndividualResult")
public String SixthSemesterIndividualResult(@RequestParam("StudentsID") Long fromStudentID, Model model,
		Principal principal, HttpSession session) {
	try {
		String s = principal.getName();
		Long studentIdfind = signuprepo.findStudentIdByUsername(s);

		if (fromStudentID.equals(studentIdfind)) {
			SixthSemesterResultEntity YourResult = sixthSemesterResultRepository.getStudentResult(fromStudentID);
			if(YourResult ==null) {
				session.setAttribute("message", new Message("Sorry ,Result not published", "alert-danger"));
			}
			model.addAttribute("YourResult", YourResult);

		}

		else {
			session.setAttribute("message", new Message("Sorry ,Provide your own ID", "alert-danger"));
		}

		return "students/StudentSearchResultSixth";

	} catch (Exception e) {
		e.printStackTrace();
		session.setAttribute("message", new Message("Oh! ,something went wrong!", "alert-danger"));
		return "students/StudentSearchResultSixth";
	}

}

//********************************Seventh semester Individual find result****************************************
@Autowired
SeventhSemesterResultRepository seventhSemesterResultRepository;

@PostMapping("/SeventhSemesterIndividualResult")
public String SeventhSemesterIndividualResult(@RequestParam("StudentsID") Long fromStudentID, Model model,
		Principal principal, HttpSession session) {
	try {
		String s = principal.getName();
		Long studentIdfind = signuprepo.findStudentIdByUsername(s);

		if (fromStudentID.equals(studentIdfind)) {
			SeventhSemesterResultEntity YourResult = seventhSemesterResultRepository.getStudentResult(fromStudentID);
			if(YourResult ==null) {
				session.setAttribute("message", new Message("Sorry ,Result not published", "alert-danger"));
			}
			model.addAttribute("YourResult", YourResult);

		}

		else {
			session.setAttribute("message", new Message("Sorry ,Provide your own ID", "alert-danger"));
		}

		return "students/StudentSearchResultSeven";

	} catch (Exception e) {
		e.printStackTrace();
		session.setAttribute("message", new Message("Oh! ,something went wrong!", "alert-danger"));
		return "students/StudentSearchResultSeven";
	}

}

//********************************Eighth semester Individual find result****************************************

@Autowired
EighthSemesterResultRepository eighthSemesterResultRepository;

@PostMapping("/EighthSemesterIndividualResult")
public String EighthSemesterIndividualResult(@RequestParam("StudentsID") Long fromStudentID, Model model,
		Principal principal, HttpSession session) {
	try {
		String s = principal.getName();
		Long studentIdfind = signuprepo.findStudentIdByUsername(s);

		if (fromStudentID.equals(studentIdfind)) {
			EighthSemesterResultEntity YourResult = eighthSemesterResultRepository.getStudentResult(fromStudentID);
			if(YourResult ==null) {
				session.setAttribute("message", new Message("Sorry ,Result not published", "alert-danger"));
			}
			model.addAttribute("YourResult", YourResult);

		}

		else {
			session.setAttribute("message", new Message("Sorry ,Provide your own ID", "alert-danger"));
		}

		return "students/StudentSearchResultEight";

	} catch (Exception e) {
		e.printStackTrace();
		session.setAttribute("message", new Message("Oh! ,something went wrong!", "alert-danger"));
		return "students/StudentSearchResultEight";
	}

}





}
