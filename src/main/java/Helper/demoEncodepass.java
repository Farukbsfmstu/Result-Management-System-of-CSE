package Helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class demoEncodepass {
   public static void main(String[] args) {
	   System.out.println(new BCryptPasswordEncoder().encode("456"));
	   
   }
}
