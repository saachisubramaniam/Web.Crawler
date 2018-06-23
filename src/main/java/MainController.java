import crawlers.model.Crawler;
import crawlers.model.JSoupCrawler;
import crawlers.model.StandardCrawler;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;

@Controller
@EnableAutoConfiguration
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    String index() throws IOException {
        Crawler standardCrawler = new StandardCrawler();
        String crawlresult = standardCrawler.crawl("https://edition.cnn.com");




        //https://github.com/yasserg/crawler4j
        //https://github.com/yasserg/crawler4j/tree/master/crawler4j-examples/crawler4j-examples-base/src/test/java/edu/uci/ics/crawler4j/examples/basic
        return crawlresult;
    }

    @RequestMapping("/sayGood")
    @ResponseBody
    String index2() {
        //https://github.com/yasserg/crawler4j
        //https://github.com/yasserg/crawler4j/tree/master/crawler4j-examples/crawler4j-examples-base/src/test/java/edu/uci/ics/crawler4j/examples/basic
        return "bye";
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
            }
        };
    }

    public static void main(String[] args) {

        SpringApplication.run(MainController.class, args);
    }
}