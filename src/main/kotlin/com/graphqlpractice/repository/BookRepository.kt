package com.graphqlpractice.repository

import com.graphqlpractice.model.Book
import org.springframework.stereotype.Repository

@Repository
class BookRepository {
    fun getAllBooks(): List<Book> =
        listOf(
            Book(id = 1, name = "SomeBook", pageCount = 604),
            Book(id = 2, name = "Harry Potter", pageCount = 700),
            Book(id = 3, name = "Foobar", pageCount = 100),
            Book(id = 4, name = "Spring Boot", pageCount = 344)
        )
}