package es.uniovi.asw.participationSystem.cucmber.steps;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import es.uniovi.asw.util.loggerAdmin.LoggerAdmin;
import es.uniovi.asw.util.loggerAdmin.SingletonLoggerAdmin;

@WebAppConfiguration
public class SuperSteps {
//	public CitizenService citizeServices = Services.getCitizenServices();
//	public AdminService adminServices = Services.getAdminServices();
//	public SystemServices systemSercices = Services.getSystemServices();
//	public CategoryService categoryService = Services.getCategoryService();
//	public CommentService commentService = Services.getCommentService();
//	public SuggestionService suggestionService = Services.getSuggestionService();
	
	protected ConfigurableApplicationContext appContext;
	protected LoggerAdmin loggerCutre = SingletonLoggerAdmin.getInstance().getLogger();
	protected boolean stepBien = true;
	
	protected static HtmlUnitDriver driver=new HtmlUnitDriver();
	protected  String baseUrl = "http://localhost:8080/";
	protected StringBuffer verificationErrors = new StringBuffer();
	
	@Autowired
	WebApplicationContext context;
	
//	
//	public CitizenService getCitizeServices() {
//		return citizeServices;
//	}
//	public AdminService getAdminServices() {
//		return adminServices;
//	}
//	public SystemServices getSystemSercices() {
//		return systemSercices;
//	}
//	public CategoryService getCategoryService() {
//		return categoryService;
//	}
//	public CommentService getCommentService() {
//		return commentService;
//	}
//	public SuggestionService getSuggestionService() {
//		return suggestionService;
//	}
	

	
}
