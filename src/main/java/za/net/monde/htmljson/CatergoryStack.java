package za.net.monde.htmljson;

import java.util.List;


public class CatergoryStack {

	private String name;
	
	List<TableDataBase> listOftech;
	public CatergoryStack(String name, List<TableDataBase> listOftech) {
		super();
		
		this.name = name;
		this.listOftech = listOftech;
	}
	public String getName() {
		return name;
	}
	public List<TableDataBase> getListOftech() {
		return listOftech;
	}
	
	
	
}
