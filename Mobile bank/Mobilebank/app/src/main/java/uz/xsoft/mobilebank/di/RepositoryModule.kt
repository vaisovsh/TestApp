package uz.xsoft.mobilebank.di

import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.xsoft.mobilebank.domain.repositories.AuthRepository
import uz.xsoft.mobilebank.domain.repositories.impl.AuthRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {


    @[Singleton Binds]
    fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository


}