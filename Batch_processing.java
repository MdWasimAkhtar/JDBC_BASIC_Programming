import java.sql.*;

class Batch_processing
{
   public static void main(String[] aa){
   	batch_add();
   }
   
   public static void batch_add(){
   	 
   	 try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","My@Sql1234");
   	 	
   	 	Statement stmt = conn.createStatement();
   	 	
   	 	
   	  ){
   	  	conn.setAutoCommit(false);
   	  	
   	  	String SQL_query1= "insert into Emp values(1002,'Wasi','Developer',90000,'mdwasi149@gmail.com')";
   	  	
   	  	stmt.addBatch(SQL_query1);
   	  	
   	  	String SQL_ = " insert into Emp values (1004,'Kathrin Brunt','expert',150000,'Burnt333Burn@gmail.com') ";
   	  	
   	  	stmt.addBatch(SQL_);
   	  	
   	  	String SQL_query2 = "update Student set name = 'Lizze' where rollno = 92";
   	  	stmt.addBatch(SQL_query2);
   	  	
   	  	int[] count = stmt.executeBatch();
   	  	
   	  	System.out.println("No of rows effected "+count);
   	  	
   	  	//explicitly commit statement to Apply  changes
   	  	conn.commit();
   	  	
	   }catch(SQLException  e ){
	   	e.printStackTrace();
	   }
	   
   }
}

/*
setAutoCommit(false) will allow you to group multiple subsequent Statement s under the same transaction. This transaction will be committed when connection. commit() is invoked, as opposed to after each execute() call on individual Statement s (which happens if autocommit is enabled
---------------------------------------------------
Batch Processing allows you to group related SQL statements into a batch and submit them with one call to the database.

When you send several SQL statements to the database at once, you reduce the amount of communication overhead, thereby improving performance.

JDBC drivers are not required to support this feature. You should use the DatabaseMetaData.supportsBatchUpdates() method to determine if the target database supports batch update processing. The method returns true if your JDBC driver supports this feature.

The addBatch() method of Statement, PreparedStatement, and CallableStatement is used to add individual statements to the batch. The executeBatch() is used to start the execution of all the statements grouped together.

The executeBatch() returns an array of integers int[] arr, and each element of the
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 array represents the update count for the respective update statement.

Just as you can add statements to a batch for processing, you can remove them with the clearBatch() method. This method removes all the statements you added with the addBatch() method. However, you cannot selectively choose which statement to remove

*/
