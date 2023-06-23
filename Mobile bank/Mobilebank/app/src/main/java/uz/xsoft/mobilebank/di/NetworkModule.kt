package uz.xsoft.mobilebank.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.xsoft.mobilebank.data.source.api.AuthApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    private val BASE_URL = "http://143.198.48.222:84/v1/mobile-bank/"

    @[Provides Singleton]
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)

    @[Provides Singleton]
    fun provideClient(@ApplicationContext context: Context): OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(ChuckerInterceptor.Builder(context).build())
        .build()


    @Provides
    fun provideGson() : Gson = Gson()
}