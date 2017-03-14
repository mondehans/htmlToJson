package za.net.monde.htmljson;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

public class MainHelperTestCase {

	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test
	public void shouldExcludeThelist() throws Exception{
		List <String> areasToExclude = Arrays.asList("Monitoring");
		
		List<CategoryStack> mainList= new ArrayList<>();
		HtmlParser parser = new HtmlParser();
		Document doc = Jsoup.connect("https://github.com/egis/handbook/blob/master/Tech-Stack.md").get();

		MainHelper.prepareTags(mainList, parser, doc, areasToExclude);
		
		String results=JAXBTransformer.toJSON(mainList);
	
		assertFalse(results.contains("Monitoring"));
		assertTrue(results.contains("Programming Stack"));
	}
	
	@Test
	public void shouldExcludeMotehnOne() throws Exception{
		
		List <String> areasToExclude = Arrays.asList("Monitoring","Programming Stack");
		
		List<CategoryStack> mainList= new ArrayList<>();
		HtmlParser parser = new HtmlParser();
		Document doc = Jsoup.connect("https://github.com/egis/handbook/blob/master/Tech-Stack.md").get();

		MainHelper.prepareTags(mainList, parser, doc, areasToExclude);
		
		String results=JAXBTransformer.toJSON(mainList);
	
		assertFalse(results.contains("Monitoring"));
		assertFalse(results.contains("Programming Stack"));
		assertTrue(results.contains("Build Stack"));
	}
	
	@Test
	public void shouldExcludeAll() throws Exception{
		List <String> areasToExclude = Arrays.asList("Monitoring","Programming Stack","Build Stack","Infrastructure");
		
		List<CategoryStack> mainList= new ArrayList<>();
		HtmlParser parser = new HtmlParser();
		Document doc = Jsoup.connect("https://github.com/egis/handbook/blob/master/Tech-Stack.md").get();

		MainHelper.prepareTags(mainList, parser, doc, areasToExclude);
		
		String results=JAXBTransformer.toJSON(mainList);
	
		assertFalse(results.contains("Monitoring"));
		assertFalse(results.contains("Programming Stack"));
		assertFalse(results.contains("Build Stack"));
		assertFalse(results.contains("Infrastructure"));
	}
	
	@Test
	public void shouldNotExceludeAnything()throws Exception{
	
	List <String> areasToExclude = Arrays.asList("Gauteng place of Gold");
		
		List<CategoryStack> mainList= new ArrayList<>();
		HtmlParser parser = new HtmlParser();
		Document doc = Jsoup.connect("https://github.com/egis/handbook/blob/master/Tech-Stack.md").get();

		MainHelper.prepareTags(mainList, parser, doc, areasToExclude);
		
		String results=JAXBTransformer.toJSON(mainList);
	
		assertTrue(results.contains("Monitoring"));
		assertTrue(results.contains("Programming Stack"));
		assertTrue(results.contains("Build Stack"));
		assertTrue(results.contains("Infrastructure"));
	}

}
