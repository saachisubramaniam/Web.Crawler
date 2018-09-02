package webanalyzer.crawler.model;

public class Response {

    Boolean found;
    String _index;
    Article _source;
    String _type;
    String _id;

    public Article get_source() {
        return _source;
    }

    public void set_source(Article article) {
        this._source = article;
    }

    public Boolean getFound() {
        return found;
    }

    public void setFound(Boolean found) {
        this.found = found;
    }

    public String get_index() {
        return _index;
    }

    public void set_index(String _index) {
        this._index = _index;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
