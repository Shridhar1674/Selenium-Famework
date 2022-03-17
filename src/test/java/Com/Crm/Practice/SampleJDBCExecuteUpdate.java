package Com.Crm.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate 
{
	private int result;

	@Test
public void sampleJDBCExecuteUpate() throws SQLException
{
	//step 1:register the database
	Driver driverref = new Driver();
	DriverManager.registerDriver(driverref);
	
	//step 2: get connector from database
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root","root");
	
	//step 3: issue create statement
	 Statement stat = con.createStatement();
	 
	 result = stat.executeUpdate("insert into student values (6,'aishwarya','female');");
	 
	 //step 5: close the database
	 con.close();
	 
	 		 
}



}
