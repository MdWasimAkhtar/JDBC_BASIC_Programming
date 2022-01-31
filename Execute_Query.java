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

class Execute_Query
{
    public static void main(String[] aa)
    {
    	Execute_Query.execute_();
    
    }
    
    public static void execute_(){
    
/*    	String sql_Query = "insert into Student(name , rollno , marks , grade) values ('Shilpa',12,76,'A');";
*/

    	
    	try( Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","My@Sql1234");
    		
    		Statement stmt = con.createStatement();
    		
    	)
    	{
    		try{
    		    while(true){

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Query ");
		String sql_Query  = sc.nextLine();
    		
    		boolean trueFalse = stmt.execute(sql_Query);
    		
    		if( trueFalse == true){
    			ResultSet rs = stmt.getResultSet();
    			while(rs.next()){
    			System.out.println(rs.getString(1)+" " +rs.getInt(2)+" "+rs.getInt(3)+ "  "+rs.getString(4));
    			}
    		}
    		else{
    		int rowCount = stmt.getUpdateCount();
    		System.out.println("No of rows effected " +rowCount);
    	     }	
	}
    		
   }
   catch(Exception e ){
     System.out.println("Invaild option");
   }
		
    	}
    	catch(SQLException e ){
    	e.printStackTrace();
    	}
    }
}
