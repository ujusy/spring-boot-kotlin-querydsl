package com.uju.springbootkotlinquerydsl.hello.controller

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

@SpringBootTest
@AutoConfigureMockMvc
internal class HelloControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
) : FreeSpec({

    "getHello()" - {

        "잘 작동해야 한다" {
            // given
            val id: Long = 1

            // when
            val result: MvcResult = mockMvc.perform(
                get("/hello/$id")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
            ).andReturn()

            // then
            result.response.status shouldBe HttpStatus.OK.value()
        }
    }

    "createHello()" - {

        "정상적으로 생성되어야한다." {
            // given
            val name: String = "test"

            // when
            val result: MvcResult = mockMvc.perform(
                post("/hello")
                    .content("{ name: name }")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
            ).andReturn()

            // then
            println(result)
        }
    }
})