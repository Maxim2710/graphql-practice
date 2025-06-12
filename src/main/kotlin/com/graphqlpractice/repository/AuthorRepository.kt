package com.graphqlpractice.repository

import com.graphqlpractice.model.Author
import org.springframework.stereotype.Repository

@Repository
class AuthorRepository {
    final fun getAllAuthors(): List<Author> =
        listOf(
            Author(id = 1, name = "SomeAuthor1"),
            Author(id = 2, name = "SomeAuthor2"),
            Author(id = 3, name = "SomeAuthor3")
        )

    fun getAuthorById(id: Int): Author? =
        getAllAuthors().stream()
            .filter { it.id == id }
            .findFirst()
            .orElse(null)
}