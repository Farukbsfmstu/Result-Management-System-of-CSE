package Result_System.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import Helper.Message;
import Result_System.Entity.myAdmin;
import Result_System.Repository.SignUpRepository;
import Result_System.Entity.StudentFormFillupEntity;
import Result_System.Entity.EightFormFillupEntity;
import Result_System.Entity.SingupEntityStudent;
import Result_System.Service.FormFillupStudentinfoService;
import Result_System.Service.AdminService;
import jakarta.mail.internet.MimeMessage;
import jakarta.persistence.PrePersist;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class controller {
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private AdminService service ;

	
	@Autowired
	private SignUpRepository signuprepo ;
	
   @RequestMapping("/home")
   public String home(){
	return "Home";
    }
	
   @RequestMapping("/login")
   public String St_login(){
	return "Student_Login";
    }
   
   @GetMapping("/studentSignUP")
   public String studentSignUP() {
	   return "StudentSignup";
   }
   
   @GetMapping("/admin")
   public String admin(){
	return "admins/Admin";
    }
 
   


   
   @PostMapping("/studentSignup")
   public String studentprofile(@Valid @ModelAttribute("signupinfo") SingupEntityStudent signupinfo , BindingResult result ,Model model,HttpSession session ) {
	   
	   try {
		    String userbyid =signupinfo.getUsername();
		   
		   if(!(signupinfo.getID().equals(signuprepo.findStudentIdByUsername(userbyid)))) {
			   signupinfo.setRole("ROLE_STUDENT");
			   signupinfo.setPassword(passwordEncoder.encode(signupinfo.getPassword()));
			   signupinfo.setDate(LocalDate.now());
			 
			   SingupEntityStudent signdata=  signuprepo.save(signupinfo);
			   
			   model.addAttribute("student",new SingupEntityStudent() ) ;
			   
			    String mailTo=signupinfo.getUsername();
			     sendEmail(signupinfo,mailTo);
			   session.setAttribute("message", new Message("Successfully Registered \n ","alert-success"));
			  

			   return "StudentSignup";
		   }
		   
		   else {
			   session.setAttribute("message", new Message("Already Registered \n ","alert-danger"));
				  

			   return "StudentSignup";
		   }
		   
		  
		
	   }catch(Exception e) {
		   e.printStackTrace();
		   model.addAttribute("student",signupinfo);
		   session.setAttribute("message", new Message("Something went wrong!"+e.getMessage(),"alert-danger"));
		  
		   return "StudentSignup";
	   }

	   	   
	 
   }


   //*************sent mail************
   private void sendEmail(SingupEntityStudent signupinfo, String mail) {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		try {

			helper.setTo(mail);
			helper.setSubject("Registration Successful");
			helper.setText("Congratulations! Your signup was successful. Welcome to our community!.\n" 
					
					+ "\n Dept. of CSE \n BSFMSTU");
			emailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  

}
