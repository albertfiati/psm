package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSetMetaData;

import utilities.Utilities;
import DBConnection.MySQLDBConnector;

public class Model {
	MySQLDBConnector connector = MySQLDBConnector.getInstance();
	
	public void runQuery(String query) throws SQLException {
		ResultSet result_set = connector.execute(query);
		ResultSetMetaData result_set_meta_data = (ResultSetMetaData) result_set.getMetaData();
		

		for(int i =1; i <= result_set_meta_data.getColumnCount();++i){
			System.out.print(result_set_meta_data.getColumnName(i) + "\t |");
		}
		
		System.out.println("");
		
		while(result_set.next()){			
			for(int i =1; i <= result_set_meta_data.getColumnCount();++i){
				System.out.print(result_set.getString(i)  + "\t |");
			}
			
			System.out.println("");
		}			
	}
	
	public ResultSet runQueryWithResult(String query) throws SQLException {
		ResultSet result_set = connector.execute(query);
		return result_set;			
	}
	
	public void runQuery(String query, boolean DDL) throws SQLException {
		connector.executeDDL(query);
		System.out.println("*** " + this.getClass().getSimpleName() + " has been " + query.split(" ")[0].toLowerCase() +"ed");
	}	
}
