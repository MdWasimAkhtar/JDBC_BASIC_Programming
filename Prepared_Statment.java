import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;


class Prepared_Statement
{
	public static void main(String[] aa)
	{


        }
        
        public static void preCompiled_stmt(){
        
        	String Query = "insert into Student values(?,?,?,?)";
        	
        	try( Connection con =  DriverManager.getConnection("mysql:jdbc://localhost:3306/JDBC","root","My@Sql1234" );
        	PreparedStatement pst = con.prepareStatement(Query);
        	 )
        	 {
        	 	Scanner sc = new Scanner(System.in);
        	 	while(true){
        	 	System.out.println("Enter Your name");
        	 	String name  = sc.nextLine();
        	 	
        	 	System.out.println("Enter Your rollno. ");
        	 	int rollno  = sc.nextInt();
        	 	
        	 	System.out.println("Enter Your mraks");
        	 	int marks  = sc.nextInt();
        	 	
        	 	System.out.println("Enter Your grade");
        	 	String grade  = sc.next();
        	 	
        	 	pst.setString(1,name);
        	 	pst.setInt(2,rollno);
        	 	pst.setInt(3,marks);
        	 	pst.setString(4,grade);
        	 	int rowCount = pst.executeUpdate();
        	 	
        	 	System.out.println("No of rows effected :"+rowCount);
        	 	
                       System.out.println("Do you want to insert one more record");
                       String option = sc.next();
                       if(option.equalsIgnorecase("no")
                       	break;
        	 	}
        	 }
        	 catch(SQLException e ){
        	 	System.out.println("");
        	 }
        }
}








/*
The PreparedStatement interface is a subinterface of Statement. It is used to execute parameterized query.

preparedStatement Query is PreCompiled Query 

Improves performance: The performance of the application will be faster if you use PreparedStatement interface because query is compiled only once.
while creating PreparedStatemen Object Query is compiled.
	
	PreparedStatement pst = con.preparedStatement(Query);->compiled
	
	pst.executedQuery();
	pst.executedQuery(); // 100000lakh time execute

In case Statement query will be complied every time .

The prepareStatement() method of Connection interface is used to return the object of PreparedStatement. Syntax:

public PreparedStatement prepareStatement(String query)throws SQLException{}  

**Method of PreparedStatement 
	setInt()
	setString()
	setFloat()
	setDouble()
  int  executeUpdate()
  Resultset executeQuery()

	Connection interface
	---------------------
	
A Connection is a session between a Java application and a database. It helps to establish a connection with the database.

The Connection interface is a factory of Statement, PreparedStatement, and DatabaseMetaData, i.e., an object of Connection can be used to get the object of Statement and DatabaseMetaData. The Connection interface provide many methods for transaction management like commit(), rollback(), setAutoCommit(), setTransactionIsolation(), etc.

---------------------------------------------------------------------
*/
