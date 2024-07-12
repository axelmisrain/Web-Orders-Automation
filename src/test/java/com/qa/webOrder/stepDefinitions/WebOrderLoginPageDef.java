package com.qa.webOrder.stepDefinitions;

import com.qa.webOrder.pages.WebOrderLoginPage;
import com.qa.webOrder.pages.WebOrderMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;




public class WebOrderLoginPageDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage(driver);
    WebOrderMainPage webOrderMainPage = new WebOrderMainPage(driver);

    @Given("User provides {string} and {string} to the Sing In box")
    public void user_provides_and_to_the_sing_in_box(String username, String password) throws InterruptedException {
        webOrderLoginPage.login(username, password);
    }
    @When("User clicks Order and chooses {string} and {string} provides product information")
    public void user_clicks_order_and_chooses_and_provides_product_information(String product, String quantity) {
        webOrderMainPage.AddNewProduct(product,quantity);
    }
    @Then("User provides Address Information {string},{string},{string},{string},{string}")
    public void user_provides_address_information(String name, String street, String city, String state, String zip) {
        webOrderMainPage.addressInfo(name,street,city,state,zip);
    }
    @Then("User provides payment Information and clicks process {string},{string},{string}")
    public void user_provides_payment_information_and_clicks_process(String cardType, String cardNumber, String expirationDate) throws InterruptedException {
        webOrderMainPage.paymentInfo(cardNumber,expirationDate,cardType);
    }
    @Then("validate that the product was added in the view all orders section {string},{string},{string},{string},{string},{string},{string},{string}, {string},{string}.")
    public void validate_that_the_product_was_added_in_the_view_all_orders_section(String name, String product, String number, String street, String city,
                                                                                   String state, String zip,
                                                                                   String card, String cardNumber, String expirationDate) {

        webOrderMainPage.validateOrder(name, product, number, street, city, state, zip, card, cardNumber, expirationDate);
    }


}
