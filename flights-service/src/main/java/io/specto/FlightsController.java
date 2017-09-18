package io.specto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController()
@RequestMapping("/api/v1/flights")
public class FlightsController {

    private final FlightGenerator flightGenerator;
    private final Random random= new Random();

    @Autowired
    public FlightsController(final FlightGenerator flightGenerator) {
        this.flightGenerator = flightGenerator;
    }

    @RequestMapping(method = GET)
    public List<Flight> getFlights(@RequestParam(value = "plusDays", defaultValue = "0") int plusDays) {
        final int lowerbound = random.nextInt(2) + 2;
        final int upperbound = random.nextInt(3) + 4;
        return IntStream.range(lowerbound, upperbound).mapToObj(i -> flightGenerator.generate(plusDays)).collect(toList());
    }
}
