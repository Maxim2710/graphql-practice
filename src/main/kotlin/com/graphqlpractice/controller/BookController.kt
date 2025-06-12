package com.graphqlpractice.controller

import com.graphqlpractice.model.Book
import com.graphqlpractice.repository.BookRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.util.Optional

@Controller
class BookController(
    private val bookRepository: BookRepository,
) {

    @QueryMapping
    fun books(): List<Book> =
        bookRepository.getAllBooks()

    @QueryMapping
    fun bookById(@Argument bookId: Int): Book? =
        bookRepository.getBookById(bookId)

}