package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bus.*;

public class GasVehicleDB {

	static private Connection myConnection;
	static private String mySQLStatement = null;	
	static private String mySQLQuery = null;
	static private Statement myStatemnt = null;
	static private ResultSet myResultSet = null;
	static private GasVehicle aGasVehicle = null;
	
	/*
	 * return 1 if added successfully otherwise 0
	 */
	public static int insert(GasVehicle aNewGasVehicle) throws SQLException 
	{
		myConnection = DBConnection.getConnection();		
		mySQLStatement = "INSERT into GasVehicle(GVSerialNumber, GVMade, GVModel, GVDate,"
				+ "GVTripCounter, GVMaxSpeed, GVBrakePower, GVFuelConsumed) values('" 
				+ aNewGasVehicle.getSerialNumber() + "', \'" 
				+ aNewGasVehicle.getMade() + "', \'" 
				+ aNewGasVehicle.getModel() + "', " 
				+ aNewGasVehicle.getDate() + ", "
				+ aNewGasVehicle.getTripCounter() + ", \'"
				+ aNewGasVehicle.getMaxSpeed() + "', \'"
				+ aNewGasVehicle.getBrakePower() +  "', \'"
				+ aNewGasVehicle.getFuelConsumed() + "\')";
		try {
			myStatemnt = myConnection.createStatement();
			int rowAffected = myStatemnt.executeUpdate(mySQLStatement);
			     myConnection.commit();			
			if(rowAffected > 0) {
				return 1;
			}else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//Look into which part to update
	public static int update(GasVehicle newGasVehicle) throws SQLException 
	{
		
		myConnection = DBConnection.getConnection();
		
		mySQLStatement = "UPDATE GasVehicle "
				+ "SET GVMade = \'" + newGasVehicle.getMade() 
				+ "\', GVModel = \'" + newGasVehicle.getModel() 
				+ "\', GVDate = " + newGasVehicle.getDate() 
				+ ", GVTripCounter = " + newGasVehicle.getTripCounter() 
				+ ", GVMaxSpeed = \'" + newGasVehicle.getMaxSpeed() 
				+ "\', GVBrakePower = \'" + newGasVehicle.getBrakePower() 
				+ "\', GVFuelConsumed = \'" + newGasVehicle.getFuelConsumed() 
				+ "\' WHERE GVSerialNumber = \'" + newGasVehicle.getSerialNumber() + "\'";
		
		try {
			
			myStatemnt = myConnection.createStatement();
			
			int rowAffected = myStatemnt.executeUpdate(mySQLStatement);
			
			    myConnection.commit();	
			    
			if(rowAffected > 0) {
				return 1;
			}else {
				return 0;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 
	 * @param id primary key of vehicle
	 * @return	return 1 if removed successfully otherwise 0
	 * @throws SQLException
	 */
	public static int delete(String sr ) throws SQLException 
	{
		myConnection = DBConnection.getConnection();
		
		mySQLStatement = "DELETE FROM GasVehicle WHERE GVSerialNumber = " + sr;
		
		try {
			myStatemnt = myConnection.createStatement();
			int rowAffected = myStatemnt.executeUpdate(mySQLStatement);
			
			myConnection.commit();	
			
				if(rowAffected > 0) {
					return 1;
				}else {
					return 0;
				}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static GasVehicle search(String sr) throws SQLException, SQLException, NumberFormatException, RaiseException
	{
		
		myConnection = DBConnection.getConnection();
		
		mySQLQuery = "SELECT GVSerialNumber, GVMade, GVModel, GVDate, "
				+ "GVTripCounter, GVMaxSpeed, GVBrakePower, GVFuelConsumed "
				+ "FROM GasVehicle WHERE GVSerialNumber = " + sr;
		
		myStatemnt = myConnection.createStatement();
		
		myResultSet = myStatemnt.executeQuery(mySQLQuery);
		
		if(myResultSet.next()) {
			aGasVehicle = new GasVehicle(Long.parseLong(myResultSet.getString(1)), myResultSet.getString(2), 
					myResultSet.getString(3), Integer.parseInt(myResultSet.getString(4)), 
					Integer.parseInt(myResultSet.getString(5)), Double.parseDouble(myResultSet.getString(6)), 
					Double.parseDouble(myResultSet.getString(7)), Double.parseDouble(myResultSet.getString(8)));
		}		
		return aGasVehicle;
	}
	
	public static ArrayList<GasVehicle> select() throws SQLException, NumberFormatException, SQLException, RaiseException
	{
		
		ArrayList<GasVehicle> myList = new ArrayList<GasVehicle>();
		
		myConnection = DBConnection.getConnection();
		
		mySQLQuery = "SELECT * FROM GasVehicle";
		
		myStatemnt = myConnection.createStatement();
		
		myResultSet = myStatemnt.executeQuery(mySQLQuery);
		
		while(myResultSet.next()) {
			
			aGasVehicle = new GasVehicle(Long.parseLong(myResultSet.getString(1)), myResultSet.getString(2), 
					myResultSet.getString(3), Integer.parseInt(myResultSet.getString(4)), 
					Integer.parseInt(myResultSet.getString(5)), Double.parseDouble(myResultSet.getString(6)), 
					Double.parseDouble(myResultSet.getString(7)), Double.parseDouble(myResultSet.getString(8)));
			
			myList.add(aGasVehicle);
		}
		
		return myList;
	}
}
