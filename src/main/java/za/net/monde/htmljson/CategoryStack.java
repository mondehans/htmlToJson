package za.net.monde.htmljson;

import java.util.List;


public class CategoryStack {

	private String area;
	
	List<TableDataBase> listOftech;
	public CategoryStack(String area, List<TableDataBase> listOftech) {
		super();
		
		this.area = area;
		this.listOftech = listOftech;
	}
	public String getArea() {
		return area;
	}
	public List<TableDataBase> getListOftech() {
		return listOftech;
	}
	
	
	
}
