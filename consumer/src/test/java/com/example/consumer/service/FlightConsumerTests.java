package com.example.consumer.service;

import com.example.consumer.model.Flight;
import io.specto.hoverfly.junit.core.HoverflyConfig;
import io.specto.hoverfly.junit.rule.HoverflyRule;
import org.junit.ClassRule;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static io.specto.hoverfly.junit.core.SimulationSource.classpath;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;


public class FlightConsumerTests {

    private RestTemplate restTemplate = new RestTemplate();

    @ClassRule
    public static HoverflyRule hoverflyRule = HoverflyRule.inSimulationMode(classpath("correct_flight_simulation.json"), HoverflyConfig.localConfigs().proxyLocalHost());

    private FlightConsumer flightConsumer = new FlightConsumer(restTemplate);

    @Test
    public void test() {
        //arrange

        //act
        List<Flight> flights = flightConsumer.getAvailableFlights();

        //assert
        assertThat(flights, hasSize(4));
        assertThat(flights.get(0).getOrigin(), is("Milan"));
        assertThat(flights.get(0).getDestination(), is("Dubai"));
    }
}
