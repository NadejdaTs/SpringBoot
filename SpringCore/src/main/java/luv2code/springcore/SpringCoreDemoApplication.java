package luv2code.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {"luv2code.util",
//                                            "springcore"})
@SpringBootApplication
public class SpringCoreDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCoreDemoApplication.class, args);
    }
}
