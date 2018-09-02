package webanalyzer.crawler.model;

public class Article {

    public String content;
    public String id;
    public String imageUrl;

    public Article() {

    }

    public Article(String content, String id, String imageUrl) {
        this.content = content;
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
