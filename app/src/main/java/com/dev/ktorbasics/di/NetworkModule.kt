package com.dev.ktorbasics.di

import com.dev.ktorbasics.data.remote.AuthInterceptor
import com.dev.ktorbasics.data.remote.CityApi
import com.dev.ktorbasics.data.repository.CityRepository
import com.dev.ktorbasics.domain.repository.CityRepositoryImpl
import com.dev.ktorbasics.domain.usecase.GetCityDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://api.api-ninjas.com/"
    private const val API_KEY =""

    @Provides
    @Singleton
    fun provideAuthInterceptor(): AuthInterceptor {
        return AuthInterceptor(API_KEY)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCityApi(retrofit: Retrofit) : CityApi {
        return retrofit.create(CityApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCityRepository(api: CityApi) : CityRepository {
        return CityRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetCityUseCase(repository: CityRepository) : GetCityDetailsUseCase {
        return GetCityDetailsUseCase(repository)
    }


}