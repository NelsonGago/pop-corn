package ng.loto.util;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Collects the numbers from a given source
 * @author Nelson
 *
 */
public class NumberCollector {
	
	
	
	public static void main(String[] args)  {
		
		NumberCollector nc = new NumberCollector();
		nc.getQuebec49TirageNumbers(2017);

	}
	
	
	public Map<String, Integer[]>  getQuebec49TirageNumbers(int pYear)  {
		
		String mainURl = "https://loteries.espacejeux.com/fr/loteries/quebec-49?annee="+pYear+"&widget=resultats-anterieurs&noProduit=214#res";
		
		Map<String, Integer[]> tirages =  new HashMap<String, Integer[]>();
		
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
			
			// Start the csv writing			
		   // String csvFile = "C:\\DEV\\Eclipse-Workspaces\\NGLotoStat\\src\\data\\Quebec49_"+pYear+".csv";
	       // FileWriter writer = new FileWriter(csvFile);


			// Now for each table row, get the numbers
			// List<String> entriesForCSV = null;
			for (Element tableRow: tableRows) {
				
				String date = tableRow.getElementsByClass("date").text();
				Elements tableSpans = table.getElementsByTag("span");
				
				/*
				entriesForCSV =  new ArrayList<String>();
				entriesForCSV.add(date);
				entriesForCSV.add(tableSpans.get(0).text());
				entriesForCSV.add(tableSpans.get(1).text());
				entriesForCSV.add(tableSpans.get(2).text());
				entriesForCSV.add(tableSpans.get(3).text());
				entriesForCSV.add(tableSpans.get(4).text());
				entriesForCSV.add(tableSpans.get(5).text());
				entriesForCSV.add(tableSpans.get(6).text());
				
			    CSVWritter.writeLine(writer, entriesForCSV);
				*/
				
				/*
				//System.out.println(date);
				int [] numbers = new int[7];
				// get the seven numbers;
				numbers[0] = Integer.parseInt(tableSpans.get(0).text());
				numbers[1] = Integer.parseInt(tableSpans.get(1).text());
				numbers[2] = Integer.parseInt(tableSpans.get(2).text());
				numbers[3] = Integer.parseInt(tableSpans.get(3).text());
				numbers[4] = Integer.parseInt(tableSpans.get(4).text());
				numbers[5] = Integer.parseInt(tableSpans.get(5).text());
				numbers[6] = Integer.parseInt(tableSpans.get(6).text());
				
				tirages.put(date, numbers);
				*/
				//System.out.println(numbers.toString());
				
				tirages.put(date,  new Integer[] {Integer.parseInt(tableSpans.get(0).text()),
						                      Integer.parseInt(tableSpans.get(1).text()), 
						                      Integer.parseInt(tableSpans.get(2).text()),
						                      Integer.parseInt(tableSpans.get(3).text()),
						                      Integer.parseInt(tableSpans.get(4).text()),
						                      Integer.parseInt(tableSpans.get(5).text()),
						                      Integer.parseInt(tableSpans.get(6).text())});

				
			}
			
/*
	        writer.flush();
	        writer.close();
*/
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return tirages;
		
	}
	
		
		

}
