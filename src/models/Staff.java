package models;

public class Staff extends Model{
	public String name;
	public String staff_id;
	
	public Staff(){}
	
	public Staff(String name, String staff_id){
		this.name = name;
		this.staff_id = staff_id;
	}
}
