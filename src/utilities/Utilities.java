package utilities;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Utilities {	
	public String create(Object object) throws IllegalArgumentException, IllegalAccessException{		
		Field[] fields = object.getClass().getFields();
		ArrayList<String> column_names = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		
		for (Field field : fields) {
			column_names.add(field.getName());
			values.add(field.get(object).toString());
		}
		
		return "INSERT INTO " + getTableName(object) + "("+convertToString(column_names).replace("'", "")+") VALUES("+convertToString(values)+")";
	}
	
	public String get(Object object, String column_name, String value){
		return "Select * from " + getTableName(object) + " where " + column_name + " Like '%" + value + "%'";
	}
	
	public String getAll(Object object){
		return "Select * from " + getTableName(object);
	}
	
	public String delete(Object object, String column_name, String value){
		return "Delete from " + getTableName(object) + " where " + column_name + " Like '%" + value + "%'";
	}
	
	public static String convertToString(ArrayList<String> array_list){
		String string_representation = "";
		
		for (String element : array_list) {
			string_representation += "'" + element + "',";
		}
		
		return string_representation.substring(0,string_representation.length()-1);
	}
	
	public static String getTableName(Object object){
		return object.getClass().getSimpleName().toLowerCase() + "s";
	}
}
