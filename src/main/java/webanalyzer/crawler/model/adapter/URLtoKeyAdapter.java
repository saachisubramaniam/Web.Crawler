package webanalyzer.crawler.model.adapter;

public class URLtoKeyAdapter {

    public String adapt(String url) {
        return url.replaceAll("[^a-zA-Z]+", "_");
    }
}
