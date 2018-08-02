package androidx.dagger.example

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Suppress("unused")
@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideSharedApplicationContext(application: Application): Context =
        application.applicationContext
}