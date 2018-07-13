package webanalyzer.crawler.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CnnCrawlerModel {

    public String crawl(String url) throws IOException {
        Document text = Jsoup.connect(url).get();
        return text.toString();
    }
}
