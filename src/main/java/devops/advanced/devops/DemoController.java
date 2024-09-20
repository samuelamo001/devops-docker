package devops.advanced.devops;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

    @GetMapping("/home")
    public List<String> welcome() {
        List<String> welcomeMessages = new ArrayList<>();
        welcomeMessages.add("Welcome to the new world!");
        welcomeMessages.add("Explore the possibilities of Spring Boot.");
        welcomeMessages.add("Discover the power of DevOps.");
        welcomeMessages.add("Embrace the future of technology!");

        return welcomeMessages;
    }
}

