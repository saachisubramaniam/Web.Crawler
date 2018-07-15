package webanalyzer.crawler.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CnnCrawlerModel {

    public String crawl(String url) throws IOException {
        Document text = Jsoup.connect(url).get();
        Elements newsHeadlines = text.getElementsByClass("gs-c-promo-heading__title");
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<newsHeadlines.size();i++) {
            builder.append(newsHeadlines.get(i)+"<br>");
        }
        return builder.toString();
    }
}
