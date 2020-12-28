package com.vance.springbootcucumber.frictionless;

import io.cucumber.java.en.Given;
import com.vance.springbootcucumber.commons.HttpClient;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FrictionlessDefinitions {

  private final HttpClient httpClient;

  private String acctNumber;
  private Map aRes;

  public FrictionlessDefinitions(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  @Given("^卡號:(\\w+)$")
  public void setup(final String acctNumber) {
    this.acctNumber = acctNumber;
  }

  @When("^使用此卡號進行交易$")
  public void do_transaction() throws Exception {
    Map aReq = new LinkedHashMap();
    aReq.put("acctNumber", acctNumber);
    aRes = httpClient.doAReq(aReq);
  }

  @Then("^交易結果:transStatus=(\\w+)$")
  public void the_transaction_should_be_frictionless(final String expectedTransStatus) {
    assertThat(expectedTransStatus.equals(aRes.get("transStatus"))).isTrue();
  }
}
