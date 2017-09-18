package io.specto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController()
@RequestMapping("/management")
public class ManagementController {

    private final FlightGenerator flightGenerator;
    private final Random random= new Random();

    @Autowired
    public ManagementController(final FlightGenerator flightGenerator) {
        this.flightGenerator = flightGenerator;
    }

    @RequestMapping(method = GET, path = "/kill")
    public void kill() {
        System.exit(0);
    }

    @RequestMapping(method = GET, path = "/health")
    @ResponseStatus(OK)
    public void health() {}
}
