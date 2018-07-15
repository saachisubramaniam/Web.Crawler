package webanalyzer.crawler.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import webanalyzer.crawler.model.CnnCrawlerModel;

import java.io.IOException;

@Controller
public class CnnCrawlerController {

    @Autowired
    CnnCrawlerModel cnnCrawlerModel;

    @RequestMapping("/cnn/content")
    @ResponseBody
    String getCnnContent() throws IOException {
        String crawlresult = cnnCrawlerModel.crawl("https://www.bbc.com/news");

        return crawlresult;
    }


}