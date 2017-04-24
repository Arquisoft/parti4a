package com.asw.participationSystem.services;

import com.asw.participationSystem.services.impl.AdminServiceImpl;
import com.asw.participationSystem.services.impl.CategoryServiceImpl;
import com.asw.participationSystem.services.impl.CitizenServiceImpl;
import com.asw.participationSystem.services.impl.CommentServiceImpl;
import com.asw.participationSystem.services.impl.SuggestionServiceImpl;
import com.asw.participationSystem.services.impl.SystemServicesImpl;


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
