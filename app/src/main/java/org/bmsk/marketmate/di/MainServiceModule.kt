package org.bmsk.marketmate.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.bmsk.marketmate.model.MainService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainServiceModule {
    @Provides
    @Singleton
    fun providesMainService(retrofit: Retrofit): MainService = retrofit.create(MainService::class.java)
}