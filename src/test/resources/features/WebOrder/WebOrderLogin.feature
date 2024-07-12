@regressionWebOrder
Feature: Testing adding product functionality

  Scenario: Happy Path Product Addition Functionality

    Given User provides 'Tester' and 'test' to the Sing In box
    When User clicks Order and chooses 'MyMoney' and '10' provides product information
    Then User provides Address Information 'Axel','857 Beau Dr','Des Plaines','IL','60016'
    And User provides payment Information and clicks process 'visa','12223344','08/26'
    And validate that the product was added in the view all orders section 'Axel','MyMoney','10','857 Beau Dr','Des Plaines','IL','60016','Visa', '12223344','08/26'.



 Scenario Outline: Happy Path Product Addition Functionality with multiple data.

    Given User provides '<username>' and '<password>' to the Sing In box
    When User clicks Order and chooses '<productName>' and '<quantity>' provides product information
    Then User provides Address Information '<name>','<street>','<city>','<state>','<zip>'
    And User provides payment Information and clicks process '<cardType>','<cardNumber>','<expirationDate>'
    And validate that the product was added in the view all orders section '<name>','<productName>','<quantity>','<street>','<city>','<state>','<zip>','<cardType>', '<cardNumber>','<expirationDate>'.
    Examples:
   |username|password|productName   |quantity|name|street     |city       |state|zip  |cardType        |cardNumber|expirationDate|
   |Tester  |test     |MyMoney      |4       |Axel|857 Beau Dr|Des Plaines|IL   |60016|Visa            |123345546 |11/27         |
   |Tester  |test     |FamilyAlbum  |4       |Axel|857 Beau Dr|Des Plaines|IL   |60016|MasterCard      |123345546 |11/27         |
   |Tester  |test     |ScreenSaver  |4       |Axel|857 Beau Dr|Des Plaines|IL   |60016|American Express|123345546 |11/27         |



