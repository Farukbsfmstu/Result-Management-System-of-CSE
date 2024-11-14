package Result_System.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Result_System.Entity.StudentFormFillupEntity;
import Result_System.Repository.StudentFormFillupRepository;

@Service
public class FormFillupStudentinfoService {
	@Autowired
	private StudentFormFillupRepository repo ;
	
	
	public void  addstudentinfo(StudentFormFillupEntity studentInfo ){
		studentInfo.setDate(LocalDate.now());
		repo.save(studentInfo) ;
	}
	
	public String genareteRandomNumber() {
		
		 LocalDateTime now = LocalDateTime.now();
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	     String timestamp = now.format(formatter);

	     // Generate random number 
	     Random random = new Random();
	     int randomNumber = 1 + random.nextInt(35); 
	     System.out.println("randomNumber ID: " + randomNumber);
	     // Combine timestamp and random number to create the unique ID
	     String uniqueId = timestamp + String.format("%06d", randomNumber);
	     
	     return uniqueId ;
	}

}
