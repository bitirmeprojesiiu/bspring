package bitirme.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

@EnableWebMvc
@Configuration
@ComponentScan("bitirme")
public class DispatcherServletConfig {

	@Autowired
	WebApplicationContext	webApplicationContext;

	@Bean
	public SpringResourceTemplateResolver getTemplateResolver()
	{
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver(); 
		templateResolver.setApplicationContext(webApplicationContext);
		templateResolver.setOrder(9);
		templateResolver.setPrefix("/WEB-INF/jsp/");
		templateResolver.setSuffix(".jsp");
		return templateResolver;
	}
	
	@Bean
	public SpringTemplateEngine templateEngine()
	{
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(getTemplateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}
	
	@Bean
    InternalResourceViewResolver jspViewResolver() {
        final InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/WEB-INF/jsp/");
        vr.setSuffix(".jsp");
        vr.setViewClass(JstlView.class);
        vr.setViewNames("jsp/*");
        return vr;
    }
	
}
