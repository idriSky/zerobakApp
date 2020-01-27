$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/FindTransactions.feature");
formatter.feature({
  "name": "Find Transactions in Account Activity",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@findTransactions"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on the Login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefs.the_user_is_on_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in with valid credentials username \"username\" and password \"password\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefs.the_user_logs_in_with_valid_credentials_username_and_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to \"Account Activity\" module",
  "keyword": "And "
});
formatter.match({
  "location": "AccountSummaryStepDefs.the_user_navigates_to_module(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to \"Find Transactions\" module",
  "keyword": "And "
});
formatter.match({
  "location": "AccountSummaryStepDefs.the_user_navigates_to_module(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Search date range",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@findTransactions"
    },
    {
      "name": "@dateRange"
    }
  ]
});
formatter.step({
  "name": "the user enters date range from \"2012-09-01\" to \"2012-09-06\"",
  "keyword": "When "
});
formatter.match({
  "location": "AccountActivityStepDefs.the_user_enters_date_range_from_to(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on \"Find\" link on the Account Activity page",
  "keyword": "And "
});
formatter.match({
  "location": "AccountActivityStepDefs.the_user_clicks_on_link_on_the_page(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the results table should only show transactions dates between \"2012-09-01\" to \"2012-09-06\"",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountActivityStepDefs.the_results_table_should_only_show_transactions_dates_between_to(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the results should be sorted by most recent date",
  "keyword": "And "
});
formatter.match({
  "location": "AccountActivityStepDefs.the_results_should_be_sorted_by_most_recent_date()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user enters date range from \"2012-09-02\" to \"2012-09-06\"",
  "keyword": "When "
});
formatter.match({
  "location": "AccountActivityStepDefs.the_user_enters_date_range_from_to(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on \"Find\" link on the Account Activity page",
  "keyword": "And "
});
formatter.match({
  "location": "AccountActivityStepDefs.the_user_clicks_on_link_on_the_page(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the results table should only show transactions dates between \"2012-09-02\" to \"2012-09-06\"",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountActivityStepDefs.the_results_table_should_only_show_transactions_dates_between_to(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the results table should only not contain transactions dated \"2012-09-01\"",
  "keyword": "And "
});
formatter.match({
  "location": "AccountActivityStepDefs.the_results_table_should_only_not_contain_transactions_dated(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});