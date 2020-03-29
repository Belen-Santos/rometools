package aplicandoLibreria;

import java.net.URL;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class RomeTools {

	public static void main(String[] args) {
		boolean ok = false;

		if (args.length == 1) {
			try {
				URL feedURL = new URL(args[0]);
				SyndFeedInput input = new SyndFeedInput();
				SyndFeed feed = input.build(new XmlReader(feedURL));

				for (SyndEntry entry : feed.getEntries()) {
					System.out.println("\n" + entry.getTitle());
				}

				ok = true;
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("ERROR: " + ex.getMessage());
			}
		}
		if (!ok) {
			System.out.println("An error ocurred: the first parameter must be the URL of the feed to read.");
		}

	}
}
