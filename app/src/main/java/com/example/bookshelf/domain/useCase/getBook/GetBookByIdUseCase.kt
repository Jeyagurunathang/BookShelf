package com.example.bookshelf.domain.useCase.getBook

import com.example.bookshelf.common.Resource
import com.example.bookshelf.data.remote.bookByIdDto.toBookByIdModel
import com.example.bookshelf.domain.models.bookByIdModel.BookByIdModel
import com.example.bookshelf.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetBookByIdUseCase(private val booksRepository: BooksRepository) {
    fun execute(bookId: String): Flow<Resource<BookByIdModel>> = flow {
        try {
            emit(Resource.Loading())
            val book = booksRepository.getBookById(bookId = bookId).toBookByIdModel()
            emit(Resource.Success(data = book))
        } catch (e: HttpException) {
            Resource.Error<String>(e.localizedMessage ?: "An un-expected error occurs")
        } catch (e: IOException) {
            Resource.Error<String>(e.localizedMessage ?: "An unexpected error occurs")
        }
    }
}