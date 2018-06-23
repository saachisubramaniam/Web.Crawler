package crawlers.model;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;




public class StandardCrawler implements Crawler {

    private final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

    Connection connection = Jsoup.connect("http://www.example.com");
    Document htmlDocument = connection.get();
    Elements linksOnPage = htmlDocument.select("a[href]") ;
    private List<String> links = new LinkedList<String>();

    public StandardCrawler() throws IOException {
    }


    @Override
    public String crawl(String url)
    {
        try
        {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;
            //System.out.println( htmlDocument);
            if(connection.response().statusCode() == 200) // 200 is the HTTP OK status code
            // indicating that everything is great.
            {
                //System.out.println("\n** Visiting** Received web page at " + url);

                //return htmlDocument.toString();
            }
            if(!connection.response(). contentType().contains("text/ html"))
            {
                //System.out.println("**Failure* * Retrieved something other than HTML");
            }
            Elements linksOnPage = htmlDocument.select("a[href]") ;
            System.out.println("Found (" + linksOnPage.size() + ") links");
            for(Element link : linksOnPage)
            {

                this.links.add(link.absUrl(" href"));
                System.out.println(link.absUrl(" href"));
            }
            return "";
        }
        catch(IOException ioe)
        {
            // We were not successful in our HTTP request
            return "";
        }
    }
}
