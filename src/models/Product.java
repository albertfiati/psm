package models;

public class Product extends Model{
	
	public int category_id;
	public String name;
	public String description;
	
	public Product(){};
	
	public Product(int category_id, String name, String description){		
		this.name = name;
		this.category_id = category_id;
		this.description = description;
	}
}
