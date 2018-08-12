package webanalyzer.crawler.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class DependencyController {

    DependencyExcersice dependencyExcersice;

    @RequestMapping("/sayhi")
    @ResponseBody
    String sayHi() {
        return dependencyExcersice.sayHi();
    }

}
