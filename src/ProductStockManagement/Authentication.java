package ProductStockManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utilities.Utilities;
import models.Staff;

public class Authentication {
	public static boolean login(String staff_id) throws SQLException{
		// get staff
		Utilities utility = new Utilities();
		Staff staff = new Staff();
		String query = utility.get(staff,"staff_id",staff_id);
		ResultSet result_set = staff.runQueryWithResult(query);
		
		return (result_set.first()) ? true :  false;
	}
	
	public static String[] signup(){
		String[] res = {};
		return res;
	}
}
