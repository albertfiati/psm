package models;

import java.sql.ResultSet;

public class Branch extends Model{
	public String name;
	public int company_id;
	
	public Branch(int company_id, String name){
		this.name = name;
		this.company_id = company_id;
	}
	
	public ResultSet runQuery(String action, String query){
		return null;
	}
}
