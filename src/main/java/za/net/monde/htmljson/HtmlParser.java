package za.net.monde.htmljson;

import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {

	public List<String> extractH2tags(Document doc) {
		Elements h2s = doc.select("h2");
		return h2s.stream().map(x -> x.text()).filter(x -> !x.matches("Users(.*)")).collect(Collectors.toList());
	}

	public Elements extractTables(Document doc) {
		return doc.select("table");
	}

	public List<Element> extractTRelements(Element table) {
		return table.select("tr");
	}

	public List<Element> extractTDs(Element tr) {
		return tr.select("td");
	}
	
	public List<String> extractTHs(Element tr) {
		return tr.select("th").stream().map(this::getText).collect(Collectors.toList());
	}
	
	public String getText(Element td){
		return td.text();
	}
}
