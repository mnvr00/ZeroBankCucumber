@payBills @All
Feature: Pay Bills
    
    Background: 
      Given the user on the login page
      When the user enter valid username and password
      And the user click "Pay Bills" module
      
  Scenario: Page Title
    Then page should have the title "Zero - Pay Bills"

  Scenario Outline:Successfully Pay Operation
    Then the user should be able to complete and The payment was successfully submitted. should be displayed  with "<Payee>" "<Account>" "<Amount>" "<Date>" "<Description>"
    Examples:
      |Payee          |Account    |Amount|Date      |Description|
      |Bank Of America|Credit Card|500   |2022-02-16|school fee |

   Scenario Outline:without entering the amount or date
     Then the user should get warning message with "<Payee>" "<Account>" "<Amount>" "<Date>" "<Description>"
     Examples:
       |Payee          |Account    |Amount|Date      |Description|
       |Bank Of America|Credit Card|  400 |          |school fee |
       |Bank Of America|Credit Card|      |2022-02-16|school fee |
     Scenario Outline: Amount field and dade field should not accept alphabetical or special characters.
       Then System should not accept alphabetical or special characters for date and amount fields with "<Payee>" "<Account>" "<Amount>" "<Date>" "<Description>"

       Examples:
         |Payee          |Account    |Amount |Date       |Description|
         |Bank Of America|Credit Card|600    |2022-02-16 |school fee |
         |Bank Of America|Credit Card|$$%*@  |2022-02-16 |school fee |



