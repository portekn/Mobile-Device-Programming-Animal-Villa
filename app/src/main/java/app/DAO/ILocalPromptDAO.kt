package app.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import app.DTO.Prompt
import retrofit2.Call
import kotlin.collections.ArrayList

/*
@Dao
interface ILocalPromptDAO {

    @Query("SELECT * FROM Prompt")
    fun getPrompts(): LiveData<List<Prompt>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(prompts: Call<ArrayList<Prompt>>?)
    abstract fun save(prompt: Prompt)


}

 */
