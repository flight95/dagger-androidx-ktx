package androidx.dagger.ktx

import android.util.Log
import androidx.fragment.app.Fragment

object AndroidSupportInjection {

    private const val TAG = "dagger.android.support"

    fun inject(fragment: Fragment?) {
        when (fragment) {
            null -> throw IllegalStateException("Could not inject at null fragment.")
            else -> {
                findHasFragmentInjector(fragment).let { injector ->
                    when (injector) {
                        null -> throw IllegalStateException("No injector was found for ${fragment::class.java.canonicalName}.")
                        else -> injectFromHasSupportFragmentInjector(fragment, injector)
                    }
                }
            }
        }
    }

    private fun injectFromHasSupportFragmentInjector(fragment: Fragment, injector: HasSupportFragmentInjector) {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(
                TAG,
                String.format(
                    "An injector for %s was found in %s",
                    fragment::class.java.canonicalName,
                    injector::class.java.canonicalName))
        }

        injector.supportFragmentInjector().let { supportInjector ->
            when (supportInjector) {
                null -> throw IllegalStateException("${injector::class.java.canonicalName}.supportFragmentInjector() returned null.")
                else -> supportInjector.inject(fragment)
            }
        }
    }

    private fun findHasFragmentInjector(fragment: Fragment): HasSupportFragmentInjector? =
        findHasSupportFragmentInjectorFromParentFragment(fragment).run {
            when (this) {
                null -> {
                    fragment.activity?.run {
                        when (this) {
                            is HasSupportFragmentInjector -> this
                            else -> application as? HasSupportFragmentInjector
                        }
                    }
                }
                else -> this
            }
        }

    private fun findHasSupportFragmentInjectorFromParentFragment(fragment: Fragment): HasSupportFragmentInjector? =
        fragment.parentFragment?.run {
            when (this) {
                is HasSupportFragmentInjector -> this
                else -> findHasSupportFragmentInjectorFromParentFragment(this)
            }
        }
}