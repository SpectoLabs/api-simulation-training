package io.specto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Flight {

    private final String origin;
    private final String destination;
    private final BigDecimal cost;
    private final LocalDateTime when;


    public Flight(final String origin, final String destination, final BigDecimal cost, final LocalDateTime when) {
        this.origin = origin;
        this.destination = destination;
        this.cost = cost;
        this.when = when;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getCost() {
        return cost.toString();
    }

    public String getWhen() {
        return when.toString();
    }
}
