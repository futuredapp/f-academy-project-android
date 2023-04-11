package app.futured.androidprojecttemplate.injection.modules

import app.futured.androidprojecttemplate.BuildConfig
import app.futured.androidprojecttemplate.data.remote.ApiService
import app.futured.androidprojecttemplate.tools.Constants.Api.BASE_PROD_URL
import app.futured.androidprojecttemplate.tools.Constants.Api.TIMEOUT_IN_SECONDS
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor { message ->
            Timber.tag("OkHttp").d(message)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: Interceptor,
    ): OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    @OptIn(ExperimentalSerializationApi::class)
    fun provideRetrofitService(
        okHttpClient: OkHttpClient,
        json: Json,
    ) = Retrofit.Builder()
        .baseUrl(BASE_PROD_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .client(okHttpClient)
        .validateEagerly(BuildConfig.DEBUG)
        .build()
        .create(ApiService::class.java)
}
