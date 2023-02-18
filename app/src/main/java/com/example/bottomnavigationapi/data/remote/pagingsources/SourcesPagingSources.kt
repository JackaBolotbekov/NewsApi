package com.example.bottomnavigationapi.data.remote.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.example.bottomnavigationapi.data.models.ArticlesItem
import com.example.bottomnavigationapi.data.remote.apiservices.SourcesApiService
import java.io.IOException

class SourcesPagingSources constructor(private val service: SourcesApiService) :
    PagingSource<Int, ArticlesItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticlesItem> {
        try {
            val page = params.key ?: DEFAULT_PAGE_NUMBER
            val pageSize: Int = params.loadSize.coerceAtMost(1000)

            val response = service.fetchSources("symbol", page)
            val next = response.totalResults
            val nextPageNumber = if (next > pageSize) page + 1 else null

            return LoadResult.Page(
                data = response.articles,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
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