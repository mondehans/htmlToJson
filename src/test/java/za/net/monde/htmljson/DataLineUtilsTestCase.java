package za.net.monde.htmljson;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class DataLineUtilsTestCase {

	@Test
	public void shouldCreate() {
		Map<String, String> data= new HashMap<>();
		data.put("Tech","Tech");
		data.put("Reason","Reason");
		data.put("Lifecycle","Lifecycle");
		data.put("Use","Use");
		DataLineUtils utils = new DataLineUtils();
		TableData createProgLine = (TableData) utils.createProgLine("Programming Stack",data);
		
		assertNotNull(createProgLine.getTech());
		assertNotNull(createProgLine.getLifeCycle());
		assertNotNull(createProgLine.getReason());
		assertNotNull(createProgLine.getUse());
	}

}
