package com.graphqlpractice.controller

import com.graphqlpractice.model.Author
import com.graphqlpractice.model.Book
import com.graphqlpractice.repository.AuthorRepository
import com.graphqlpractice.repository.BookRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class BookController(
    private val bookRepository: BookRepository,
    private val authorRepository: AuthorRepository,
) {

    @QueryMapping
    fun books(): List<Book> =
        bookRepository.getAllBooks()

    @QueryMapping
    fun bookById(@Argument bookId: Int): Book? =
        bookRepository.getBookById(bookId)

    @SchemaMapping
    fun author(book: Book): Author? =
        authorRepository.getAuthorById(book.authorId)
}