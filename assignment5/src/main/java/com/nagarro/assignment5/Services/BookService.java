package com.nagarro.assignment5.Services;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.nagarro.assignment5.Entities.Book;

public class BookService {
	
	String jsonData="";
	public List<Book> getAllBooks(){
		try {
			URL url = new URL("http://localhost:9193/book");
			 
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
			
			List<Book> allBooks=new LinkedList<Book>();
			
			for(int i=0;i<jsonarr.size();i++) {
				JSONObject jsonObj=(JSONObject)jsonarr.get(i);
				
				Long code = (Long) jsonObj.get("bookCode");
				String bookname = (String) jsonObj.get("bookName");
				String author = (String) jsonObj.get("author");
				String addedon = (String) jsonObj.get("addedOn");
				
				Book book = new Book();
				int bookcode = code.intValue();
				book.setAddedOn(addedon);
				book.setAuthor(author);
				book.setBookCode(bookcode);
				book.setBookName(bookname);
				
				allBooks.add(book);
			}
			
			System.out.println(allBooks);
			return allBooks;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public void deleteBook(int bookcode) {
		String jsonData="";
		
		try {
			URL url = new URL("http://localhost:9193/book/" +bookcode);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("DELETE");
		
			conn.connect();
			
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " + responsecode);

			if (responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			
		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	
	public void saveBook(Book book,String method) {

		
		String json = "{\"bookCode\":"+book.getBookCode()+",\"bookName\":\""+book.getBookName()+"\",\"author\":\""+book.getAuthor()+"\",\"addedOn\":\""+book.getAddedOn()+"\"}";
		try {
		URL url = new URL("http://localhost:9193/book");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod(method);
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		byte[] out = json.getBytes(StandardCharsets.UTF_8);



		OutputStream stream = http.getOutputStream();
		stream.write(out);



		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect();
		System.out.println("Created JASON:"+json);
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}


		}
	
}
