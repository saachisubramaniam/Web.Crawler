package webanalyzer.crawler.model;

public class Article {

    public String articleText;
    public String articleUrl;
    public String articlePicture;


    public Article(String articleText, String articleUrl, String articlePicture) {
        this.articleText = articleText;
        this.articleUrl = articleUrl;
        this.articlePicture = articlePicture;
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


    public String getArticlePicture() {
        return articlePicture;
    }

    public void setArticlePicture(String articlePicture) {
        this.articlePicture = articlePicture;
    }
}
