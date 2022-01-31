import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;



class Create_Table
{
    public static void main(String[] aa)
    {
     	create_table();
    }
    
    public static void create_table(){
    	
    	String sql_Query ="create table Student(name varchar(50) not null ,rollno int(10) primary key ,marks int(10) not null , grade varchar(30) not null);";

    	try( Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","My@Sql1234");
    		
    		Statement st = con.createStatement();
    		
    		
    	){
    		System.out.println(con);
    		int rs = st.executeUpdate(sql_Query);
    		System.out.println("No. Of rows effected: "+rs);
    	}
    	catch (SQLException e) {
         e.printStackTrace();
      } 
    		
    }
}
