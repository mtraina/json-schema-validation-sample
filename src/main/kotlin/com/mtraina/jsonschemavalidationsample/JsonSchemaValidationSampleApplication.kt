package com.mtraina.jsonschemavalidationsample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class JsonSchemaValidationSampleApplication

fun main(args: Array<String>) {
    runApplication<JsonSchemaValidationSampleApplication>(*args)
}

data class BookDetail(val dimensions: String, val language: String)
data class Book(val isbn10: String, val title: String, val details: BookDetail)

val books = setOf(Book("0000000000", "count of montecristo", BookDetail("5.2 x 2.2 x 7.8 inches", "english")),
                            Book("1111111111", "ulysses", BookDetail("7 x 0.9 x 10 inches", "english")))

@RestController
@RequestMapping("/books")
class BookController {

    @GetMapping
    fun getBooks() = books
}

