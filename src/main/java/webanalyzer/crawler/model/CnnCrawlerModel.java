package webanalyzer.crawler.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import javax.swing.plaf.synth.SynthScrollBarUI;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CnnCrawlerModel {

    Map<String, Article> cache  = new ConcurrentHashMap();

    public List<Article> crawl(String url) throws IOException {
        List<Article> articles = new LinkedList();

        try {
            Document text = Jsoup.connect(url).get();
            Elements newsHeadlines = text.select("a");
            for (int i = 0; i < newsHeadlines.size(); i++) {
                if (newsHeadlines.get(i).attr("href").contains("news") && !newsHeadlines.get(i).attr("href").contains("http")) {
                    String articleUrl = "https://www.bbc.com" + newsHeadlines.get(i).attr("href");
                    System.out.println(articleUrl);
                    
                    //if we dont have in the cache if(cache.get("URL"))
                    Document child = Jsoup.connect(articleUrl).get();
                    String imageUrl = child.select("img").attr("src");
                    System.out.println(imageUrl);
                    Article article = new Article(child.text(),articleUrl, imageUrl);
                    cache.put(article.articleUrl, article);
                    articles.add(article);

//                else
//                    articles.add(cache.get("URL");
                }
            }

        } catch (SocketTimeoutException e) {
            System.out.println("err");
        }
        return articles;
    }
}
