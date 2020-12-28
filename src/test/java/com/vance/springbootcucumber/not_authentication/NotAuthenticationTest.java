package com.vance.springbootcucumber.not_authentication;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/NotAuthentication",
        plugin = {"pretty", "html:target/cucumber/bagbasics"})
public class NotAuthenticationTest {
}
