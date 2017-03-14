package za.net.monde.htmljson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParserApp {

	public static void main(String[] args) {

		try {
			List <String> areasToExclude = Arrays.asList("Monitoring");
			
			List<CategoryStack> mainList= new ArrayList<>();
			HtmlParser parser = new HtmlParser();
			Document doc = Jsoup.connect("https://github.com/egis/handbook/blob/master/Tech-Stack.md").get();

			MainHelper.prepareTags(mainList, parser, doc, areasToExclude);
			
			System.out.println(JAXBTransformer.toJSON(mainList));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	

}
