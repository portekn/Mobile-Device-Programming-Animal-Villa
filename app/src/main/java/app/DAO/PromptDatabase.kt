package app.DAO

import androidx.room.Database
import androidx.room.RoomDatabase
import app.DTO.Prompt

@Database(entities = arrayOf(Prompt::class), version =1)
abstract class PromptDatabase : RoomDatabase() {
    abstract fun localPromptDAO() : ILocalPromptDAO
}