package com.anaco.springdemoannotations;

import java.io.File;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		try {
			
			var myObj = new File("C:/Users/42Codelab/Desktop/table.html");
			var myReader = new Scanner(myObj);
			var builder = new StringBuilder();
			
			while (myReader.hasNextLine()) {
				builder.append(myReader.nextLine());
			}
			myReader.close();
			return builder.toString();
		}catch(Exception e){
			
		}
		return null;
	}

}
