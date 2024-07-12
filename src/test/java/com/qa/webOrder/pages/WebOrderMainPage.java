package com.qa.webOrder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class WebOrderMainPage {
    public WebOrderMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[.='Order']")
    WebElement orderButton;
    @FindBy(xpath = "//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")
    WebElement product;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")
    WebElement quantity;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement name;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zip;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_0")
    WebElement paymentType;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_1")
    WebElement cardTypeMasterCard;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_2")
    WebElement cardTypeAmericanExpress;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expiration;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;
    @FindBy(xpath = "//a[.='View all orders']")
    WebElement viewAllOrdersButton;
    @FindBy(xpath = "//tbody//tr[2]//td")
    List<WebElement> allFieldsOrder;


    public void AddNewProduct(String product, String quantity){
        orderButton.click();
        BrowserUtils.selectBy(this.product, product, "text");
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
    }
    public void addressInfo(String name, String street, String city, String state, String zip){
        this.name.sendKeys(name);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zip.sendKeys(zip);
    }
    public void paymentInfo( String cardNumber, String expirationDate,String cardType ) throws InterruptedException {
       cardType = cardType.toLowerCase();
        switch (cardType){
            case "mastercard":
                cardTypeMasterCard.click();
                break;
            case "american express":
                cardTypeAmericanExpress.click();
                break;
            default:
                paymentType.click();
        }
        this.cardNumber.clear();
        this.cardNumber.sendKeys(cardNumber);
        this.expiration.sendKeys(expirationDate);
        processButton.click();
        Thread.sleep(2000);
    }
    public void validateOrder(String name, String product, String number, String street, String city,
                              String state, String zip, String card, String cardNumber, String expirationDate){

        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentTime= dtf.format(now.plusDays(0));

        viewAllOrdersButton.click();
     List<String> OrderInfo= Arrays.asList(name, product, number, currentTime, street, city,
             state,zip,card,cardNumber, expirationDate);
     for (int index=1; index< allFieldsOrder.size()-1;index++){

         Assert.assertEquals( OrderInfo.get(index-1),BrowserUtils.getText(allFieldsOrder.get(index)));

     }
    }
}
