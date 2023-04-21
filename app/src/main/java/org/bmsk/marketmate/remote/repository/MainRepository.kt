package org.bmsk.marketmate.remote.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.bmsk.marketmate.model.ListItem

interface MainRepository {
    fun loadList(): Flow<PagingData<ListItem>>
}