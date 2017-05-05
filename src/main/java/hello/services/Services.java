package hello.services;

import hello.services.impl.AdminServiceImpl;
import hello.services.impl.CategoryServiceImpl;
import hello.services.impl.CitizenServiceImpl;
import hello.services.impl.CommentServiceImpl;
import hello.services.impl.SuggestionServiceImpl;
import hello.services.impl.SystemServicesImpl;


//SOBRA
public class Services {

	public static CitizenService getCitizenServices() {
		return new CitizenServiceImpl();
	}

	public static AdminService getAdminServices() {
		return new AdminServiceImpl();
	}

	public static SystemServices getSystemServices() {
		return new SystemServicesImpl();
	}
	
	public static CategoryService getCategoryService(){
		return new CategoryServiceImpl();
	}
	
	public static CommentService getCommentService(){
		return new CommentServiceImpl();
	}
	
	public static SuggestionService getSuggestionService(){
		return new SuggestionServiceImpl();
	}
	
	
}
