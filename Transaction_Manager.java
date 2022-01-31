import java.sql.*;

/*
three Method of Connection Interface
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1. conn.setAutoCommit(false);
2. conn.commit();
3. conn.rollback();


without transaction manager the quries are commit change into database one by one bcz, by default setAutoCommit() is true 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
|query-1                     |
|query-2                     |
|query-3                     |
|query-4                     |
|query-5 if exception occur's| 
|query-6                     |
|query-7                     |
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

savepoint()--within the transaction if we want to rollback a group of stmt based on some condition
*/

class Transaction_Manager
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
   	  	
   	  	pst.setInt(1,1009);
   	  	pst.setString(2,"MULAN");
   	  	pst.setString(3,"developer");
   	  	pst.setInt(4,45000);
   	  	pst.setString(5,"mulan@gmail.com");
   	  	
   	  	pst.executeUpdate();
   	  	
   	  	pst.setInt(1,1008);
   	  	pst.setString(2,"mahima Akhtar");
   	  	pst.setString(3,"sell-Woman");
   	  	pst.setInt(4,34000);
   	  	pst.setString(5,"Mahima98working@gmail.com");
   	  	
   	  	pst.executeUpdate();
	   }
	   catch(SQLException  e ){
//	   	conn.rollback(); connection will be closed before executing catch block
	   	e.printStackTrace();
	   }
	   
   }
}
/*
Transaction represents a single unit of work.

The ACID properties describes the transaction management well. ACID stands for Atomicity, Consistency, isolation and durability.

Atomicity means either all successful or none.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Consistency ensures bringing the database from one consistent state to another consistent state.

Isolation ensures that transaction is isolated from other transaction.

Durability means once a transaction has been committed, it will remain so, even in the event of errors, power loss etc.

Advantage of Transaction Mangaement
fast performance It makes the performance fast because database is hit at the time of commit.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
If your JDBC Connection is in auto-commit mode, which it is by default, then every SQL statement is committed to the database upon its completion.

That may be fine for simple applications, but there are three reasons why you may want to turn off the auto-commit and manage your own transactions −

To increase performance.

To maintain the integrity of business processes.

To use distributed transactions.

Transactions enable you to control if, and when, changes are applied to the database. It treats a single SQL statement or a group of SQL statements as one logical unit, and if any statement fails, the whole transaction fails.

To enable manual- transaction support instead of the auto-commit mode that the JDBC driver uses by default, use the Connection object's setAutoCommit() method. If you pass a boolean false to setAutoCommit( ), you turn off auto-commit. You can pass a boolean true to turn it back on again.
---------------------------------------------------------------------------------------------------------------------------------
Commit & Rollback
Once you are done with your changes and you want to commit the changes then call commit() method on connection object as follows −

conn.commit( );
Otherwise, to roll back updates to the database made using the Connection named conn, use the following code −

conn.rollback( );
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



*/
