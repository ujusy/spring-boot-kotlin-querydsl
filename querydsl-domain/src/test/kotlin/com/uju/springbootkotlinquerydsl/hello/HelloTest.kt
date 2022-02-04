package com.uju.springbootkotlinquerydsl.hello

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class HelloTest : FreeSpec({

    "updateName()" - {

        "이름이 업데이트되어야 한다" {
            // given
            val hello = Hello()
            val name = "someName"

            // when
            hello.updateName(name)

            // then
            hello.name shouldBe name
        }
    }
})
