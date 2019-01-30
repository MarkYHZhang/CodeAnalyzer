package commentanalyzer;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value = "/submit/", method = RequestMethod.POST)
    public CommentResponse sayHello(@RequestBody CommentRequest request) {
        return CommentAnalyzer.analyze(request);
    }

}