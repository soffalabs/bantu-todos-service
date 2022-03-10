Feature: requests that should fail

    Background:
        * url baseUrl + '/v1'
        * header Authorization = "Bearer " + authToken

    Scenario: AddTodo
        And request { "content": "Learn Go" }
        When method post
        Then status 201
        And match response ==
        """
            {
                id: "#regex t_.+",
                status: "pending",
                content: "Learn Go",
                created: "#number"
            }
        """

    Scenario: GetTodoList
        When method get
        Then status 200
        And match response ==  { todos: "#array" }

    Scenario: UpdateTodo
        When method get
        Then status 200
        * def id = response.todos[0].id

        Given path id
        And header Authorization = "Bearer " + authToken
        And request { "content": "Update a todo" }
        When method patch
        Then status 200
        And match response == { id: "#(id)", content: "Update a todo", status: "pending", created: '#number' }

    Scenario: complete todo
        When method get
        Then status 200

        Given path response.todos[0].id + '/done'
        And header Authorization = "Bearer " + authToken
        When method patch
        Then status 200
        And match response.status == "done"
