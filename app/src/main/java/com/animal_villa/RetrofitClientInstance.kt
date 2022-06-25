package com.animal_villa
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 * RetrofitClientInstance object bootstrap
 * Boiler plate code set up
 */
object RetrofitClientInstance {
    private var retrofit: Retrofit?= null
    private val BASE_URL="https://pkgstore.datahub.io/" // (TEMPORARY) the JSON data to read

    val retrofitInstance :Retrofit?
        get(){
            if (retrofit==null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit

        }
}