package com.nagarro.assignment5.Services;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.nagarro.assignment5.Entities.Author;

public class AuthorService {
	public List<Author> getAllAuthors(){
		String jsonData="";
		try {
			URL url = new URL("http://localhost:9193/author");
			 
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
//				System.out.println(jsonData);
				sc.close();
			}
			
			
			
			JSONParser parse=new JSONParser();
			
			JSONArray jsonarr=(JSONArray)parse.parse(jsonData);
			
			List<Author> allAuthors=new LinkedList<Author>();
			
			for(int i=0;i<jsonarr.size();i++) {
				JSONObject jsonObj=(JSONObject)jsonarr.get(i);
				
			
				String Authorname = (String) jsonObj.get("name");
			
				
				Author Author = new Author();
				
				Author.setName(Authorname);
				
				allAuthors.add(Author);
			}
			
			System.out.println(allAuthors);
			return allAuthors;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

}
