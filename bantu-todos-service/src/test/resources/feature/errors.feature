Feature: requests that should fail

    Background:
        * url baseUrl

    Scenario: check status
        Given path '/v1'
        And header Authorization = "Bearer " + authToken
        When method get
        Then status 400

