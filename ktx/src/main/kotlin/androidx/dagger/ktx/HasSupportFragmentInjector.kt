package androidx.dagger.ktx

import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector

@Suppress("unused")
interface HasSupportFragmentInjector {
    fun supportFragmentInjector(): AndroidInjector<Fragment>?
}