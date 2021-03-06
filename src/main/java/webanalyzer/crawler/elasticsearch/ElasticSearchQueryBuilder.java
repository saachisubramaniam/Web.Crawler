package webanalyzer.crawler.elasticsearch;

import webanalyzer.crawler.model.Article;

public class ElasticSearchQueryBuilder {

    private int from = 0;
    private String searchWith;
    private int size;


    public String getAddANewArticleQuery(Article article) {
        return "{\n" +
                "\"content\":\"" + article.getContent() + "\",\n" +
                "\"id\":\"" + article.getId() + "\",\n" +
                "\"imageURL\": \"" + article.getImageUrl() + "\"\n" +
                "}";
    }


}
