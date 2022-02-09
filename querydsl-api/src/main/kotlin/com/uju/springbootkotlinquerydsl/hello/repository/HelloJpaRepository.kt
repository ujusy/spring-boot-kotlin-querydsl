package com.uju.springbootkotlinquerydsl.hello.repository

import com.uju.springbootkotlinquerydsl.hello.Hello
import org.springframework.data.jpa.repository.JpaRepository

interface HelloJpaRepository: JpaRepository<Hello, Long> {
}