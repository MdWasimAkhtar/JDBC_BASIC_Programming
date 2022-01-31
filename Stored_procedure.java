import java.sql.*;


class Stored_procedure
{
	public static void main(String[] aa){
		
	callable_Stmt();
	}
	
	public static void callable_Stmt(){
		
		String SQL_QUERY= "{call add_procedure(?,?,?) }";
		try( Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","My@Sql1234");
		
		CallableStatement cst = con.prepareCall(SQL_QUERY);
		
		){
			 cst.setInt(1,3000);
			 cst.setInt(2,100);
			 
			 //register OutPut Parameter
			 cst.registerOutParameter(3,Types.INTEGER);
			 
			 boolean bool = cst.execute();
			 
			 if(bool == true){
			 	ResultSet rs = cst.getResultSet();
			 	while(rs.next()){
			 	System.out.println(rs.getInt(3));
			 	}
			 }
			 else{
			 	int rowCount = cst.getInt(3);
			 	System.out.println("Result  : "+rowCount);
			 }
		
		}
		catch(SQLException e ){
		e.printStackTrace();
		}
	}
}
