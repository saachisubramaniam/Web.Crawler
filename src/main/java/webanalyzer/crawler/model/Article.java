package webanalyzer.crawler.model;

public class Article {

    public String articleText;
    public String articleUrl;


    public Article(String articleText, String articleUrl) {
        this.articleText = articleText;
        this.articleUrl = articleUrl;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }
}
