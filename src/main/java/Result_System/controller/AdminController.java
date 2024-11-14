package Result_System.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.AbstractView;

import Helper.Message;
import Result_System.Entity.FirstSemesterEntity;
import Result_System.Entity.SingupEntityStudent;
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
import Result_System.Service.AdminService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private FirstSemesterRepository firstSemesterRepository ;
	
	@Autowired
	private AdminService adminservice ; 
	@Autowired
	private SignUpRepository signuprepo;
	
	 @Autowired
	    private StudentFormFillupRepository studentFormFillupRepository;
//************************See all account and delete,Edit section*****************************************
	 @GetMapping("/StudentAccount")
	public String StudentAccount(Model model) {
		 List<SingupEntityStudent> account = signuprepo.findAll();
	       model.addAttribute("accounts", account);
		 
		return "admins/studentAccountSee";
	}
	 
		@GetMapping("/DeleteStdAcc/{SID}")
		public String DeleteStdAcc(@PathVariable("SID") Long SID,Model model,HttpSession session) {

			Optional<SingupEntityStudent>  sid= signuprepo.findById(SID);
			System.out.println("Sid is"+sid);
			SingupEntityStudent DeleteSid = sid.get();
			signuprepo.delete(DeleteSid);
			 session.setAttribute("message", new Message("Student account deleted!","alert-danger"));
			return "redirect:/admin/StudentAccount";
		}
		
	String pass,role;
	Long ID;
	@GetMapping("/editAcc/{SID}")
	public String editAcc(@PathVariable("SID") Long SID,Model model,HttpSession session) {
		Optional<SingupEntityStudent>  sid= signuprepo.findById(SID);
		SingupEntityStudent Sid = sid.get();
		pass=Sid.getPassword();
		ID=Sid.getID();
		
		  model.addAttribute("accounts",Sid);
		return "admins/EditAccount";
	}
	
	@PostMapping("/UpdateAcc")
	public String UpdateAcc(SingupEntityStudent singupEntityStudent,Model model,HttpSession session) {
		if(pass.equals(singupEntityStudent.getPassword())) {
			ID=singupEntityStudent.getID();
			singupEntityStudent.setID(ID);
			signuprepo.save(singupEntityStudent);
			 session.setAttribute("message", new Message("Successfully Updated","alert-success"));
		}
		else {
			ID=singupEntityStudent.getID();
			singupEntityStudent.setID(ID);
			singupEntityStudent.setPassword(passwordEncoder.encode(singupEntityStudent.getPassword()));
			singupEntityStudent.setDate(LocalDate.now());
			signuprepo.save(singupEntityStudent);
			 session.setAttribute("message", new Message("Successfully Updated","alert-success"));
		}
		return "redirect:/admin/StudentAccount";
	}
	
//********************************************end***************************************************	
	@RequestMapping("/admindash")
	   public String admindash(){
		 
		return "admins/Admin_Dashboard";
	    }
	
	@RequestMapping("/comming")
	   public String comming(){
		 
		return "admins/commining";
	    }
	
	
	
	  @GetMapping("/semesteroption")
	   public String semesteroption(){
		   return "admins/semesteroption";
		
	    }
//********************************************Add First semester result*************************	  
	  @GetMapping("/demo")
	   public String demo(Model model){
		  List<String> sessions = studentFormFillupRepository.findDistinctSessions();
	       model.addAttribute("sessions", sessions);
		   return "admins/Demu";
		
	    }
	  
	  @PostMapping("/addresult")
	   public String addresult(Model model,@RequestParam("selectedSession") String selectedSession){
		 // List<String> sessions = studentFormFillupRepository.findDistinctSessions();
		  String sessions =selectedSession ;
		  List<String> studentIds = studentFormFillupRepository.findStudentIdsBySession(selectedSession);
	       model.addAttribute("sessions", sessions);
	       model.addAttribute("studentIds",studentIds);
	       System.out.println("I am session"+sessions);
	       
		return "admins/Add_result";
	    }
	  
	@GetMapping("/semesterResultOptionSee")
	public String semesterResultOptionSee() {
		return "admins/semesterResultOptionSee";
	}

	//**************************first semester delete with all result see***************************
	
	@GetMapping("/fisrstSemesterResultSee")
	public String fisrstSemesterResultSee(Model model) {
		 List<FirstSemesterEntity> result = firstSemesterRepository.findAll();
	       model.addAttribute("result", result);
		return "admins/FirstSemesterResultSee";
	}
	
	//Delete first semester individual student 
	
	@GetMapping("/deleteFirst/{SID}")
	public String deleteFirst(@PathVariable("SID") Long SID,Model model,HttpSession session) {
		System.out.println("Sid is"+SID);
		Optional<FirstSemesterEntity>  sid= firstSemesterRepository.findById(SID);
		System.out.println("Sid is"+sid);
		FirstSemesterEntity DeleteSid = sid.get();
		firstSemesterRepository.delete(DeleteSid);
		
		return "redirect:/admin/fisrstSemesterResultSee";
	}
	
