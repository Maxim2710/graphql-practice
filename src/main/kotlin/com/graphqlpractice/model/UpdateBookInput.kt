package com.graphqlpractice.model

data class UpdateBookInput(
    val name: String?,
    val pageCount: Int?,
    val authorId: Int?,
)