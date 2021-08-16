package com.github.sampledagger2mvp.api



import com.github.sampledagger2mvp.model.SportsCommunities
import com.github.sampledagger2mvp.model.TopCommunities
import com.github.sampledagger2mvp.util.Constants
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServiceInterface {
    @GET("/comments")
    fun getCommunities(): Call<List<TopCommunities>>

    @GET("/comments")
    fun getSportsCommunities(): Call<List<SportsCommunities>>


    companion object Factory {

        fun create(): ApiServiceInterface {
            var retrofit =
                Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(
                    ApiServiceInterface::class.java)

          /*  val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()

            return retrofit.create(ApiServiceInterface::class.java)*/

            return retrofit
        }
    }
}