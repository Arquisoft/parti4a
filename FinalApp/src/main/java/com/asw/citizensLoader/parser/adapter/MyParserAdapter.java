package com.asw.citizensLoader.parser.adapter;

import com.asw.citizensLoader.parser.differentParsers.MyParser;
import com.asw.citizensLoader.util.exception.CitizenException;



public class MyParserAdapter implements GeneralParser {


	@Override
	public void parse(String... args) throws CitizenException {
		/*
		 * Como utiliza los mismos comandos que el parser original, no hacen
		 * falta converisones. De momento
		 */
        MyParser parser;
		parser = new MyParser(args);
		parser.parse();
	}

}
