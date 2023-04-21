package org.bmsk.marketmate.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import org.bmsk.marketmate.remote.MainService
import org.bmsk.marketmate.remote.repository.MainRepository
import org.bmsk.marketmate.remote.repository.MainRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)   // repository같은 경우, ViewModel에서 사용하기 때문
object MainRepositoryModule {

    @ViewModelScoped
    @Provides
    fun providesMainRepository(
        mainService: MainService,
    ): MainRepository = MainRepositoryImpl(mainService)
}