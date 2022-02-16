package dev.bantu.todos.gateways.outbound.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface MessageJpaRepository: JpaRepository<TodoEntity, String>
