package androidx.dagger.example

import dagger.Module
import dagger.Provides

@Suppress("unused")
@Module
class MainFragmentModule {

    @Provides
    fun provideCanonicalName(fragment: MainFragment): String = fragment::class.java.canonicalName
}