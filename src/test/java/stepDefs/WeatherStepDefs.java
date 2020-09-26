package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WeatherStepDefs {
    private String city;
    private String country;


    @Given("city is: {String}")
    public void set_city(String city){
        this.city = city;
    }
    @Given("country is: {String}")
    public void set_country(String country){
       this.country = country.toLowerCase();
    }
    @When("we are reqesting data")
    public void request_weather(){

    }
    @Then("lon is: {double}")
    public void check_lon(Double lon){

    }
    @Then("lat is: {double}")
    public void check_lat(Double lat){

    }
    @Then("weather id is: {int}")
    public void check_weather(int weather){

    }
    @Then("main is: {string}")
    public void check_main(String main){

    }
    @Then("description is: {string}")
    public void check_description(String description){

    }
    @Then("icon is: {string}")
    public void check_icon(String icon){

    }
    @Then("base is: {string}")
    public void check_base(String base){

    }
    @Then("temp is: {double}")
    public void check_temp(Double temp){

    }
    @Then("pressure is: {int}")
    public void check_pressure(int pressure){

    }
    @Then("humidity is: {int}")
    public void check_humidity(int humidity){

    }
    @Then("temp_min is: {double}")
    public void check_temp_min(Double temp_min){

    }
    @Then("temp_max is: {double}")
    public void check_temp_max(Double temp_max){

    }
    @Then("visibility is: {int}")
    public void check_visibility(int visibility){

    }
    @Then("speed is: {double}")
    public void check_speed(Double speed){

    }
    @Then("deg is: {int}")
    public void check_deg(int deg){

    }
    @Then("all is: {int}")
    public void check_all(int all){

    }
    @Then("dt is: {int}")
    public void check_dt(int dt){

    }
    @Then("type is: {int}")
    public void check_type(int type){

    }
    @Then("sys_id is: {int}")
    public void check_sys_id(int sys_id){

    }
    @Then("message is: {double}")
    public void check_message(Double message){

    }
    @Then("country is: {string}")
    public void check_country(String country){

    }
    @Then("sunrise is: {int}")
    public void check_sunrise(int sunrise){

    }
    @Then("sunset is: {int}")
    public void check_sunset(int sunset){

    }
    @Then("id is: {int}")
    public void check_id(int id){

    }
    @Then("name is: {string}")
    public void check_name(String name){

    }
    @Then("cod is: {int}")
    public void check_cod(int cod){

    }




}
