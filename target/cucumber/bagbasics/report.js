$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/NotAuthentication/ExistsInBlackListPan.feature");
formatter.feature({
  "name": "Frictionless",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "卡號存在黑名單(Pan)，交易結果為NotAuthentication(N)",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "卡號:4242424242424242",
  "keyword": "Given "
});
formatter.match({
  "location": "NotAuthenticationDefinitions.setup(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "使用此卡號進行交易",
  "keyword": "When "
});
formatter.match({
  "location": "NotAuthenticationDefinitions.do_transaction()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "交易結果:transStatus\u003dN",
  "keyword": "Then "
});
formatter.match({
  "location": "NotAuthenticationDefinitions.the_transaction_should_be_frictionless(String)"
});
formatter.result({
  "status": "passed"
});
}); "name": "卡號存在黑名單(Pan)，交易結果為NotAuthentication(N)",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "卡號:4242424242424242",
  "keyword": "Given "
});
formatter.match({
  "location": "FrictionlessDefinitions.setup(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "使用此卡號進行交易",
  "keyword": "When "
});
formatter.match({
  "location": "FrictionlessDefinitions.do_transaction()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "交易結果:transStatus\u003dN",
  "keyword": "Then "
});
formatter.match({
  "location": "FrictionlessDefinitions.the_transaction_should_be_frictionless(String)"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: expected:\u003c[tru]e\u003e but was:\u003c[fals]e\u003e\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat com.vance.springbootcucumber.frictionless.FrictionlessDefinitions.the_transaction_should_be_frictionless(FrictionlessDefinitions.java:42)\n\tat ✽.交易結果:transStatus\u003dN(file:src/test/resources/features/frictionless/NotExistsInBlackListPan.feature:11)\n",
  "status": "failed"
});
});