//**************************second semester delete with all result see***************************
	 @Autowired
	  SecondSemesterResultRepository  secondSemesterResultRepository;
	@GetMapping("/secoundSemesterResultSee")
	public String secoundSemesterResultSee(Model model) {
		List<SecondSemesterResultEntity> result =secondSemesterResultRepository.findAll();
		  model.addAttribute("result", result);
		return "admins/SecondSemesterResultSee";
	}
	
	@GetMapping("/SecondDelete/{SID}")
	public String SecondDelete(@PathVariable("SID") Long SID,Model model,HttpSession session) {

		Optional<SecondSemesterResultEntity>  sid= secondSemesterResultRepository.findById(SID);
		System.out.println("Sid is"+sid);
		SecondSemesterResultEntity DeleteSid = sid.get();
		secondSemesterResultRepository.delete(DeleteSid);
		
		return "redirect:/admin/secoundSemesterResultSee";
	}
	
	
	//***************************Third semester delete with all result see***************************
	 @Autowired
	 ThirdSemesterResultRepository thirdSemesterResultRepository;
	 
	@GetMapping("/ThirdSemesterResultSee")
	public String ThirdSemesterResultSee(Model model) {
		List<ThirdSemesterResultEntity> result =thirdSemesterResultRepository.findAll();
		  model.addAttribute("result", result);
		return "admins/ThirdSemesterResultSee";
	}
	
	@GetMapping("/DeleteThird/{SID}")
	public String DeleteThird(@PathVariable("SID") Long SID,Model model,HttpSession session) {

		Optional<ThirdSemesterResultEntity>  sid= thirdSemesterResultRepository.findById(SID);
		System.out.println("Sid is"+sid);
		ThirdSemesterResultEntity DeleteSid = sid.get();
		thirdSemesterResultRepository.delete(DeleteSid);
		
		return "redirect:/admin/ThirdSemesterResultSee";
	}
	//***************************Fourth semester delete with all result see***************************
	@Autowired
	FourthSemesterResultRepository fourthSemesterResultRepository;
	
	@GetMapping("/FourthSemesterResultSee")
	public String FourthSemesterResultSee(Model model) {
		List<FourthSemesterResultEntity> result =fourthSemesterResultRepository.findAll();
		  model.addAttribute("result", result);
		return "admins/FourthSemesterResultSee";
	}
	
	@GetMapping("/DeleteFourth/{SID}")
	public String DeleteFourth(@PathVariable("SID") Long SID,Model model,HttpSession session) {

		Optional<FourthSemesterResultEntity>  sid= fourthSemesterResultRepository.findById(SID);
		System.out.println("Sid is"+sid);
		FourthSemesterResultEntity DeleteSid = sid.get();
		fourthSemesterResultRepository.delete(DeleteSid);
		
		return "redirect:/admin/FourthSemesterResultSee";
	}
	//***************************Five semester delete with all result see***************************
	
	@Autowired
	FivethSemesterResultRepository fivethSemesterResultRepository;
	
	@GetMapping("/FiveSemesterResultSee")
	public String FiveSemesterResultSee(Model model) {
		List<FiveSemesterResultEntity> result =fivethSemesterResultRepository.findAll();
		  model.addAttribute("result", result);
		return "admins/FivethSemesterResultSee";
	}
	
	@GetMapping("/DeleteFiveth/{SID}")
	public String DeleteFiveth(@PathVariable("SID") Long SID,Model model,HttpSession session) {

		Optional<FiveSemesterResultEntity>  sid= fivethSemesterResultRepository.findById(SID);
		System.out.println("Sid is"+sid);
		FiveSemesterResultEntity DeleteSid = sid.get();
		fivethSemesterResultRepository.delete(DeleteSid);
		
		return "redirect:/admin/FiveSemesterResultSee";
	}
	//***************************sixth semester delete with all result see***************************
	@Autowired
	SixthSemesterResultRepository sixthSemesterResultRepository;
	
	@GetMapping("/SixSemesterResultSee")
	public String SixSemesterResultSee(Model model) {
		List<SixthSemesterResultEntity> result =sixthSemesterResultRepository.findAll();
		  model.addAttribute("result", result);
		return "admins/SixthSemesterResultSee";
	}
	
	@GetMapping("/DeleteSixthth/{SID}")
	public String DeleteSixthth(@PathVariable("SID") Long SID,Model model,HttpSession session) {

		Optional<SixthSemesterResultEntity>  sid= sixthSemesterResultRepository.findById(SID);
		System.out.println("Sid is"+sid);
		SixthSemesterResultEntity DeleteSid = sid.get();
		sixthSemesterResultRepository.delete(DeleteSid);
		
		return "redirect:/admin/SixSemesterResultSee";
	}
	//***************************seventh semester delete with all result see***************************
	
	 @Autowired
	 SeventhSemesterResultRepository seventhSemesterResultRepository;
	@GetMapping("/SevenSemesterResultSee")
	public String SevenSemesterResultSee(Model model) {
		List<SeventhSemesterResultEntity> result =seventhSemesterResultRepository.findAll();
		  model.addAttribute("result", result);
		return "admins/SeventhSemesterResultSee";
	}
	
	@GetMapping("/DeleteSeventh/{SID}")
	public String DeleteSeventh(@PathVariable("SID") Long SID,Model model,HttpSession session) {

		Optional<SeventhSemesterResultEntity>  sid= seventhSemesterResultRepository.findById(SID);
		System.out.println("Sid is"+sid);
		SeventhSemesterResultEntity DeleteSid = sid.get();
		seventhSemesterResultRepository.delete(DeleteSid);
		
		return "redirect:/admin/SevenSemesterResultSee";
	}
	
	//***************************eight semester delete with all result see***************************
	@Autowired
	EighthSemesterResultRepository eighthSemesterResultRepository;
	
	@GetMapping("/EighthSemesterResultSee")
	public String EighthSemesterResultSee(Model model) {
		List<EighthSemesterResultEntity> result =eighthSemesterResultRepository.findAll();
		 model.addAttribute("result", result);
		return "admins/EightSemesterResultSee";
	}
	
	@GetMapping("/DeleteEighth/{SID}")
	public String DeleteEighth(@PathVariable("SID") Long SID,Model model,HttpSession session) {

		Optional<EighthSemesterResultEntity>  sid= eighthSemesterResultRepository.findById(SID);
		System.out.println("Sid is"+sid);
		EighthSemesterResultEntity DeleteSid = sid.get();
		eighthSemesterResultRepository.delete(DeleteSid);
		
		return "redirect:/admin/EighthSemesterResultSee";
	}
	
	  //Add a method to fetch student IDs based on session
