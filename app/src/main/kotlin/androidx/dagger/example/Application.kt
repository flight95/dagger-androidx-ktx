package androidx.dagger.example

import android.content.Context
import androidx.dagger.ktx.DaggerApplication
import dagger.android.AndroidInjector
import javax.inject.Inject

class Application : DaggerApplication() {

    @Inject internal lateinit var sharedApplicationContext: Context

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent.builder().application(this).build().apply {
            inject(this@Application)
        }
}