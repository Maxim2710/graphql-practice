package com.graphqlpractice.repository

import com.graphqlpractice.model.Book
import com.graphqlpractice.model.NewBookInput
import com.graphqlpractice.model.UpdateBookInput
import org.springframework.stereotype.Repository

@Repository
class BookRepository {
    private val books = mutableListOf<Book>()
    private var lastId = 0

    fun getAllBooks(): List<Book> =
        books.toList()

    fun getBookById(id: Int): Book? =
        books.firstOrNull { it.id == id }

    fun addBook(input: NewBookInput): Book {
        val book = Book(
            id = ++lastId,
            name = input.name,
            pageCount = input.pageCount,
            authorId = input.authorId
        )
        books += book
        return book
    }

    fun updateBook(id: Int, input: UpdateBookInput): Book {
        val existing = getBookById(id)
            ?: throw NoSuchElementException("Book not found: $id")
        val updated = existing.copy(
            name = input.name ?: existing.name,
            pageCount = input.pageCount ?: existing.pageCount,
            authorId = input.authorId ?: existing.authorId
        )
        books.replaceAll { if (it.id == id) updated else it }
        return updated
    }

    fun deleteBook(id: Int): Boolean =
        books.removeIf { it.id == id }
}