//	  @PostMapping("/studentID")
//	  @ResponseBody
//	  public List<String> getStudentIds(@RequestParam("selectedSession") String selectedSession,Model model) {
//	      List<String> studentIds = studentFormFillupRepository.findStudentIdsBySession(selectedSession);
//	      model.addAttribute("StudentID",studentIds);
//	     System.out.println("Student IDs for session " + selectedSession + ": " + studentIds);
//	      
//	      return studentIds;
//	  }
	  
	  //******************************************All Semester result added here**************************
	  @PostMapping("/firstSemister")
	  public String firstSemister(FirstSemesterEntity firstSemesterEntity,Model model,HttpSession session) {
		 try {
			 System.out.println(firstSemesterEntity);
			 firstSemesterEntity.setDate(LocalDate.now());
			 String sessions =firstSemesterEntity.getSession() ;
			 adminservice.FirstSemester(firstSemesterEntity) ;
			  session.setAttribute("message", new Message("Successfully Submitted","alert-success"));
			 
			 
			  List<String> studentIds = studentFormFillupRepository.findStudentIdsBySession(sessions);
			  model.addAttribute("sessions", sessions);
			  model.addAttribute("studentIds",studentIds);
			  return "admins/Add_result" ;
		 }catch(Exception e) {
			 e.printStackTrace();
			 session.setAttribute("message", new Message("Something went wrong!"+e.getMessage(),"alert-danger"));
			 return "admins/Add_result" ;
		 }
		  
	  }
	  
