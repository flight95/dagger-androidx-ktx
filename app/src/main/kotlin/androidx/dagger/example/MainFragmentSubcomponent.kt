package androidx.dagger.example

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Suppress("unused")
@Subcomponent(modules = [MainFragmentModule::class])
interface MainFragmentSubcomponent : AndroidInjector<MainFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainFragment>()
}