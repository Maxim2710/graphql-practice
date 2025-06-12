package com.graphqlpractice.repository

import com.graphqlpractice.model.Book
import org.springframework.stereotype.Repository

@Repository
class BookRepository {
    final fun getAllBooks(): List<Book> =
        listOf(
            Book(id = 1, name = "SomeBook", pageCount = 604, 1),
            Book(id = 2, name = "Harry Potter", pageCount = 700, 2),
            Book(id = 3, name = "Foobar", pageCount = 100, 1),
            Book(id = 4, name = "Spring Boot", pageCount = 344, 3)
        )

    fun getBookById(id: Int): Book? =
        getAllBooks().stream()
            .filter { it.id == id }
            .findFirst()
            .orElse(null)
}