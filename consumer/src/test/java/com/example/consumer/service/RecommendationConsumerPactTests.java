package com.example.consumer.service;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.example.consumer.model.Recommendation;
import com.google.common.collect.ImmutableMap;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class RecommendationConsumerPactTests {

//    @Rule
//    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("recommendation_provider", "localhost", 8081, this);

    private RestTemplate restTemplate = new RestTemplate();
    private RecommendationConsumer recommendationConsumer = new RecommendationConsumer(restTemplate);

//    @Pact(provider = "recommendation_provider", consumer = "recommendation_consumer")
//    public RequestResponsePact createPact(PactDslWithProvider builder) {
//        Map<String, String> headers = ImmutableMap.of("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//
//        return builder
//                .given("no particular state")
//                .uponReceiving("A request for recommendation")
//                .path("/api/v1/recommendations")
//                .method("GET")
//                .willRespondWith()
//                .status(200)
//                .headers(headers)
//                .body("{\"location\":\"London\"}")
//                .toPact();
//    }

//    @Test
//    @PactVerification("recommendation_provider")
//    public void runTest() {
//        Recommendation recommendation = recommendationConsumer.getRecommendation();
//
//        assertThat(recommendation.getLocation(), is(instanceOf(String.class)));
//    }
}
