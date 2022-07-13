package app.DAO

import app.DTO.Prompt
import retrofit2.Call
import retrofit2.http.GET

interface IPromptDAO {

    @GET("v3/b/62ca4dbc5d53821c3097eaef")
    suspend fun getPrompts() : Call<ArrayList<Prompt>>
}