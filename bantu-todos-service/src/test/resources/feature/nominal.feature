Feature: requests that should fail

    Background:
        * url baseUrl
        * header Authorization = "Bearer " + authToken

    Scenario: add todo
        Given path '/v1'
        And request { "content": "Release application" }
        When method post
        Then status 201
        And match response.id == "#string"
        And match response.done == false

    Scenario: list todos
        Given path '/v1'
        When method get
        Then status 200
        And match response == { todos: "#array" }

    Scenario: complete todo
        Given path '/v1'
        When method get
        Then status 200

        Given path '/v1/' + response.todos[0].id + '/done'
        And header Authorization = "Bearer " + authToken
        When method patch
        Then status 200
        And match response.done == true

    Scenario: update a todo
        Given path '/v1'
        When method get
        Then status 200

        * def id = response.todos[0].id

        Given path '/v1/' + id
        And header Authorization = "Bearer " + authToken
        And request { "content": "Update a todo" }
        When method patch
        Then status 200
        And match response.id == "#string"
        And response.id == id
        And response.content == "Update a todo"

