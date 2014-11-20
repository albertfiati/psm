package DBConnection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import ProductStockManagement.Constants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MySQLDBConnector {
	//create an object of SingleObject
	private static MySQLDBConnector connector = new MySQLDBConnector();
	Connection connection = null;
    Statement statement = null;
    ResultSet result_set = null;
	
	//make the constructor private so that this class cannot be
	//instantiated
	private MySQLDBConnector(){}
	
	//Get the only object available
	public static MySQLDBConnector getInstance(){		
	    return connector;
	}
	
	public ResultSet execute(String query) throws SQLException{
		try {
        	connection = (Connection) DriverManager.getConnection(Constants.db_url, Constants.db_user, Constants.db_password);
            statement = (Statement) connection.createStatement();
            result_set = statement.executeQuery(query);
                       
            return result_set;            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return null;
	}
	
	public int executeDDL(String query) throws SQLException{
		try {
			connection = (Connection) DriverManager.getConnection(Constants.db_url, Constants.db_user, Constants.db_password);
            statement = (Statement) connection.createStatement();
            int result_set = statement.executeUpdate(query);
                      
            return result_set;            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return 0;
	}
}
