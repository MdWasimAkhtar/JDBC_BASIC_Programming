import java.sql.*;
import java.sql.Savepoint;
/*
When you set a savepoint you define a logical rollback point within a transaction. If an error occurs past a savepoint, you can use the rollback method to undo either all the changes or only the changes made after the savepoint.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Using Transactions to Preserve Data Integrity

One example of a transaction isolation level is TRANSACTION_READ_COMMITTED, which will not allow a value to be accessed until after it has been committed. In other words, if the transaction isolation level is set to TRANSACTION_READ_COMMITTED, the DBMS does not allow dirty reads to occur. The interface Connection includes five values that represent the transaction isolation levels you can use in JDBC:

Isolation Level	Transactions	Dirty Reads	Non-Repeatable Reads	Phantom Reads
TRANSACTION_NONE	Not supported	Not applicable	Not applicable	Not applicable
TRANSACTION_READ_COMMITTED	Supported	Prevented	Allowed	Allowed
TRANSACTION_READ_UNCOMMITTED	Supported	Allowed	Allowed	Allowed
TRANSACTION_REPEATABLE_READ	Supported	Prevented	Prevented	Allowed
TRANSACTION_SERIALIZABLE	Supported	Prevented	Prevented	Prevented

*/

class Savepoint_TCL
{
   public static void main(String[] aa){
   	savepoint_rollback_commit();
   }
   
   public static void savepoint_rollback_commit(){
   
   	String SQL_1= "insert into Emp values(1010,'Aisha','Software-Eng',44000,'Aisha56@gmail.com') ";
   	String SQL_2 = "update Emp set E_name = 'MD Wasim Akhtar' where E_id = 1002 ";
   	
   	try( Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","My@Sql1234")){
   		
   	 	con.setAutoCommit(false);
   	 	
   		
   		try(Statement stmt = con.createStatement()){
   
			 Savepoint savePoint_1 = con.setSavepoint("mysavepoint");
   			
   			int rowCount = stmt.executeUpdate(SQL_1);
   			
   			int rowCount2 = stmt.executeUpdate(SQL_2);
   			
   			//if there is no error commit the change
   			con.commit();
   				
   		}
   		catch(SQLException e ){
   			System.out.println("ROlling back upto savepoint ");
//   			con.rollback(savePoint_1); error savepoint_1 does not exists
   			e.printStackTrace();
   		}
   	}
   	catch(SQLException e ){
   	  e.printStackTrace();
   	}
   
   
   }
   
}
/*
The Connection object has two new methods that help you manage savepoints −
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
setSavepoint(String savepointName) − Defines a new savepoint. It also returns a Savepoint object.

releaseSavepoint(Savepoint savepointName) − Deletes a savepoint. Notice that it requires a Savepoint object as a parameter. This object is usually a savepoint generated by the setSavepoint() method.

There is one rollback (String savepointName) method, which rolls back work to the specified savepoint.

*/