package androidx.dagger.example

import androidx.dagger.ktx.AndroidSupportInjectionModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Suppress("unused")
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationBinder::class,
    ApplicationModule::class])
interface ApplicationComponent : AndroidInjector<Application> {

    override fun inject(instance: Application)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}