package crawlers.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JSoupCrawler implements Crawler{

    @Override
    public String crawl(String url) throws IOException {
        Document text = Jsoup.connect(url).get();
        Elements newsHeadlines = text.getElementsByClass("l-container");
        return (Jsoup.parse(newsHeadlines.toString()).text());
    }
}
