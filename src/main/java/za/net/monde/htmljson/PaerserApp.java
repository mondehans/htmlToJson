package za.net.monde.htmljson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PaerserApp {

	public static void main(String[] args) {

		try {
			List<CatergoryStack> mainList= new ArrayList<>();
			HtmlParser parse = new HtmlParser();
			Document doc = Jsoup.connect("https://github.com/egis/handbook/blob/master/Tech-Stack.md").get();

			prepareTags(mainList, parse, doc);
			JAXBFransofmer.toJSOB(mainList);
			System.out.println(mainList);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void prepareTags(List<CatergoryStack> mainList, HtmlParser parse, Document doc) {
		DataLineUtils utils = new DataLineUtils();

		List<String> extractH2tags = parse.extractH2tags(doc);

		Elements tables = parse.extractTables(doc);

		List<List<Element>> tableTrs = tables.stream().map(parse::extractTRelements).collect(Collectors.toList());

		for (int i = 0; i < tableTrs.size(); i++) {
			List<Element> listtr = tableTrs.get(i);

			List<List<Element>> collect = listtr.stream().map(parse::extractTDs).collect(Collectors.toList());
			List<String> columnNames = parse.extractTHs(listtr.get(0));
			List<TableDataBase> listData= new ArrayList<TableDataBase>();
			for (List<Element> listTD : collect) {
				List<String> collect2 = listTD.stream().map(parse::getText).collect(Collectors.toList());
				if (!collect2.isEmpty()) {
					Map<String, String> data = new HashMap<>();
					for (int j = 0; j < collect2.size(); j++) {
						data.put(columnNames.get(j), collect2.get(j));
					}
					TableDataBase createdDataLine = utils.createProgLine(extractH2tags.get(i),data);
					listData.add(createdDataLine);
				}
			}
			mainList.add(new CatergoryStack(extractH2tags.get(i), listData));
		}
	}

}
