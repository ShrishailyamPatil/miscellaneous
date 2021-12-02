package com.Test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class movie {
	
	 
	

	public static void main(String args[]){
	    try{
	         //Connect to the SQL database  
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies","root","");
	         Statement s = con.createStatement() ;
	         
	         
	        
	         
	         
	       //Create a table name 'movies'
	        s.execute(" CREATE TABLE `movies` (   `movie_name` varchar(60) COLLATE utf8mb4_unicode_520_ci NOT NULL,  `actor` varchar(60) COLLATE utf8mb4_unicode_520_ci ,`actress` varchar(60) COLLATE utf8mb4_unicode_520_ci ,`year` bigint(10) NOT NULL,`director_name` varchar(60) COLLATE utf8mb4_unicode_520_ci NOT NULL) ");
	         
	       // Insert data in table
	         s.executeUpdate("INSERT INTO movies (movie_name,actor,actress,year, director_name)VALUES(Vertigo, James Stewart , Miss Giddens,1958, Alfred Hitchcock),(The Innocents, John Scottie Ferguson,Deborah Kerr,1961, Jack Clayton),  (Lawrence of Arabia ,Peter OToole,T.E. Lawrence,1962 , David Lean),(The Deer Hunter,Robert De Niro,Alice Harford,1978 , Michael Cimino),(Amadeus ,Eddie Adams,Rose DeWitt Bukater ,1984  ,Milos Forman),(Blade Runner , Harrison Ford, Sean Maguire,1982, Ridley Scott), (Eyes Wide Shut,Eddie Adams,Nicole Kidman ,1999 , Stanley Kubrick),(The Usual Suspects ,Stephen Baldwin, Alvy Singer,1995 , Bryan Singer),(Chinatown, Jack Nicholson , Elizabeth Darko,1974 , Roman Polanski),(Boogie Nights,Mark Wahlberg , Claire Danes,1997, Paul Thomas Anderson)");
	 
	    	
			// Query to show all the rows in movies table
	    		 
	         ResultSet rs = s.executeQuery("SELECT * FROM movies");
	          while(rs.next()) {
	             System.out.println(rs.getString(1)+ "  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
	           }   
	      
	        // Query to show only movies name with specific actor  
	          
	          rs = s.executeQuery("SELECT movie_name, actor FROM movies WHERE actor = 'Eddie Adams'");
	          while(rs.next()) {
	             System.out.println(rs.getString(1)+ "  "+rs.getString(2));
	           }
	          
	          
	          
	         
	          
	         System.out.println("Program Successfull");
			 
	         s.close();
	         con.close();  
			 
	        }catch(ClassNotFoundException | SQLException e){
	            
	            System.out.println("Error : "+e);

	}

}
	}