package io.specto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController()
@RequestMapping("/api/v1/recommendations")
public class RecommendationsController {

    @RequestMapping(method = GET)
    public Recommendation getRecommendation() {
        String[] locationSelection = {"London", "New York", "Beijing", "Tokyo"};
        String location = locationSelection[new Random().nextInt(locationSelection.length)];
        return  new Recommendation(location);
    }
}
