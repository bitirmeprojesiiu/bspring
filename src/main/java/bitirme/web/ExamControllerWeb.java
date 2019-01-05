package bitirme.web;

import bitirme.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import bitirme.model.ClassicExam;
import bitirme.service.ExamServiceWeb;

//import com
//import com.bitirme.service.BitirmeService;

@Controller
public class ExamControllerWeb {

	
	@SpringBootApplication
	public class AppConfig {

	    @Value("${spring.mvc.view.prefix}")
	    private String prefix = "/WEB-INF/jsp/";

	    @Value("${spring.mvc.view.suffix}")
	    private String suffix = ".jsp";

	    /*@Value("${spring.view.view-names}")
	    private String viewNames = "jsp/*";*/

	    /*@Bean
	    InternalResourceViewResolver jspViewResolver() {
	        final InternalResourceViewResolver vr = new InternalResourceViewResolver();
	        vr.setPrefix(prefix);
	        vr.setSuffix(suffix);
	        vr.setViewClass(JstlView.class);
	        vr.setViewNames("jsp/*");
	        return vr;
	    }*/
	}
	
	@Autowired
	private ExamServiceWeb examServiceWeb;

	private int flag = 0;

	@RequestMapping("/")
	public String login() {
		flag = 1;
		return "login";
	}

	@RequestMapping("/home")
	public String home() {

		if(flag == 1)
			return "home";
		else
			return "login";
	}

	@RequestMapping("/exams")
	public String exams(Model model) {
		//System.out.println("controller");
		//System.out.println();
        model.addAttribute("exam", examServiceWeb.findAll());
        return "exams";
	}

	@RequestMapping("/candidates")
	public String candidates() {
		return "candidates";
	}

	/*@RequestMapping("/addexam")
	public String addExm() {
		return "addexam";
	}*/

	@RequestMapping("/results")
	public String results() {
		return "results";
	}



	@RequestMapping(value="/exams/new",method=RequestMethod.GET)
	public String newExam() {
		return "addexam";
	}

	@ModelAttribute
	public ClassicExam initModel() {
		return new ClassicExam();
	}
	
	@RequestMapping(value="/exams/new",method=RequestMethod.POST)
	public String handleFormSubmit(@ModelAttribute ClassicExam exam) {
		examServiceWeb.createExam(exam);
		return "redirect:/exams";
	}

	@RequestMapping(value="/candidates/new",method=RequestMethod.GET)
	public String newCandidate() {
		return "addcandidate";
	}

	@ModelAttribute
	public User initUserModel() {
		return new User();
	}

	@RequestMapping(value="/candidates/new",method=RequestMethod.POST)
	public String handleFormSubmit(@ModelAttribute User user) {
		examServiceWeb.createUser(user);
		return "redirect:/candidates";
	}
}
