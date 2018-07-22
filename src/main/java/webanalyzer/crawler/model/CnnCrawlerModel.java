package webanalyzer.crawler.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.List;

@Component
public class CnnCrawlerModel {

    public List<Article> crawl(String url) throws IOException {
        List<Article> articles = new LinkedList();

        try {
            Document text = Jsoup.connect(url).get();
            Elements newsHeadlines = text.select("a");
            for (int i = 0; i < newsHeadlines.size(); i++) {
                if (newsHeadlines.get(i).attr("href").contains("news") && !newsHeadlines.get(i).attr("href").contains("http")) {
                    System.out.println("https://www.bbc.com" + newsHeadlines.get(i).attr("href"));
                    Document child = Jsoup.connect("https://www.bbc.com" + newsHeadlines.get(i).attr("href")).get();
                    System.out.println(child.select("img"));
                    articles.add(new Article(child.text(),"https://www.bbc.com" + newsHeadlines.get(i).attr("href")));
                }
            }
        } catch (SocketTimeoutException e) {
            System.out.println("err");
        }
        return articles;
    }
}
