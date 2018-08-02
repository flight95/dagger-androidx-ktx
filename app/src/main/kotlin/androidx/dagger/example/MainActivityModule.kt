package androidx.dagger.example

import dagger.Module
import dagger.Provides

@Suppress("unused")
@Module
class MainActivityModule {

    @Provides
    fun provideCanonicalName(activity: MainActivity): String = activity::class.java.canonicalName
}