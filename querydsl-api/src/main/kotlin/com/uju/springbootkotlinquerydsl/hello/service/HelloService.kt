package com.uju.springbootkotlinquerydsl.hello.service

import com.uju.springbootkotlinquerydsl.hello.repository.HelloQueryRepository
import com.uju.springbootkotlinquerydsl.hello.Hello
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class HelloService(
    private val helloQueryRepository: HelloQueryRepository,
) {

    fun get(id: Long): Hello {
        return this.helloQueryRepository.findById(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find hello")
    }
}
