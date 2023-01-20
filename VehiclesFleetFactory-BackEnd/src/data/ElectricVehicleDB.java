package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bus.*;

public class ElectricVehicleDB {

	static private Connection myConnection;
	static private String mySQLStatement = null;	
	static private String mySQLQuery = null;
	static private Statement myStatemnt = null;
	static private ResultSet myResultSet = null;
	static private ElectricVehicle anElectricVehicle = null;
	
	/*
	 * return 1 if added successfully otherwise 0
	 */
	public static int insert(ElectricVehicle aNewElectricVehicle) throws SQLException {
		myConnection = DBConnection.getConnection();		
		mySQLStatement = "INSERT into ElectricVehicle(EVSerialNumber, EVMade, EVModel, EVDate, "
				+ "EVTripCounter, EVMaxSpeed, EVBrakePower, EVKwPowerConsumed) values('" 
				+ aNewElectricVehicle.getSerialNumber() + "', \'" 
				+ aNewElectricVehicle.getMade() + "', \'" 
				+ aNewElectricVehicle.getModel() + "', " 
				+ aNewElectricVehicle.getDate() + ", "
				+ aNewElectricVehicle.getTripCounter() + ", \'"
				+ aNewElectricVehicle.getMaxSpeed() + "', \'"
				+ aNewElectricVehicle.getBrakePower() +  "', \'"
				+ aNewElectricVehicle.getKwPowerConsumed() + "\')";
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
	public static int update(ElectricVehicle newElectricVehicle) throws SQLException {
		
		myConnection = DBConnection.getConnection();
		
		mySQLStatement = "UPDATE ElectricVehicle "
				+ "SET EVMade = \'" + newElectricVehicle.getMade() 
				+ "\', EVModel = \'" + newElectricVehicle.getModel() 
				+ "\', EVDate = " + newElectricVehicle.getDate() 
				+ ", EVTripCounter = " + newElectricVehicle.getTripCounter() 
				+ ", EVMaxSpeed = \'" + newElectricVehicle.getMaxSpeed() 
				+ "\', EVBrakePower = \'" + newElectricVehicle.getBrakePower() 
				+ "\', EVKwPowerConsumed = \'" + newElectricVehicle.getKwPowerConsumed() 
				+ "\' WHERE EVSerialNumber = \'" + newElectricVehicle.getSerialNumber() + "\'";
		
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
	public static int delete(String sr ) throws SQLException {
		myConnection = DBConnection.getConnection();
		
		mySQLStatement = "DELETE FROM ElectricVehicle WHERE EVSerialNumber = "  + sr;
		
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
	
	public static ElectricVehicle search(String sr) throws SQLException, SQLException, NumberFormatException, RaiseException{
		
		myConnection = DBConnection.getConnection();
		
		mySQLQuery = "SELECT EVSerialNumber, EVMade, EVModel, EVDate, "
				+ "EVTripCounter, EVMaxSpeed, EVBrakePower, EVKwPowerConsumed "
				+ "FROM ElectricVehicle WHERE EVSerialNumber = " + sr;
		
		myStatemnt = myConnection.createStatement();
		
		myResultSet = myStatemnt.executeQuery(mySQLQuery);
		
		if(myResultSet.next()) {
			anElectricVehicle = new ElectricVehicle(Long.parseLong(myResultSet.getString(1)), myResultSet.getString(2), 
					myResultSet.getString(3), Integer.parseInt(myResultSet.getString(4)), 
					Integer.parseInt(myResultSet.getString(5)), Double.parseDouble(myResultSet.getString(6)), 
					Double.parseDouble(myResultSet.getString(7)), Double.parseDouble(myResultSet.getString(8)));
		}		
		return anElectricVehicle;
	}
	
	public static ArrayList<ElectricVehicle> select() throws SQLException, NumberFormatException, SQLException, RaiseException{
		
		ArrayList<ElectricVehicle> myList = new ArrayList<ElectricVehicle>();
		
		myConnection = DBConnection.getConnection();
		
		mySQLQuery = "SELECT * FROM ElectricVehicle";
		
		myStatemnt = myConnection.createStatement();
		
		myResultSet = myStatemnt.executeQuery(mySQLQuery);
		
		while(myResultSet.next()) {
			anElectricVehicle = new ElectricVehicle(Long.parseLong(myResultSet.getString(1)), myResultSet.getString(2), 
					myResultSet.getString(3), Integer.parseInt(myResultSet.getString(4)), 
					Integer.parseInt(myResultSet.getString(5)), Double.parseDouble(myResultSet.getString(6)), 
					Double.parseDouble(myResultSet.getString(7)), Double.parseDouble(myResultSet.getString(8)));
			
			myList.add(anElectricVehicle);
		}
		
		return myList;
	}
}
