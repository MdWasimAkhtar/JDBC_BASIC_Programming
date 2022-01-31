import java.sql.*;
import java.util.*;

class jdbc_01
{
   public static void main(String[] aa)
   {
   	String url = "jdbc:mysql://localhost:3306/Testing";
   	String user ="root";
   	String passwd = "My@Sql1234";
   	
   	String sql_Query = "Select * from EMPLOYEES";
   	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,passwd);
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql_Query);
		while(rs.next())
		     System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4));
		     
		rs.close();
		st.close();
	}   
	catch(ClassNotFoundException |  SQLException e ){
	
	System.out.println("Error Occured "+e);
	}
   
   }
}
