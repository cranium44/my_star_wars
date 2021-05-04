package live.adabe.mystarwars.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import live.adabe.mystarwars.navigation.NavigationService
import live.adabe.mystarwars.navigation.NavigationServiceImpl
import live.adabe.mystarwars.network.UserAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun povideCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return with(HttpLoggingInterceptor()) {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().callTimeout(20, TimeUnit.MINUTES)
            .addNetworkInterceptor(httpLoggingInterceptor).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
            .build()
    }

    @Provides
    fun provideApi(retrofit: Retrofit): UserAPI = retrofit.create(UserAPI::class.java)

    @Provides
    fun provideNavigationService(cicerone: Cicerone<Router>): NavigationService =
        NavigationServiceImpl(cicerone)
}