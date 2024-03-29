package com.lalilu.ldownloader

import com.lalilu.ldownloader.apis.KtorLoginApi
import com.lalilu.ldownloader.apis.LoginApi
import com.lalilu.ldownloader.apis.LoginRepository
import com.lalilu.ldownloader.model.LoginScreenModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    single {
        val json = Json { ignoreUnknownKeys = true }
        HttpClient {
            install(ContentNegotiation) {
                // TODO Fix API so it serves application/json
                json(json, contentType = ContentType.Any)
            }
        }
    }
    singleOf(::KtorLoginApi)
    singleOf(::LoginRepository)

    single<LoginApi> { get<KtorLoginApi>() }
}

val screenModelsModule = module {
    factoryOf(::LoginScreenModel)
}

fun initKoin() {
    startKoin {
        modules(
            dataModule,
            screenModelsModule,
        )
    }
}