package androidx.dagger.example

import android.content.Context
import android.os.Bundle
import androidx.dagger.ktx.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject internal lateinit var sharedApplicationContext: Context
    @Inject internal lateinit var canonicalName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
