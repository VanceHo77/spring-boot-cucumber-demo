package com.vance.springbootcucumber.not_authentication;

import com.vance.springbootcucumber.commons.HttpClient;
import com.vance.springbootcucumber.entity.BlackListPan;
import com.vance.springbootcucumber.entity.PanInfo;
import com.vance.springbootcucumber.repository.BlackListPanRepository;
import com.vance.springbootcucumber.repository.PanInfoRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NotAuthenticationDefinitions {

  private final PanInfoRepository panInfoRepo;
  private final BlackListPanRepository blackListPanRepo;

  private final HttpClient httpClient;

  private String acctNumber;
  private Map aRes;

  public NotAuthenticationDefinitions(
      PanInfoRepository panInfoRepo,
      BlackListPanRepository blackListPanRepo,
      HttpClient httpClient) {
    this.panInfoRepo = panInfoRepo;
    this.blackListPanRepo = blackListPanRepo;
    this.httpClient = httpClient;
  }

  @Given("^卡號:(\\w+)$")
  public void setup(final String acctNumber) {
    this.acctNumber = acctNumber;

    PanInfo panInfo = panInfoRepo.findByCardNumber(acctNumber).orElse(null);
    if (panInfo == null) {
      // Save panInfo
      panInfo = new PanInfo();
      panInfo.setCardNumber(acctNumber);
      panInfo = panInfoRepo.save(panInfo);
      log.info("[setup] save panInfo");
    }
    boolean isExistsInBlacklistPan = blackListPanRepo.findByPanInfoId(panInfo.getId()).isPresent();
    if(!isExistsInBlacklistPan) {
      BlackListPan blackListPan = new BlackListPan();
      blackListPan.setPanInfoId(panInfo.getId());
      blackListPan.setTransStatus("N");
      blackListPanRepo.save(blackListPan);
      log.info("[setup] save blackListPan");
    }
  }

  @When("^使用此卡號進行交易$")
  public void do_transaction() throws Exception {
    Map aReq = new LinkedHashMap();
    aReq.put("acctNumber", acctNumber);
    aRes = httpClient.doAReq(aReq);
  }

  @Then("^交易結果:transStatus=(\\w+)$")
  public void the_transaction_should_be_frictionless(final String expectedTransStatus_N) {
    assertThat(expectedTransStatus_N.equals(aRes.get("transStatus"))).isTrue();
  }
}
