package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * this class contains generic method to read data from Database
 * @author acer
 *
 */
public class DatabaseUtility {
	
	Connection con = null;
	/**
	 * this method will register the driver and estalish connection with database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
        DriverManager.getConnection(IPathConstants.dburl, IPathConstants.dbUserName, IPathConstants.dbPassword);
	}
	/**
	 * This method will close the database connection
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	/**
	 * This method will execute the query and return the matching data to the user
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws Throwable
	{
		String data = null;
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			data = result.getString(columnIndex);
			if(data.equalsIgnoreCase(expData))
			{
				flag = true;//flag rising
				break;
			}
		}
		
		if(flag)
		{
			System.out.println(data+"----> data is verified");
			return expData;
		}
		else
		{
			System.out.println("data is not verified");
			return"";
		}
	}

}
