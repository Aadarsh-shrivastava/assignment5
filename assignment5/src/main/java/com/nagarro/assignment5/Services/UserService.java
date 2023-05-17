package com.nagarro.assignment5.Services;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import com.nagarro.assignment5.Entities.Author;

@Component
public class UserService {

	public Boolean validateUser(String name,String pass) {
		String jsonData="";
		try {
			URL url = new URL("http://localhost:9193/user/"+name);
			 System.out.println(url);
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			
			connection.setRequestMethod("GET");
			
			connection.connect();
			
			int responseCode=connection.getResponseCode();
			System.out.println(responseCode);
			
			if(responseCode!=200) {
				throw new RuntimeException("HttpResponseCode:"+ responseCode);
			}
			else {
				Scanner sc=new Scanner(url.openStream());
				while (sc.hasNext()) {
					jsonData+=sc.nextLine();
				}
				System.out.println("\nJSON Response in String format");
				System.out.println(jsonData);
				sc.close();
			}
			
			
			
			JSONParser parse=new JSONParser();
			
			JSONObject jsonObj=(JSONObject)parse.parse(jsonData);
				
			String password=(String) jsonObj.get("password");
				System.out.println(password+"=="+pass);
			
			if(password==null) {System.out.println("username not founde"); return false;}	
			if(password.equals(pass)) {
				System.out.println("checked passwords");
				return true;
			}
				
			
			connection.disconnect();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
		
		
	
}
