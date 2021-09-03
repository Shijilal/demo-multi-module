package com.test.login.di

import com.test.core.util.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoggerModule {

    @Provides
    @Singleton
    @Named("LoginLogger")
    fun providesLogger(): Logger {
        return Logger(
            tag = "Login Module",
            isDebug = true
        )
    }
}