//******************Add Second semester result section*****************************************************
	  @Autowired
	  private SecoundFormFillupRepository secoundFormFillupRepository;
	  
	  @GetMapping("/demoSecomd")
	   public String demoSecomd(Model model){
		  List<String> sessions = secoundFormFillupRepository.findDistinctSessions();
	       model.addAttribute("sessions", sessions);
		   return "admins/DemuSecound";
		
	    }
	  
	  @PostMapping("/addresultSecond")
	   public String addresultSecond(Model model,@RequestParam("selectedSession") String selectedSession){
		 // List<String> sessions = studentFormFillupRepository.findDistinctSessions();
		  String sessions =selectedSession ;
		  List<String> studentIds = secoundFormFillupRepository.findStudentIdsBySession(selectedSession);
	       model.addAttribute("sessions", sessions);
	       model.addAttribute("studentIds",studentIds);
	      
	       
		return "admins/Add_Result_Second";
	    }
	
	  
	  @PostMapping("/SecondSemisterResultData")
	  public String SecondSemisterResultData(SecondSemesterResultEntity secondSemesterResultEntity,Model model,HttpSession session) {
		 try {
			 System.out.println(secondSemesterResultEntity);
			 secondSemesterResultEntity.setDate(LocalDate.now());
			 String sessions =secondSemesterResultEntity.getSession() ;
			 adminservice.SecondSemesterResult(secondSemesterResultEntity) ;
			  session.setAttribute("message", new Message("Successfully Submitted","alert-success"));
			 
			 
			  List<String> studentIds = secoundFormFillupRepository.findStudentIdsBySession(sessions);
			  model.addAttribute("sessions", sessions);
			  model.addAttribute("studentIds",studentIds);
			  return "admins/Add_Result_Second" ;
		 }catch(Exception e) {
			 e.printStackTrace();
			 session.setAttribute("message", new Message("Something went wrong!"+e.getMessage(),"alert-danger"));
			 return "admins/Add_Result_Second" ;
		 }
		  
	  }

//*****************************Third Semester add result section**********************************************
	  @Autowired
	  private ThirdFormFillupRepository thirdFormFillupRepository;
	  
	  @GetMapping("/demoThird")
	   public String demoThird(Model model){
		  List<String> sessions = thirdFormFillupRepository.findDistinctSessions();
	       model.addAttribute("sessions", sessions);
		   return "admins/DemuThird";
		
	    }
	  
	  @PostMapping("/addresultThird")
	   public String addresultThird(Model model,@RequestParam("selectedSession") String selectedSession){
		 // List<String> sessions = studentFormFillupRepository.findDistinctSessions();
		  String sessions =selectedSession ;
		  List<String> studentIds = thirdFormFillupRepository.findStudentIdsBySession(selectedSession);
	       model.addAttribute("sessions", sessions);
	       model.addAttribute("studentIds",studentIds);
	      
	       
		return "admins/Add_Result_Third";
	    }
	  
	  
	  @PostMapping("/ThirdSemesterResultData")
	  public String ThirdSemesterResultData(ThirdSemesterResultEntity thirdSemesterResultEntity,Model model,HttpSession session) {
		 try {
			 System.out.println(thirdSemesterResultEntity);
			 thirdSemesterResultEntity.setDate(LocalDate.now());
			 String sessions =thirdSemesterResultEntity.getSession() ;
			 adminservice.ThirdSemesterResult(thirdSemesterResultEntity) ;
			  session.setAttribute("message", new Message("Successfully Submitted","alert-success"));
			 
			 
			  List<String> studentIds = thirdFormFillupRepository.findStudentIdsBySession(sessions);
			  model.addAttribute("sessions", sessions);
			  model.addAttribute("studentIds",studentIds);
			  return "admins/Add_Result_Third";
		 }catch(Exception e) {
			 e.printStackTrace();
			 session.setAttribute("message", new Message("Something went wrong!"+e.getMessage(),"alert-danger"));
			 return "admins/Add_Result_Third";
		 }
		  
	  }  
	  
