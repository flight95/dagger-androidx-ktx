package androidx.dagger.example

import androidx.dagger.ktx.FragmentKey
import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module(subcomponents = [MainFragmentSubcomponent::class])
abstract class ApplicationBinder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    abstract fun bindAndroidInjectorFactory(builder: MainFragmentSubcomponent.Builder): AndroidInjector.Factory<out Fragment>
}