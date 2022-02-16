package dev.bantu.todos

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Todos {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Todos::class.java, *args)
        }
    }

}
