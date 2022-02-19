Feature: all things accounts

    Background:
        * url baseUrl

    Scenario: check status
        Given path '/actuator/health'
        When method get
        Then status 200
        And match response == { status: 'UP', groups: ['liveness', 'readiness'], components: '#object' }

