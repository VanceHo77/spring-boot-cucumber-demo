Feature: Frictionless

  Scenario: 卡號不存在黑名單(Pan)，交易結果為frictionless(Y)
    Given 卡號:4242424242424242
    When 使用此卡號進行交易
    Then 交易結果:transStatus=Y

  Scenario: 卡號存在黑名單(Pan)，交易結果為NotAuthentication(N)
    Given 卡號:4242424242424242
    When 使用此卡號進行交易
    Then 交易結果:transStatus=N