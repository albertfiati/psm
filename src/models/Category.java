package models;

import java.sql.ResultSet;

public class Category extends Model{
	public String name;
	
	public Category(){}
	
	public Category(String name){
		this.name = name;
	}
	
	public ResultSet runQuery(String action, String query){
		return null;
	}
}
