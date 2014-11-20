package ProductStockManagement;

public final class Constants {
	private Constants(){}
	
	public static final String[] menu_items = {"1. Get Product",
											   "2. Get Products",
	  										   "3. Add Product", 
	  										   "4. Get Category", 
	  										   "5. Get Categories",
	  										   "6. Add Category",
	  										   "7. Get Staff",
	  										   "8. Get All Staff",
	  										   "9. Add Staff"};
	    
	public static final String db_url = "jdbc:mysql://localhost:3306/testdb";
	public static final String db_user = "root";
	public static final String db_password = "iprosoft1";
}
