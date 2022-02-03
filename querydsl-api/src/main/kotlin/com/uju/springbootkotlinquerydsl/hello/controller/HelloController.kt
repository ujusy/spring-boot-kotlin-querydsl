//package com.uju.springbootkotlinquerydsl.com.uju.springbootkotlinquerydsl.hello.controller
//
//import com.uju.springbootkotlinquerydsl.com.uju.springbootkotlinquerydsl.hello.dto.GetHelloResponseDto
//import com.uju.springbootkotlinquerydsl.com.uju.springbootkotlinquerydsl.hello.service.HelloService
//import com.uju.springbootkotlinquerydsl.hello.Hello
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PathVariable
//import org.springframework.web.bind.annotation.RestController
//
//@RestController
//class HelloController(
//    private val helloService: HelloService,
//) {
//
//    @GetMapping("/hello/{id}")
//    fun getHello(@PathVariable("id") id: Long): GetHelloResponseDto {
//        val hello: Hello = this.helloService.get(id)
//
//        // convert hello to response dto
//        val response = GetHelloResponseDto(
//            id = hello.id,
//            name = hello.name,
//        )
//        return response
//    }
//}
