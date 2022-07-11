package app.Service

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.room.Room
import app.DAO.ILocalPromptDAO
import app.DAO.IPromptDAO
import app.DAO.PromptDatabase
import app.DTO.Prompt
import app.RetrofitClientInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

interface IPromptService {
    suspend fun  fetchPrompts() : List<Prompt>?
    fun getLocalPromptDAO(): ILocalPromptDAO
}
class PromptService(private val application: Application) : IPromptService {

    lateinit var db: PromptDatabase

    override suspend fun fetchPrompts(): List<Prompt>? {
        return withContext(Dispatchers.IO){
            val service = RetrofitClientInstance.retrofitInstance?.create(IPromptDAO::class.java)
            val prompts = async {service?.getPrompts()}
            val result = prompts.await()?.awaitResponse()?.body()
            updateLocalPromptStorage(result)
            return@withContext result
        }
    }

    private fun  updateLocalPromptStorage(prompts : ArrayList<Prompt>?){
        try {
            prompts?.let {
                val localPromptDAO = getLocalPromptDAO()
                localPromptDAO.insertAll(prompts)
            }
            }
        catch(e: Exception) {
                Log.e(TAG, "Error Saving Prompts ${e.message}")
            }
        }

    override fun getLocalPromptDAO(): ILocalPromptDAO {
        if (!this::db.isInitialized) {
            db = Room.databaseBuilder(application, PromptDatabase::class.java, "My Prompts").build()
        }
        return db.localPromptDAO()
    }
}

