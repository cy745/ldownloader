package com.lalilu.ldownloader.apis

import io.ktor.client.HttpClient


interface LoginApi {

}

class KtorLoginApi(private val client: HttpClient) : LoginApi {

}
