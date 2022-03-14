package dev.bantu.todos

import dev.soffa.foundation.Foundation
import dev.soffa.foundation.annotation.ExcludeFromCoverageGeneratedReport
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class TodoService {

    companion object {
        @JvmStatic
        @ExcludeFromCoverageGeneratedReport
        fun main(args: Array<String>) {
            Foundation.run(TodoService::class.java, *args)
        }
    }
}
