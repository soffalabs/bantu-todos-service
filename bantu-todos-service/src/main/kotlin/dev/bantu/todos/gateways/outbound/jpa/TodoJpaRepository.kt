package dev.bantu.todos.gateways.outbound.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface TodoJpaRepository: JpaRepository<TodoEntity, String>
