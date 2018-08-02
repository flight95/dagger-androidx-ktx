package androidx.dagger.ktx

import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

@Suppress("unused")
abstract class DaggerApplication : dagger.android.DaggerApplication(), HasSupportFragmentInjector {

    @Suppress("MemberVisibilityCanBePrivate")
    @Inject protected lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

    abstract override fun applicationInjector(): AndroidInjector<out DaggerApplication>

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> =
        supportFragmentInjector
}