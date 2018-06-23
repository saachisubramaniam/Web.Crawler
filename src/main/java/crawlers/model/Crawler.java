package crawlers.model;

import java.io.IOException;

public interface Crawler {
    String crawl (String url) throws IOException;
}
