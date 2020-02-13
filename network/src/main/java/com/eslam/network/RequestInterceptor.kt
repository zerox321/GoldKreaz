package com.eslam.network

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val originalRequest = chain.request()
    val originalUrl = originalRequest.url

    // add TheMovieDB api automatically every requests.
    val url = originalUrl.newBuilder()
      .build()

    val requestBuilder = originalRequest.newBuilder().url(url)
    val request = requestBuilder.build()
    return chain.proceed(request)
  }
}
