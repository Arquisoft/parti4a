package es.uniovi.asw.services;

import es.uniovi.asw.services.impl.AdminServiceImpl;
import es.uniovi.asw.services.impl.CategoryServiceImpl;
import es.uniovi.asw.services.impl.CitizenServiceImpl;
import es.uniovi.asw.services.impl.CommentServiceImpl;
import es.uniovi.asw.services.impl.SuggestionServiceImpl;
import es.uniovi.asw.services.impl.SystemServicesImpl;


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