//****************************Fourth Semester result section************************************
	  @Autowired
     private FourthFormFillupRepository fourthFormFillupRepository;
	  
	  @GetMapping("/demoFourth")
	   public String demoFourth(Model model){
		  List<String> sessions = fourthFormFillupRepository.findDistinctSessions();
	       model.addAttribute("sessions", sessions);
		   return "admins/DemuFourth";
		
	    }
	  
	  @PostMapping("/addresultFourth")
	   public String addresultFourth(Model model,@RequestParam("selectedSession") String selectedSession){
		 // List<String> sessions = studentFormFillupRepository.findDistinctSessions();
		  String sessions =selectedSession ;
		  List<String> studentIds = fourthFormFillupRepository.findStudentIdsBySession(selectedSession);
	       model.addAttribute("sessions", sessions);
	       model.addAttribute("studentIds",studentIds);
	      
	       
		return "admins/Add_Result_Fourth";
	    }
	  
	  
	  @PostMapping("/FourthSemisterResultData")
	  public String FourthSemisterResultData(FourthSemesterResultEntity fourthSemesterResultEntity,Model model,HttpSession session) {
		 try {
			 System.out.println(fourthSemesterResultEntity);
			 fourthSemesterResultEntity.setDate(LocalDate.now());
			 String sessions =fourthSemesterResultEntity.getSession() ;
			 adminservice.FourthSemesterResult(fourthSemesterResultEntity) ;
			  session.setAttribute("message", new Message("Successfully Submitted","alert-success"));
			 
			 
			  List<String> studentIds = fourthFormFillupRepository.findStudentIdsBySession(sessions);
			  model.addAttribute("sessions", sessions);
			  model.addAttribute("studentIds",studentIds);
			  return "admins/Add_Result_Fourth";
		 }catch(Exception e) {
			 e.printStackTrace();
			 session.setAttribute("message", new Message("Something went wrong!"+e.getMessage(),"alert-danger"));
			 return "admins/Add_Result_Fourth";
		 }
		  
	  }  
	  
	  
	//****************************** Five semester result section******************************************
	  @Autowired
	  private FiveFormFillupRepository fiveFormFillupRepository;
	  
	  @GetMapping("/demoFive")
	   public String demoFive(Model model){
		  List<String> sessions = fiveFormFillupRepository.findDistinctSessions();
	       model.addAttribute("sessions", sessions);
		   return "admins/DemuFive";
		
	    }
	  
	  @PostMapping("/addresultFive")
	   public String addresultFive(Model model,@RequestParam("selectedSession") String selectedSession){
		 // List<String> sessions = studentFormFillupRepository.findDistinctSessions();
		  String sessions =selectedSession ;
		  List<String> studentIds = fiveFormFillupRepository.findStudentIdsBySession(selectedSession);
	       model.addAttribute("sessions", sessions);
	       model.addAttribute("studentIds",studentIds);
	      
	       
		return "admins/Add_Result_Five";
	    }
	  
	  
	  @PostMapping("/FiveSemisterResultData")
	  public String FiveSemisterResultData(FiveSemesterResultEntity fiveSemesterResultEntity,Model model,HttpSession session) {
		 try {
			 System.out.println(fiveSemesterResultEntity);
			 fiveSemesterResultEntity.setDate(LocalDate.now());
			 String sessions =fiveSemesterResultEntity.getSession() ;
			 adminservice.FivethSemesterResult(fiveSemesterResultEntity) ;
			  session.setAttribute("message", new Message("Successfully Submitted","alert-success"));
			 
			 
			  List<String> studentIds = fiveFormFillupRepository.findStudentIdsBySession(sessions);
			  model.addAttribute("sessions", sessions);
			  model.addAttribute("studentIds",studentIds);
			  return "admins/Add_Result_Five";
		 }catch(Exception e) {
			 e.printStackTrace();
			 session.setAttribute("message", new Message("Something went wrong!"+e.getMessage(),"alert-danger"));
			 return "admins/Add_Result_Five";
		 }
	  
	  }
	  
	//*********************************** Six semester result section***********************************
	 @Autowired 
	 private SixFormFillupRepository sixFormFillupRepository;
	  
	  @GetMapping("/demoSix")
	   public String demoSix(Model model){
		  List<String> sessions = sixFormFillupRepository.findDistinctSessions();
	       model.addAttribute("sessions", sessions);
		   return "admins/DemuSix";
		
	    }
	  
	  @PostMapping("/addresultSix")
	   public String addresultSix(Model model,@RequestParam("selectedSession") String selectedSession){
		 // List<String> sessions = studentFormFillupRepository.findDistinctSessions();
		  String sessions =selectedSession ;
		  List<String> studentIds = sixFormFillupRepository.findStudentIdsBySession(selectedSession);
	       model.addAttribute("sessions", sessions);
	       model.addAttribute("studentIds",studentIds);
	      
	       
		return "admins/Add_Result_Six";
	    }
	  
	  
	  
	  @PostMapping("/SixthSemisterResultData")
	  public String SixthSemisterResultData(SixthSemesterResultEntity sixthSemesterResultEntity,Model model,HttpSession session) {
		 try {
			 System.out.println(sixthSemesterResultEntity);
			 sixthSemesterResultEntity.setDate(LocalDate.now());
			 String sessions =sixthSemesterResultEntity.getSession() ;
			 adminservice.SixthSemesterResult(sixthSemesterResultEntity) ;
			  session.setAttribute("message", new Message("Successfully Submitted","alert-success"));
			 
			 
			  List<String> studentIds = sixFormFillupRepository.findStudentIdsBySession(sessions);
			  model.addAttribute("sessions", sessions);
			  model.addAttribute("studentIds",studentIds);
			  return "admins/Add_Result_Six";
		 }catch(Exception e) {
			 e.printStackTrace();
			 session.setAttribute("message", new Message("Something went wrong!"+e.getMessage(),"alert-danger"));
			 return "admins/Add_Result_Six";
		 }
	  
	  }
	  
	//*********************************** Seven semester result section****************************************
	  @Autowired
      private SevenFormFillupRepository sevenFormFillupRepository;
	  
	  @GetMapping("/demoSeven")
	   public String demoSeven(Model model){
		  List<String> sessions = sevenFormFillupRepository.findDistinctSessions();
	       model.addAttribute("sessions", sessions);
		   return "admins/DemuSeven";
		
	    }
	  
	  @PostMapping("/addresultSeven")
	   public String addresultSeven(Model model,@RequestParam("selectedSession") String selectedSession){
		 // List<String> sessions = studentFormFillupRepository.findDistinctSessions();
		  String sessions =selectedSession ;
		  List<String> studentIds = sevenFormFillupRepository.findStudentIdsBySession(selectedSession);
	       model.addAttribute("sessions", sessions);
	       model.addAttribute("studentIds",studentIds);
	      
	       
		return "admins/Add_Result_Seven";
	    }  
	  
	  @PostMapping("/SeventhSemisterResultData")
	  public String SeventhSemisterResultData(SeventhSemesterResultEntity seventhSemesterResultEntity,Model model,HttpSession session) {
		 try {
			 System.out.println(seventhSemesterResultEntity);
			 seventhSemesterResultEntity.setDate(LocalDate.now());
			 String sessions =seventhSemesterResultEntity.getSession() ;
			 adminservice.SeventhSemesterResult(seventhSemesterResultEntity) ;
			  session.setAttribute("message", new Message("Successfully Submitted","alert-success"));
			 
			 
			  List<String> studentIds = sevenFormFillupRepository.findStudentIdsBySession(sessions);
			  model.addAttribute("sessions", sessions);
			  model.addAttribute("studentIds",studentIds);
			  return "admins/Add_Result_Seven";
		 }catch(Exception e) {
			 e.printStackTrace();
			 session.setAttribute("message", new Message("Something went wrong!"+e.getMessage(),"alert-danger"));
			 return "admins/Add_Result_Seven";
		 }
	  
	  }
	  
