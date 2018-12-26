package bitirme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
public class MainApplicationClass {

    public static void main (String[] args){
        SpringApplication.run(MainApplicationClass.class, args);
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
        return "error";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homepage() {
        return "home";
    }
}
