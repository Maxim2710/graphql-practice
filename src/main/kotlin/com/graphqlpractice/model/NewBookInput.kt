package com.graphqlpractice.model

data class NewBookInput(
    val name: String,
    val pageCount: Int,
    val authorId: Int,
)