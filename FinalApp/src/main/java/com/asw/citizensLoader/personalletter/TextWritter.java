package com.asw.citizensLoader.personalletter;

import com.asw.citizensLoader.util.exception.CitizenException;



public interface TextWritter {
	
	void createDocument(String documentName, String content) throws CitizenException;

}
