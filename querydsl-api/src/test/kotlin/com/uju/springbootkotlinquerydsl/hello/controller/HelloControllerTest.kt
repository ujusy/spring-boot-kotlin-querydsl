package com.uju.springbootkotlinquerydsl.hello.controller

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@WebMvcTest(controllers = [HelloController::class])
internal class HelloControllerTest(
    private val mockMvc: MockMvc
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
})