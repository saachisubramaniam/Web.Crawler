package webanalyzer.crawler.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.SocketTimeoutException;

@Component
public class CnnCrawlerModel {

    public String crawl(String url) throws IOException {
        StringBuilder builder = new StringBuilder();

        try {
            Document text = Jsoup.connect(url).get();
            Elements newsHeadlines = text.select("a");
            for (int i = 0; i < newsHeadlines.size() - 20; i++) {
                if (newsHeadlines.get(i).attr("href").contains("news") && !newsHeadlines.get(i).attr("href").contains("http")) {
                    System.out.println("https://www.bbc.com" + newsHeadlines.get(i).attr("href"));
                    Document child = Jsoup.connect("https://www.bbc.com" + newsHeadlines.get(i).attr("href")).get();
                    builder.append("https://www.bbc.com" + newsHeadlines.get(i).attr("href"));
                    builder.append(child.text() + "<BR>");
                }
            }
        } catch (SocketTimeoutException e) {
            System.out.println("err");
        }
        return builder.toString();
    }
}
