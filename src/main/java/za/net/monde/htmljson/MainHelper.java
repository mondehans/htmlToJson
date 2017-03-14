package za.net.monde.htmljson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainHelper {

	public static void prepareTags(List<CategoryStack> mainList, HtmlParser parser, Document doc,
			List<String> areasToExclude) {
		DataLineUtils utils = new DataLineUtils();

		List<String> extractH2tags = parser.extractH2tags(doc);

		Elements tables = parser.extractTables(doc);

		for (String area : areasToExclude) {
			int i = extractH2tags.indexOf(area);
			if (i >= 0) {
				extractH2tags.remove(i);
				tables.remove(i);
			}
		}

		List<List<Element>> tableTrs = tables.stream().map(parser::extractTRelements).collect(Collectors.toList());

		for (int i = 0; i < tableTrs.size(); i++) {
			List<Element> listtr = tableTrs.get(i);

			List<List<Element>> tdElementsLists = listtr.stream().map(parser::extractTDs).collect(Collectors.toList());
			List<String> columnNames = parser.extractTHs(listtr.get(0));
			List<TableDataBase> listData = new ArrayList<TableDataBase>();
			for (List<Element> tdListForTr : tdElementsLists) {
				List<String> tdText = tdListForTr.stream().map(parser::getText).collect(Collectors.toList());
				if (!tdText.isEmpty()) {
					Map<String, String> data = new HashMap<>();
					for (int j = 0; j < tdText.size(); j++) {
						data.put(columnNames.get(j), tdText.get(j));
					}
					TableDataBase createdDataLine = utils.createProgLine(extractH2tags.get(i), data);
					listData.add(createdDataLine);
				}
			}
			mainList.add(new CategoryStack(extractH2tags.get(i), listData));
		}
	}
}
