package webanalyzer.crawler.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import webanalyzer.crawler.model.Article;
import webanalyzer.crawler.model.CnnCrawlerModel;

import java.io.IOException;
import java.util.List;

@RestController
public class CnnCrawlerController {

    @Autowired
    CnnCrawlerModel cnnCrawlerModel;

    @RequestMapping("/cnn/content")
    @ResponseBody
    List<Article> getCnnContent() throws IOException {
        return cnnCrawlerModel.crawl("https://www.bbc.com/news");
    }


}