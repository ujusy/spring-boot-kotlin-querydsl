package com.uju.springbootkotlinquerydsl.hello.service

import com.uju.springbootkotlinquerydsl.hello.repository.HelloQueryRepository
import com.uju.springbootkotlinquerydsl.hello.Hello
import com.uju.springbootkotlinquerydsl.hello.dto.CreateHelloRequestDto
import com.uju.springbootkotlinquerydsl.hello.repository.HelloJpaRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
@Transactional(readOnly = true)
class HelloService(
    private val helloQueryRepository: HelloQueryRepository,
    private val helloJpaRepository: HelloJpaRepository,
) {

    fun get(id: Long): Hello {
        return this.helloQueryRepository.findById(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find hello")
    }

    @Transactional
    fun save(createHelloRequestDto: CreateHelloRequestDto): Long {
        val hello: Hello = Hello()
        hello.updateName(createHelloRequestDto.name)
        helloJpaRepository.save(hello)

        return hello.id
    }
}
