package app

import app.Service.IPromptService
import app.Service.PromptService
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single { MainViewModel(get()) }
    viewModel { ApplicationViewModel(androidApplication())}
    single<IPromptService> { PromptService(androidApplication())
    }
}