//*******************************Eight semester result section*******************************************
	  @Autowired
	  private EightFormFillupRepository eightFormFillupRepository;
	  
	  @GetMapping("/demoEight")
	   public String demoEight(Model model){
		  List<String> sessions = eightFormFillupRepository.findDistinctSessions();
	       model.addAttribute("sessions", sessions);
		   return "admins/DemuEight";
		
	    }
	  
	  @PostMapping("/addresultEight")
	   public String addresultEight(Model model,@RequestParam("selectedSession") String selectedSession){
		 // List<String> sessions = studentFormFillupRepository.findDistinctSessions();
		  String sessions =selectedSession ;
		  List<String> studentIds = eightFormFillupRepository.findStudentIdsBySession(selectedSession);
	       model.addAttribute("sessions", sessions);
	       model.addAttribute("studentIds",studentIds);
	      
	       
		return "admins/Add_Result_Eight";
	    }
	  
	  
	  @PostMapping("/EightSemisterResultData")
	  public String EightSemisterResultData(EighthSemesterResultEntity eighthSemesterResultEntity,Model model,HttpSession session) {
		 try {
			 System.out.println(eighthSemesterResultEntity);
			 eighthSemesterResultEntity.setDate(LocalDate.now());
			 String sessions =eighthSemesterResultEntity.getSession() ;
			 adminservice.EighthSemesterResult(eighthSemesterResultEntity) ;
			  session.setAttribute("message", new Message("Successfully Submitted","alert-success"));
			 
			 
			  List<String> studentIds = eightFormFillupRepository.findStudentIdsBySession(sessions);
			  model.addAttribute("sessions", sessions);
			  model.addAttribute("studentIds",studentIds);
				return "admins/Add_Result_Eight";
		 }catch(Exception e) {
			 e.printStackTrace();
			 session.setAttribute("message", new Message("Something went wrong!"+e.getMessage(),"alert-danger"));
				return "admins/Add_Result_Eight";
		 }
	  
	  }  
