package dev.bantu.todos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Todos

fun main(args: Array<String>) {
    runApplication<Todos>(*args)
}
