package up.biblioteca.db;

import java.sql.*;

public class CreateDatabaseTablesDataCloud {
	
	 // JDBC driver name and database URL
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 static String DB_URL = "jdbc:"+ "mysql://sl-us-south-1-portal.6.dblayer.com:26735/";
	 static String DB_URL_USER = "jdbc:mysql://sl-us-south-1-portal.6.dblayer.com:26735/UserDB";

	 //  Database credentials
	 static final String USER = "admin";
	 static final String PASS = "ZAOIONYZQEQKDIUT";

	 public static void main(String[] args) {
		 Connection conn = null;
		 Statement stmt = null;
		 try{
			 
			
		    //STEP 2: Register JDBC driver
		    Class.forName(JDBC_DRIVER);

		    //STEP 3: Open a connection
		    System.out.println("Connecting to database...");
		    conn = DriverManager.getConnection(DB_URL, USER, PASS);

		  //***************************Create Database************************* 
		    
		    //STEP 4: Execute a query
		    System.out.println("Dropping database...");
		    stmt = conn.createStatement();
		    String sql = "DROP DATABASE IF EXISTS UserDB ";
		    stmt.executeUpdate(sql);
		    
		    System.out.println("Creating database...");
		    sql = "CREATE DATABASE UserDB";
		    stmt.executeUpdate(sql);
		    stmt.close();
		    conn.close();
		    System.out.println("Database created successfully...");
		    
		  //***************************Create Tables************************* 
		    
		    sql = "CREATE TABLE LOGIN (ID VARCHAR(20) PRIMARY KEY,   PWD VARCHAR(10))";
		    conn = DriverManager.getConnection(DB_URL_USER, USER, PASS);
		    stmt = conn.createStatement();
		    stmt.executeUpdate(sql);
		    
		    sql = "CREATE TABLE LIVRO (" + 
		    		"  IDLIVRO INT NOT NULL AUTO_INCREMENT," + 
		    		"  TITULO VARCHAR(200) NOT NULL," + 
		    		"  AUTOR VARCHAR(200) NOT NULL," + 
		    		"  ISBN VARCHAR(50) NOT NULL," + 
		    		"  PAGINAS INT NOT NULL," + 
		    		"  VALOR DOUBLE(10,2) NOT NULL," + 
		    		"  PUBLICACAO DATE NOT NULL," + 
		    		"  QUANTIDADE INT NOT NULL," + 
		    		"  PRIMARY KEY(ID)" + 
		    		")";
		    conn = DriverManager.getConnection(DB_URL_USER, USER, PASS);
		    stmt = conn.createStatement();
		    stmt.executeUpdate(sql);
		    
		    System.out.println("Tables created successfully...");
		   
		   //***************************Create Data*************************  
		    
		    sql = "insert into LOGIN (ID,PWD) VALUES ('user1', 'pass1')";
		    stmt.executeUpdate(sql);
		    sql = "insert into LOGIN (ID,PWD) VALUES ('user2', 'pass2')";		      
		    stmt.executeUpdate(sql);
		    
		    System.out.println("Entry Data created  successfully...");
		    
		 }catch(SQLException se){
		    //Handle errors for JDBC
		    se.printStackTrace();
		 }catch(Exception e){
		    //Handle errors for Class.forName
		    e.printStackTrace();
		 }finally{
		    //finally block used to close resources
		    try{
		       if(stmt!=null)
		          stmt.close();
		    }catch(SQLException se2){
		    }// nothing we can do
		    try{
		       if(conn!=null)
		          conn.close();
		    }catch(SQLException se){
		       se.printStackTrace();
		    }//end finally try
		 }//end try
		 System.out.println("Goodbye!");
		}//end main
}//end JDBCExample