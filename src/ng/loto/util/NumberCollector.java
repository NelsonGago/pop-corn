package ng.loto.util;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NumberCollector {
	
	
	
	public static void main(String[] args)  {
		
		NumberCollector nc = new NumberCollector();
		nc.getQuebec49TirageNumbers(2017);

	}
	
	
	
	
	public Map<String, int[]>  getQuebec49TirageNumbers(int pYear)  {
		
		String mainURl = "https://loteries.espacejeux.com/fr/loteries/quebec-49?annee="+pYear+"&widget=resultats-anterieurs&noProduit=214#res";
		
		Map<String, int[]> tirages =  new HashMap<String, int[]>();
		
		try {
			
			Document doc = Jsoup.connect(mainURl)
					  .data("query", "Java")
					  .userAgent("Mozilla")
					  .cookie("auth", "token")
					  .timeout(5000)
					  .post();			
			
			Element table = doc.getElementsByTag("table").get(0);
			Elements tableRows = table.getElementsByTag("tr");
			// remove the header TR
			tableRows.remove(0);
			
			// Now for each table row, get the numbers
			for (Element tableRow: tableRows) {
				
				String date = tableRow.getElementsByClass("date").text();
				
				//System.out.println(date);
				
				int [] numbers = new int[7];
				// get the spans
				Elements tableSpans = table.getElementsByTag("span");
				// get the seven numbers;
				numbers[0] = Integer.parseInt(tableSpans.get(0).text());
				numbers[1] = Integer.parseInt(tableSpans.get(1).text());
				numbers[2] = Integer.parseInt(tableSpans.get(2).text());
				numbers[3] = Integer.parseInt(tableSpans.get(3).text());
				numbers[4] = Integer.parseInt(tableSpans.get(4).text());
				numbers[5] = Integer.parseInt(tableSpans.get(5).text());
				numbers[6] = Integer.parseInt(tableSpans.get(6).text());
				
				//System.out.println(numbers.toString());
				
				tirages.put(date, numbers);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return tirages;
		
	}
	
		
		

}
