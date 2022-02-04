package com.uju.springbootkotlinquerydsl.hello.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.uju.springbootkotlinquerydsl.hello.Hello
import com.uju.springbootkotlinquerydsl.hello.QHello.hello
import org.springframework.stereotype.Repository

@Repository
class HelloQueryRepository(
    private val jpaQueryFactory: JPAQueryFactory,
) {

    // QueryDSL Queries
    fun findById(id: Long): Hello? {
        return this.jpaQueryFactory
            .selectFrom(hello)
            .where(hello.id.eq(id))
            .limit(1)
            .fetchOne()
    }
}
