package skeleton;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

import static org.junit.Assert.*;


public class Stepdefs {
    Belly belly = null;


    @Given("^I have (\\d+) cakes in my belly$")
    public void I_have_cakes_in_my_belly(int cakes) throws Throwable {
        belly = new Belly();
        belly.eat(cakes, Belly.Edibles.CAKE);
    }

    @When("I eat {int} cakes")
    public void i_eat_cakes(Integer int1) {
      belly.eat(int1, Belly.Edibles.CAKE);
    }

    @When("I drink {int} beers")
    public void i_drink_beer(Integer int1) {
      belly.eat(int1, Belly.Edibles.BEER);
    }


    @When("I wait {int} hours")
    public void i_wait_hour(Integer int1) {
      belly.wait(int1);
    }


    @Then("my belly will growl")
    public void my_belly_will_growl() {
     assertTrue(belly.getIsPerformingAction("growl"));
    }

    @Then("my belly will not growl")
    public void my_belly_will_not_growl() {
     assertFalse(belly.getIsPerformingAction("growl"));
    }

    @Then("I will burp")
    public void i_will_burp() {
     assertTrue(belly.getIsPerformingAction("burp"));
    }

    @Then("I will not burp")
    public void i_will_not_burp() {
     assertFalse(belly.getIsPerformingAction("burp"));
    }

    @Then("I will be sick")
    public void i_will_be_sick() {
     assertTrue(belly.getIsSick());
    }

    @Then("I will be fine")
    public void i_will_be_fine() {
     assertFalse(belly.getIsSick());
    }
}
