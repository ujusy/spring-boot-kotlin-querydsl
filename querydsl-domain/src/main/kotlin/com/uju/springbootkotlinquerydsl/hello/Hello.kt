package com.uju.springbootkotlinquerydsl.hello

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Hello {
    @Id
    @GeneratedValue
    var id: Long = 0

    var name: String = ""
        private set

    fun updateName(name: String) {
        // 유효성 검사

        this.name = name
    }
}