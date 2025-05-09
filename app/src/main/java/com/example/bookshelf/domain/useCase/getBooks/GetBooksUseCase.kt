package com.example.bookshelf.domain.useCase.getBooks

import com.example.bookshelf.common.Resource
import com.example.bookshelf.data.remote.booksListDto.toBooksListModel
import com.example.bookshelf.domain.models.booksListModel.BooksListModel
import com.example.bookshelf.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetBooksUseCase(private val booksRepository: BooksRepository) {
    fun execute(topic: String): Flow<Resource<BooksListModel>> = flow {
        try {
            emit(Resource.Loading())
            val books = booksRepository.getBooksList(topic = topic).toBooksListModel()
            emit(Resource.Success(data = books))
        } catch(e: HttpException) {
            Resource.Error<String>(message = e.localizedMessage ?: "An un-excepted error occurs")
        } catch (e: IOException) {
            Resource.Error<String>(message = e.localizedMessage ?: "An un-excepted error occurs")
        }
    }
}