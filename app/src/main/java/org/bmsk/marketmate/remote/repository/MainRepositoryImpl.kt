package org.bmsk.marketmate.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.bmsk.marketmate.model.ListItem
import org.bmsk.marketmate.remote.MainPagingSource
import org.bmsk.marketmate.remote.MainService
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainService: MainService,
): MainRepository {
    // paging3의 경우 첫 호출일 때 페이지 사이즈의 3배를 호출한다. (현재 20)
    override fun loadList() = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            MainPagingSource(mainService)
        }
    ).flow
    // liveData에 연결하고자 할 경우 .flow 대신 .liveData를 사용
}