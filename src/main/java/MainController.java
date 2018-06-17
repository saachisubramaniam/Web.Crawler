import crawlers.HTTPWebsiteCrawer;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.url.WebURL;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    String index() {
        //https://github.com/yasserg/crawler4j
        //https://github.com/yasserg/crawler4j/tree/master/crawler4j-examples/crawler4j-examples-base/src/test/java/edu/uci/ics/crawler4j/examples/basic
        return "";
    }

    public static void main(String[] args) {
        SpringApplication.run(MainController.class, args);
    }
}