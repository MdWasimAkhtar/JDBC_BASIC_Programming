import java.sql.*;

/*
Batch Processing allows you to group related SQL statements into a batch and submit them with one call to the database.

When you send several SQL statements to the database at once, you reduce the amount of communication overhead, thereby improving performance.
*/

class Batch_processing_PreparedStmt
{
   public static void main(String[] aa){
   	batch_add();
   }
   
   public static void batch_add(){
   
   	String SQL_Query = "insert into Emp values(?,?,?,?,?)";
   	 
   	 try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","My@Sql1234");
   	 	
   	 	PreparedStatement pst = conn.prepareStatement(SQL_Query);
   	 	
   	  ){
   	  	conn.setAutoCommit(false);
   	  	
   	  	pst.setInt(1,1005);
   	  	pst.setString(2,"Nina");
   	  	pst.setString(3,"Manager");
   	  	pst.setInt(4,56000);
   	  	pst.setString(5,"Nina78working@gmail.com");
   	  	
   	  	pst.addBatch();
   	  	
   	  	pst.setInt(1,1006);
   	  	pst.setString(2,"Jemma");
   	  	pst.setString(3,"Executive");
   	  	pst.setInt(4,67000);
   	  	pst.setString(5,"Jemma78working@gmail.com");
   	  	
   	  	pst.addBatch();
   	  	
   	  	int count[] = pst.executeBatch();
   	  	
   	  	conn.commit();
   	  	
   	  	
	   }
	   catch(SQLException  e ){
	   	e.printStackTrace();
	   }
	   
   }
}

