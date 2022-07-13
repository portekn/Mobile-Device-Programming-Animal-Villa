package app.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import app.DTO.Prompt
import java.util.ArrayList

@Dao
interface ILocalPromptDAO {

    @Query("SELECT * FROM Prompt")
    fun getPrompts(): LiveData<List<Prompt>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(prompts: ArrayList<Prompt>)


}
