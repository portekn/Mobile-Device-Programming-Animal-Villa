package app.Service

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.room.Room
//import app.DAO.ILocalPromptDAO
//import app.DAO.IPromptDAO
//import app.DAO.PromptDatabase
import app.DTO.Prompt
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.Call

/*
class PromptService(application: Application){

    private val application = application

    internal suspend fun fetchPrompts(_prompts: Int){
      withContext(Dispatchers.IO){
            val service = RetrofitClientInstance.retrofitInstance?.create(IPromptDAO::class.java)
            val prompts = async {service?.getPrompts()}
            updateLocalPromptStorage(prompts.await())
        }
    }

    private suspend fun updateLocalPromptStorage(prompts: Call<ArrayList<Prompt>>?){
        try {
            prompts?.let {
                val localPromptDAO = getLocalPromptDAO()
                localPromptDAO.insertAll(prompts)
            }
            }
        catch(e: Exception) {
                Log.e(TAG, "***************************Error Saving Prompts ${e.message}")
            }
        }

    private fun getLocalPromptDAO(): ILocalPromptDAO {
        val db = Room.databaseBuilder(application, PromptDatabase::class.java, "myprompts").build()
        val localPromptDAO = db.localPromptDAO()
        return localPromptDAO
    }

    internal fun save (prompt: Prompt){
        getLocalPromptDAO().save(prompt)
    }
}


 */
