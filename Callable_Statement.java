import java.sql.*;


class Callable_Statement
{
	public static void main(String[] aa){
		
	prepareCall_stmt();
	}
	
	public static void prepareCall_stmt(){
		
		String SQL_QUERY = "{call sp_get_Student(?) }";
		
		try( Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","My@Sql1234"); 
		
		CallableStatement cst = con.prepareCall(SQL_QUERY);
		
	      ){
	      	System.out.println("Connection Established "+con);
			cst.setString(1,"shilpa");
			
			boolean bool = cst.execute();
			
			if(bool == true){
				ResultSet rs = cst.getResultSet();
				while(rs.next())
					System.out.println(rs.getString(1)+" "+rs.getInt(2)+ " "+rs.getInt(3)+"  "+rs.getString(4));
			}
			else{
				int rowCount = cst.getUpdateCount();
				System.out.println("No of Rows Effected "+rowCount);
			}
		
		}
		catch(SQLException e ){
		
		e.printStackTrace();
		}
	}
}
