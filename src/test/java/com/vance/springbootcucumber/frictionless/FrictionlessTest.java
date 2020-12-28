package com.vance.springbootcucumber.frictionless;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/frictionless",
        plugin = {"pretty", "html:target/cucumber/bagbasics"})
public class FrictionlessTest {
}