//***************************************PDF Genaretor section***************************************************
	  
	  
@GetMapping("/ViewPDF")
public String ViewPDF() {
	return "admins/PDFOption";
}

@GetMapping("/PDFDemo1")
public String PDFDemo1(Model model) {
	 List<String> sessions = firstSemesterRepository.findDistinctSessions();
     model.addAttribute("sessions", sessions);
	return "admins/PdfDemoOne";
}


@PostMapping("/generatePDF")
public ModelAndView generatePDF(String selectedSession) throws IOException {
    List<FirstSemesterEntity> results = firstSemesterRepository.findAllBySession(selectedSession);
    System.out.println("my result is: "+results);
    System.out.println("my SESSION  is: "+selectedSession);
    
    float widthInCm =29.7f ; // A4 width is 21.0 cm
    float heightInCm =21.0f; // A4 height is 29.7 cm

    // Convert centimeters to points (1 cm = 28.35 points)
    
    float width = widthInCm* 28.35f; // Width in points (1 inch = 72 points)
    float height = heightInCm* 28.35f; // Height in points (1 inch = 72 points)

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    try (PDDocument document = new PDDocument()) {
    	 PDPage page = new PDPage(new PDRectangle(width, height));
        document.addPage(page);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
        	float margin = 30; // Left margin
        	float yPosition = height - margin; // Starting Y position (top of the page)

        	// Set the font outside the loop since it remains constant
        	contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);

        	// Begin text
        	contentStream.beginText();

        	// Set the text position for the Department line
        	contentStream.newLineAtOffset(260, yPosition);
        	contentStream.showText("Department of Computer Science and Engineering");
        	contentStream.endText();

        	contentStream.beginText();
        	// Adjust Y position for the next line
        	yPosition -= 20;
        	contentStream.endText();
        	
        	
        	contentStream.beginText();
        	// Set the text position for the First Year line
        	contentStream.newLineAtOffset(320, yPosition);
        	contentStream.showText("First Year First Semester Result");
         	// End text
        	contentStream.endText();
        	
           	contentStream.beginText();
        	// Adjust Y position for the next line
        	yPosition -= 20;
        	contentStream.endText();
// pdf fond size here*****************************************************
            contentStream.setFont(PDType1Font.HELVETICA, 11);
            contentStream.beginText();
            contentStream.newLineAtOffset(700, 100);
            contentStream.endText();
            
           

            // Set the font outside the loop since it remains constant
            contentStream.setFont(PDType1Font.HELVETICA, 10);
            
            contentStream.beginText();
            contentStream.newLineAtOffset(margin+10, yPosition);
            contentStream.showText("ID ");
            contentStream.endText();
            
            // Print Session
            contentStream.beginText();
            contentStream.newLineAtOffset(margin + 59, yPosition);
            contentStream.showText("Session ");
            contentStream.endText();
            
            // Print Name
            contentStream.beginText();
            contentStream.newLineAtOffset(margin + 130, yPosition);
            contentStream.showText("Name " );
            contentStream.endText();
            
            // Print other attributes similarly
            // Adjust the margin accordingly for each attribute

            // Print ENG1111
            contentStream.beginText();
            contentStream.newLineAtOffset(margin + 180, yPosition);
            contentStream.showText("ENG1111 " );
            contentStream.endText();

            // Print ENG1112
            contentStream.beginText();
            contentStream.newLineAtOffset(margin + 240, yPosition);
            contentStream.showText("ENG1112 " );
            contentStream.endText();
            
            // Print MATH1111
            contentStream.beginText();
            contentStream.newLineAtOffset(margin + 300, yPosition);
            contentStream.showText("MATH1111 ");
            contentStream.endText();
            
            // Print PHY1111
            contentStream.beginText();
            contentStream.newLineAtOffset(margin + 360, yPosition);
            contentStream.showText("PHY1111 " );
            contentStream.endText();
            
            // Print PHY1112
            contentStream.beginText();
            contentStream.newLineAtOffset(margin + 420, yPosition);
            contentStream.showText("PHY1112 " );
            contentStream.endText();
            
            // Print CSE1111
            contentStream.beginText();
            contentStream.newLineAtOffset(margin + 470, yPosition);
            contentStream.showText("CSE1111 " );
            contentStream.endText();
            
            // Print CSE1112
            contentStream.beginText();
            contentStream.newLineAtOffset(margin + 525, yPosition);
            contentStream.showText("CSE1112 " );
            contentStream.endText();
            
            // Print CSE1121
            contentStream.beginText();
            contentStream.newLineAtOffset(margin + 580, yPosition);
            contentStream.showText("CSE1121" );
            contentStream.endText();
            
            // Print CSE1122
            contentStream.beginText();
            contentStream.newLineAtOffset(margin + 630, yPosition);
            contentStream.showText("CSE1122 " );
            contentStream.endText();
            
            // Print Year
            contentStream.beginText();
            contentStream.newLineAtOffset(margin + 690, yPosition);
            contentStream.showText("Year " );
            contentStream.endText();
            
            // Print CGPA
            contentStream.beginText();
            contentStream.newLineAtOffset(margin + 730, yPosition);
            contentStream.showText("CGPA ");
            contentStream.endText();
            
        	contentStream.beginText();
        	// Adjust Y position for the next line
        	yPosition -= 20;
        	contentStream.endText();

            for (FirstSemesterEntity result : results) {
                // Print ID
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText(""+ result.getID());
                contentStream.endText();
                
                // Print Session
                contentStream.beginText();
                contentStream.newLineAtOffset(margin + 55, yPosition);
                contentStream.showText("" + result.getSession());
                contentStream.endText();
                
                // Print Name
                contentStream.beginText();
                contentStream.newLineAtOffset(margin + 116, yPosition);
                contentStream.showText("" + result.getName());
                contentStream.endText();
                
                // Print other attributes similarly
                // Adjust the margin accordingly for each attribute

                // Print ENG1111
                contentStream.beginText();
                contentStream.newLineAtOffset(margin + 185, yPosition);
                contentStream.showText("" + result.getENG1111());
                contentStream.endText();

                // Print ENG1112
                contentStream.beginText();
                contentStream.newLineAtOffset(margin + 240, yPosition);
                contentStream.showText("" + result.getENG1112());
                contentStream.endText();
                
                // Print MATH1111
                contentStream.beginText();
                contentStream.newLineAtOffset(margin + 300, yPosition);
                contentStream.showText("" + result.getMATH1111());
                contentStream.endText();
                
                // Print PHY1111
                contentStream.beginText();
                contentStream.newLineAtOffset(margin + 360, yPosition);
                contentStream.showText("" + result.getPHY1111());
                contentStream.endText();
                
                // Print PHY1112
                contentStream.beginText();
                contentStream.newLineAtOffset(margin + 420, yPosition);
                contentStream.showText("" + result.getPHY1112());
                contentStream.endText();
                
                // Print CSE1111
                contentStream.beginText();
                contentStream.newLineAtOffset(margin + 470, yPosition);
                contentStream.showText("" + result.getCSE1111());
                contentStream.endText();
                
                // Print CSE1112
                contentStream.beginText();
                contentStream.newLineAtOffset(margin + 525, yPosition);
                contentStream.showText("" + result.getCSE1112());
                contentStream.endText();
                
                // Print CSE1121
                contentStream.beginText();
                contentStream.newLineAtOffset(margin + 580, yPosition);
                contentStream.showText("" + result.getCSE1121());
                contentStream.endText();
                
                // Print CSE1122
                contentStream.beginText();
                contentStream.newLineAtOffset(margin + 630, yPosition);
                contentStream.showText("" + result.getCSE1122());
                contentStream.endText();
                
                // Print Year
                contentStream.beginText();
                contentStream.newLineAtOffset(margin + 690, yPosition);
                contentStream.showText("" + result.getYear());
                contentStream.endText();
                
                // Print CGPA
                contentStream.beginText();
                contentStream.newLineAtOffset(margin + 730, yPosition);
                contentStream.showText("" + result.getCGPA());
                contentStream.endText();

                // Move to the next row
                yPosition -= 20;

                // Add a new line after each set of attributes
                contentStream.beginText();
                contentStream.newLine();
                contentStream.endText();
            }

           
        }

        document.save(outputStream);
    }

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setView(new PDFView());
    modelAndView.addObject("content", outputStream.toByteArray());
    return modelAndView;
}

public class PDFView extends AbstractView {

    @Override
    protected void renderMergedOutputModel(
            java.util.Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        response.setContentType("application/pdf");
        byte[] content = (byte[]) model.get("content");

        response.setHeader("Content-Disposition", "attachment; filename=result.pdf");

        try (ServletOutputStream out = response.getOutputStream()) {
            out.write(content);
            out.flush();
        }
    }
}

	  
	  
}
