package webanalyzer.crawler.model;

public class Article {

    public String articleText;
    public String articleUrl;
    public String imageUrl;


    public Article(String articleText, String articleUrl, String imageUrl) {
        this.articleText = articleText;
        this.articleUrl = articleUrl;
        this.imageUrl = imageUrl;
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


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
