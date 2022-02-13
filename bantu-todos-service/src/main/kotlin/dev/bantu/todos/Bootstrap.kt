package dev.bantu.todos

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Bootstrap {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Bootstrap::class.java, *args)
        }
    }

}
