import java.sql.*;

class Transaction_Manager02
{
   public static void main(String[] aa){
   	batch_add();
   }
   
   public static void batch_add(){
   
   	String SQL_Query = "insert into Emp values(?,?,?,?,?)";
   	 
   	 try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","My@Sql1234") ) {
   	 
   	 	    conn.setAutoCommit(false);
   	 	  
   	 	
   	 	try( PreparedStatement pst = conn.prepareStatement(SQL_Query)
   	 	){
   	 		
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
   	 	catch(SQLException e){
   	 		System.out.println("ROlling back The Transaction yes do rollback");
   	 		conn.rollback();
   	 		conn.setAutoCommit(true);
   	 	}
   	}
   	 
	   catch(SQLException  e ){
//	   	conn.rollback(); connection will be closed before executing catch block
	   	e.printStackTrace();
	   }
	   
   
}

}
/*
The RELEASE SAVEPOINT statement removes the named savepoint from the set of savepoints of the current transaction. No commit or rollback occurs. It is an error if the savepoint does not exist.


*/


