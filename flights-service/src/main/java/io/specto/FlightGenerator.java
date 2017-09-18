package io.specto;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;
import static java.math.RoundingMode.HALF_UP;

@Component
public class FlightGenerator {

    private static final List<String> origins = newArrayList("London", "Milan", "Paris", "Amsterdam", "Berlin");
    private static final List<String> destinations = newArrayList("New York", "Tokyo", "Dubai", "Boston", "Bangkok");

    private final Random random = new Random();

    public Flight generate(final int plusDays) {
        final String origin = origins.get(random.nextInt(origins.size()));
        final String destination = destinations.get(random.nextInt(destinations.size()));

        double doublePrice = 30 + (5000 - 30) * random.nextDouble();
        final BigDecimal price = new BigDecimal(doublePrice).setScale(2, HALF_UP);

        final LocalDateTime now = LocalDateTime.now().plusDays(plusDays);
        int randomHour = random.nextInt(24);
        int randomMinute = random.nextInt(60);

        final LocalDateTime at = now.withHour(randomHour).withMinute(randomMinute);

        return new Flight(origin, destination, price, at);
    }
}
