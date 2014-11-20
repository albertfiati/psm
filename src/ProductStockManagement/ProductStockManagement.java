package ProductStockManagement;

import java.sql.SQLException;
import java.util.Scanner;

import utilities.Utilities;
import models.Category;
import models.Product;

public class ProductStockManagement {	
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, SQLException{		
		start();		
	}
	
	public static void start() throws IllegalArgumentException, IllegalAccessException, SQLException{					
		//	welcome user to the system
		System.out.println("**************************************************************************");
		System.out.println("Welcome to the Product stock management system");
		System.out.println("**************************************************************************");
		
		//	ask user for company name
		System.out.print("\nEnter the name of your company for access: ");		
		String company_name = input.nextLine();
		
		//	ask user for username and password
		System.out.print("Enter your staff id to login: ");		
		String staff_id = input.nextLine();
		
		//	authenticate user
		boolean user_is_authenticated = Authentication.login(staff_id);
		//System.out.println(user_is_authenticated);
		
		//	if authentication passes, continue else break the app and start allover
		if(user_is_authenticated){
		//	load menu items
			System.out.println("\n\n**************************************************************************");
			Menu.load();			
		}else{
			System.out.println("\n Sorry!.... Access denied... Try again");
			System.out.println("\n");
			
			start();
		}
	}	
}
