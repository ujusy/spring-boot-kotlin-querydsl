package com.uju.springbootkotlinquerydsl.hello.repository

import com.uju.springbootkotlinquerydsl.QuerydslConfig
import com.uju.springbootkotlinquerydsl.hello.Hello
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import javax.persistence.EntityManager

@DataJpaTest
@Import(QuerydslConfig::class, HelloQueryRepository::class)
internal class HelloQueryRepositoryTest(
    private val entityManager: EntityManager,
    private val helloQueryRepository: HelloQueryRepository,
) : FreeSpec({

    "findById" - {

        "잘 검색되어야 한다." {
            // given
            val name = "someName"
            val hello = Hello()
            hello.updateName(name)
            entityManager.persist(hello)
            entityManager.flush()

            // when
            val foundHello: Hello? = helloQueryRepository.findById(hello.id)

            // then
            foundHello?.name shouldBe name
        }
    }
})
