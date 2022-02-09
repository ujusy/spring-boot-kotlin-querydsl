package com.uju.springbootkotlinquerydsl.hello.controller

import com.uju.springbootkotlinquerydsl.hello.dto.GetHelloResponseDto
import com.uju.springbootkotlinquerydsl.hello.service.HelloService
import com.uju.springbootkotlinquerydsl.hello.Hello
import com.uju.springbootkotlinquerydsl.hello.dto.CreateHelloRequestDto
import com.uju.springbootkotlinquerydsl.hello.dto.CreateHelloResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
class HelloController(
    private val helloService: HelloService,
) {

    @GetMapping("/hello/{id}")
    fun getHello(@PathVariable("id") id: Long): ResponseEntity<GetHelloResponseDto> {
        val hello: Hello = this.helloService.get(id)

        // convert hello to response dto
        val response = GetHelloResponseDto(
            id = hello.id,
            name = hello.name,
        )
        return ResponseEntity.ok(response)
    }

    @PostMapping("/hello")
    fun createHello(@RequestBody @Valid createHelloRequestDto: CreateHelloRequestDto)
    : ResponseEntity<CreateHelloResponseDto> {
        val hello: Long = helloService.save(createHelloRequestDto)

        return ResponseEntity.ok(
            CreateHelloResponseDto(
            id = hello
            )
        )
    }
}
