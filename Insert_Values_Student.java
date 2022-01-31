import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

class Insert_Values_Student
{
    public static void main(String[] aa)
    {
    	Insert_Values_Student.insert_into_student();
    
    }
    
    public static void insert_into_student(){
    
    	String sql_Query = "insert into Student(name , rollno , marks , grade) values ('Shilpa',12,76,'A');";
    	
    	try( Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","My@Sql1234");
    		
    		Statement stmt = con.createStatement();
    		
    	)
    	{
    		int rs = stmt.executeUpdate(sql_Query);
    		System.out.println("No of rows effected " +rs);
    	}
    	catch(SQLException e ){
    	e.printStackTrace();
    	}
    }
}
