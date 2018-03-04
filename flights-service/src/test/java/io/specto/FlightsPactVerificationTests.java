package io.specto;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.web.context.ConfigurableWebApplicationContext;

@RunWith(PactRunner.class)
@Provider("flights_provider")
@PactFolder("pacts")
public class FlightsPactVerificationTests {

    @TestTarget
    public final Target target = new HttpTarget("http", "localhost", 8081, "/");

    private static ConfigurableWebApplicationContext application;

    @BeforeClass
    public static void start() {
        application = (ConfigurableWebApplicationContext) SpringApplication.run(FlightsApplication.class);
    }

    @AfterClass
    public static void end() {
        application.close();
    }

    @State("test state")
    public void toGetState() {
    }
}
