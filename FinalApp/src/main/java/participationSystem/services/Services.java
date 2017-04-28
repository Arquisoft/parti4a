package participationSystem.services;

import participationSystem.services.impl.AdminServiceImpl;
import participationSystem.services.impl.CategoryServiceImpl;
import participationSystem.services.impl.CitizenServiceImpl;
import participationSystem.services.impl.CommentServiceImpl;
import participationSystem.services.impl.SuggestionServiceImpl;
import participationSystem.services.impl.SystemServicesImpl;


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
