import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;
import java.sql.ResultSet;
/*
   since jdbc 4 .0 automatic loading of driver occur's 
*/

class Insert_Dynamically
{
    public static void main(String[] aa)
    {
    	insert_dynamically();
    
    }
    
    public static void insert_dynamically(){
    
/*    	String sql_Query = "insert into Student(name , rollno , marks , grade) values ('Shilpa',12,76,'A');";
*/

    	
    	try( Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","My@Sql1234");
    		
    		Statement stmt = con.createStatement();
    		
    	)
    	{
    	   while(true){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Name :");
		String name  = sc.nextLine();
		
		System.out.println("Enter your ROll Number ");
		int rollno = sc.nextInt();
		
		System.out.println("Enter your Marks ");
		int marks = sc.nextInt();
		
		System.out.println("Enter your Grade ");
		String grade = sc.next();
		
		String sql_Query = String.format("insert into Student values('%s',%d,%d,'%s')",name , rollno, marks , grade );
		
		int rowCount = stmt.executeUpdate(sql_Query);
		System.out.println("no. of rows effected : "+rowCount);
		
		System.out.println("Do You Want to insert One More Query");
		String option = sc.next();
		if(option.equalsIgnoreCase("no"))
			break;
	     }	
    	}
    	catch(SQLException e ){
    	e.printStackTrace();
    	}
    }
}
