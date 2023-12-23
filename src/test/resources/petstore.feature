Feature: Peststore

  Scenario: Create a pet
    Given I hit the Url of the PetStore
    And I create a pet JsonObject id 9223 categoryId 13 categoryname "dog" name "bejamin" Photo "imagelink" tagid 13 tagname "tag13" status "available"
    When I send the petobject in the request
    Then I recieve the response code as 200

  Scenario:Get the pet
    Given I hit the Url of the PetStore
    When I send the id "9223" in the request
    Then I recieve the response code as 200

  Scenario:Update the existing pet
    Given I hit the Url of the PetStore
    And I create a updated pet JsonObject
    When I send the Updated petobject in request
    Then I recieve the response code as 200

  Scenario:Get the Pets by status
    Given I hit the Url of the PetStore
    When I send the status "available" in the request
    Then I recieve the response code as 200

  Scenario: Delete the pet
    Given I hit the Url of the PetStore
    When I send the id "9223" in the deleterequest
    Then I recieve the response code as 200

  Scenario: update product
    Given I hit the Url of the PetStore
    When I send the id "10" name "doogy" status ""available
    Then  I recieve the response code as 200