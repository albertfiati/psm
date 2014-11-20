package ProductStockManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import models.Category;
import models.Product;
import models.Staff;
import utilities.Utilities;

public class Menu {
	public static Scanner input = new Scanner(System.in);
	
	public static void load() throws IllegalArgumentException, IllegalAccessException, SQLException{
		System.out.println("\nWelcome!... HERE ARE YOUR MENU ITEMS");
		
		for (String menu_item : Constants.menu_items) {
			System.out.println(menu_item);
		}
		
		// ask user to select a menu item
		System.out.print("\nEnter 1-9 to select a menu item: ");
		int menu_item = input.nextInt();
		select(menu_item);
	}
	
	public static void select(Integer menu_item) throws IllegalArgumentException, IllegalAccessException, SQLException{
		Utilities utility = new Utilities();
		String query = null;
		Product product = new Product();
		Category category = new Category();
		Staff staff = new Staff();
		
		ResultSet result_set = null;
		
		switch (menu_item) {
		case 1:
			// get product
			System.out.print("\nEnter product name: ");
			query = utility.get(product,"name",input.next());
			product.runQuery(query);
			break;
		case 2:
			//get products
			query = utility.getAll(product);
			product.runQuery(query);
			break;
		case 3:
			//create product
//			System.out.print("\nEnter name of staff: ");
//			String category_id = input.next();
			System.out.print("\nEnter product name: ");
			String name = input.next();			
			System.out.print("Enter product description: ");
			String description = input.next();
			
			product = new Product(1,name,description);
			query = utility.create(product);
			product.runQuery(query,true);
			break;		
		case 4:
			//get category
			System.out.print("\nEnter category name: ");
			query = utility.get(category,"name",input.nextLine());
			category.runQuery(query);
			break;
		case 5:
			//get categories
			query = utility.getAll(category);
			category.runQuery(query);
			break;
		case 6:
			//add category
			System.out.print("\nEnter name of category: ");
			String category_name = input.next();
			category = new Category(category_name);
			query = utility.create(category);
			category.runQuery(query,true);
			break;
		case 7:
			// get staff
			System.out.print("\nEnter name of staff: ");
			query = utility.get(staff,"name",input.nextLine());
			staff.runQuery(query);
			break;
		case 8:
			// get all staff
			query = utility.getAll(staff);
			staff.runQuery(query);
			break;
		case 9:
			//add staff
			System.out.print("\nEnter name of staff: ");
			String staff_name = input.next();
			System.out.print("Enter staff id: ");
			String staff_id = input.next();
			
			staff = new Staff(staff_name,staff_id);
			query = utility.create(staff);
			staff.runQuery(query, true);
			break;
		default:
			break;
		}
		
		//System.out.println("\nResult set : " + result_set);
		System.out.println("\n\n**************************************************************************");
		System.out.println("**************************************************************************");
		System.out.println("\n\nDo you want to perform another operation? Enter 1 for yes or 0 for no: ");
		boolean i_want_to_perform_another_operation = (input.nextInt()==1) ? true : false;
		
		if(i_want_to_perform_another_operation){
			load();
		}else{
			// exit the application
		}
	}
}
