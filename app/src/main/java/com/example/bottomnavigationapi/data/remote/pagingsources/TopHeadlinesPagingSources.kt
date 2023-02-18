package com.example.bottomnavigationapi.data.remote.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.bottomnavigationapi.data.models.ArticlesItem
import com.example.bottomnavigationapi.data.remote.apiservices.TopHeadlinesApiService
import retrofit2.HttpException
import java.io.IOException

class TopHeadlinesPagingSources constructor(private val service: TopHeadlinesApiService) :
    PagingSource<Int, ArticlesItem>() {

    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, ArticlesItem> {
        try {
            val page = params.key ?: DEFAULT_PAGE_NUMBER
            val pageSize: Int = params.loadSize.coerceAtMost(1000)

            val response = service.fetchTopHeadlines("news", page)
            val next = response.totalResults
            val nextPageNumber = if (next > pageSize) page + 1 else null

            return PagingSource.LoadResult.Page(
                data = response.articles,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: IOException) {
            return PagingSource.LoadResult.Error(e)
        } catch (e: HttpException) {
            return PagingSource.LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ArticlesItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    companion object {
        const val DEFAULT_PAGE_NUMBER = 1
    }
}