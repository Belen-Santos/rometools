import java.util.stream.Stream;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

import java.net.URL;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class RomeTools {

	public static void main(String[] args) {
		boolean ok = false;
		/*
                String[][] ar = new String[][] {
                     { "elp", "http://ep00.epimg.net/rss/tags/ultimas_noticias.xml" },
                     { "cnn", "http://rss.cnn.com/rss/edition.rss" },
                     { "bbc", "http://feeds.bbci.co.uk/news/rss.xml" } };
	        */	
		// java >= 9
		
                Map<String, String> map = Map.of("elp","http://ep00.epimg.net/rss/tags/ultimas_noticias.xml",
			               	         "cnn","http://rss.cnn.com/rss/edition.rss",
                                                 "bbc","http://feeds.bbci.co.uk/news/rss.xml"); 
		
                // java >= 8
               
	       	/*Map<String, String> map = Stream.of(new String[][] {
                     { "elp", "http://ep00.epimg.net/rss/tags/ultimas_noticias.xml" },
                     { "bbc", "http://feeds.bbci.co.uk/news/rss.xml" },
                     { "cnn", "http://rss.cnn.com/rss/edition.rss" }
                }).collect(toMap(data -> data[0], data -> data[1])); */

		if (args.length == 1) {
			try {
				URL feedURL = new URL(map.get(args[0]));
				SyndFeedInput input = new SyndFeedInput();
				SyndFeed feed = input.build(new XmlReader(feedURL));

				for (SyndEntry entry : feed.getEntries()) {
					System.out.println("\n" + entry.getTitle());
				}
				/*
				System.out.println("\n\nArray [0][1]: " + ar[0][1]);
				System.out.println("\n\nArray [1][0]: " + ar[1][0]);
				*/

				ok = true;
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("ERROR: " + ex.getMessage());
			}
		}
		if (!ok) {
			System.out.println("Usage: one argument with any of the values [ elp cnn bbc ]");
		}

	}
}
