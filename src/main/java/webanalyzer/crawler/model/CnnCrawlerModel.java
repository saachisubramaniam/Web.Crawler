package webanalyzer.crawler.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import webanalyzer.crawler.elasticsearch.ElasticSearchClient;
import webanalyzer.crawler.elasticsearch.ElasticSearchQueryBuilder;
import webanalyzer.crawler.model.adapter.URLtoKeyAdapter;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CnnCrawlerModel {

    Map<String, Article> cache = new ConcurrentHashMap();

    public List<Article> crawl(String url) throws IOException {
        List<Article> articles = new LinkedList();

        try {
            Document text = Jsoup.connect(url).get();
            Elements newsHeadlines = text.select("a");
            for (int i = 0; i < newsHeadlines.size(); i++) {
                if (newsHeadlines.get(i).attr("href").contains("news") && !newsHeadlines.get(i).attr("href").contains("http")) {
                    String articleUrl = "https://www.bbc.com" + newsHeadlines.get(i).attr("href");


                    try {
                        Response result = (new ElasticSearchClient()).executeOn(new RestTemplate()).executeGet("articles/_doc/" + (new URLtoKeyAdapter()).adapt(articleUrl));
                        System.out.println(result._source.getId());

                    } catch (HttpClientErrorException e) {
                        Document child = Jsoup.connect(articleUrl).get();
                        String imageUrl = child.select("img").attr("src");
                        System.out.println(imageUrl);
                        Article article = new Article(child.text().replaceAll("\"", "'"), articleUrl, imageUrl);
                        cache.put(article.id, article);
                        articles.add(article);
                        if (article.id != null && article.id.length() > 3)
                            (new ElasticSearchClient()).executeOn(new RestTemplate()).executeQuery("articles/_doc/" + (new URLtoKeyAdapter()).adapt(article.id), (new ElasticSearchQueryBuilder()).getAddANewArticleQuery(article));
                    }

                }
            }
        } catch (SocketTimeoutException e) {
            System.out.println("err");
        }
        return articles;
    }
}
