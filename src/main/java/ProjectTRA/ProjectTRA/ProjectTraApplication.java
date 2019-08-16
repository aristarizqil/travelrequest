package ProjectTRA.ProjectTRA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProjectTraApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectTraApplication.class, args);
//        
//        String pass="septi";
//        
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String chip = passwordEncoder.encode(pass);
//        
//        System.out.println("pass="+ chip);
        System.out.println("--RUN--");
    }

}
