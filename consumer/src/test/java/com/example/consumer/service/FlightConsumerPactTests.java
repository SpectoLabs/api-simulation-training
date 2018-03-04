package com.example.consumer.service;


import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.example.consumer.model.Flight;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.ImmutableMap;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FlightConsumerPactTests {

    @Rule
    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("flights_provider", "localhost", 8081, this);

    private RestTemplate restTemplate = new RestTemplate();
    private FlightConsumer flightConsumer = new FlightConsumer(restTemplate);

    @Pact(provider = "flights_provider", consumer = "flights_consumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) throws JsonProcessingException {
        Map<String, String> headers = ImmutableMap.of("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        DslPart flightEntityList = PactDslJsonArray.arrayEachLike()
                .stringType("origin")
                .stringType("destination")
                .stringType("cost")
                .stringType("when")
                .closeObject();

        return builder
                .given("test state")
                .uponReceiving("A request for flights")
                .path("/api/v1/flights")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(flightEntityList)
                .toPact();
    }

    @Test
    @PactVerification("flights_provider")
    public void runTest() {
        List<Flight> flights = flightConsumer.getAvailableFlights();

        assertThat(flights.size(), is(1));
    }

}
