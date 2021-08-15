package ru.heatalways.chucknorrisfunfacts.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.heatalways.chucknorrisfunfacts.domain.network.api.ChuckNorrisJokesApi
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideChuckNorrisJokesApi(builder: Retrofit.Builder): ChuckNorrisJokesApi {
        return buildChuckNorrisJokesRetrofit(builder).create(ChuckNorrisJokesApi::class.java)
    }

    private fun buildChuckNorrisJokesRetrofit(builder: Retrofit.Builder): Retrofit {
        return builder.baseUrl(ChuckNorrisJokesApi.BASE_URL).build()
    }
}