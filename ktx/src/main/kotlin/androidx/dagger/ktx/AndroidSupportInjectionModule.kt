package androidx.dagger.ktx

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.internal.Beta
import dagger.multibindings.Multibinds

@Suppress("unused")
@Beta
@Module(includes = [AndroidInjectionModule::class])
abstract class AndroidSupportInjectionModule private constructor() {

    @Multibinds
    internal abstract fun supportFragmentInjectorFactories():
        Map<Class<out Fragment>, AndroidInjector.Factory<out Fragment>>
}