package androidx.dagger.ktx

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

@Suppress("unused")
abstract class DaggerFragment : Fragment(), HasSupportFragmentInjector {

    @Suppress("MemberVisibilityCanBePrivate")
    @Inject protected lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = childFragmentInjector
}