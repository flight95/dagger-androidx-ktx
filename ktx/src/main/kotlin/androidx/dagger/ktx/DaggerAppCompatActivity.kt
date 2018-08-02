package androidx.dagger.ktx

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject

@Suppress("DEPRECATION")
abstract class DaggerAppCompatActivity :
    AppCompatActivity(), HasFragmentInjector, HasSupportFragmentInjector {

    @Suppress("MemberVisibilityCanBePrivate")
    @Inject protected lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

    @Suppress("MemberVisibilityCanBePrivate")
    @Inject protected lateinit var frameworkFragmentInjector: DispatchingAndroidInjector<android.app.Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = supportFragmentInjector

    override fun fragmentInjector(): AndroidInjector<android.app.Fragment> = frameworkFragmentInjector
}