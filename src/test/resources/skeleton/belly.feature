Feature: Belly

  Background: Empty belly
    Given I have 0 cakes in my belly


  Scenario: many cakes
    When I eat 42 cakes
    And I wait 2 hours
    Then my belly will growl

  Scenario: few cakes
    When I eat 20 cakes
    And I wait 2 hours
    Then my belly will not growl

  Scenario: many beers
    When I drink 5 beers
    And I wait 2 hours
    Then I will burp

  Scenario: few beers
    When I drink 2 beers
    And I wait 2 hours
    Then I will not burp
