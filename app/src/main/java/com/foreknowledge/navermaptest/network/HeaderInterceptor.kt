package com.foreknowledge.navermaptest.network

import com.foreknowledge.navermaptest.BuildConfig
import com.foreknowledge.navermaptest.HEADER_CLIENT_ID
import com.foreknowledge.navermaptest.HEADER_CLIENT_SECRET
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Create by Yeji on 16,April,2020.
 */
class HeaderInterceptor : Interceptor {
	override fun intercept(chain: Interceptor.Chain): Response {
		val origin = chain.request()
		val request = origin.newBuilder()
			.addHeader(HEADER_CLIENT_ID, BuildConfig.NAVER_CLIENT_ID)
			.addHeader(HEADER_CLIENT_SECRET, BuildConfig.NAVER_CLIENT_SECRET)
			.method(origin.method(), origin.body())
			.build()

		return chain.proceed(request)
	}
}