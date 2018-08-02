package androidx.dagger.example

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.dagger.ktx.DaggerFragment
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : DaggerFragment() {

    @Inject internal lateinit var sharedApplicationContext: Context
    @Inject internal lateinit var canonicalName: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_main, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        StringBuilder()
            .apply {
                (sharedApplicationContext as? Application)?.let {
                    append("INJECT in ${it::class.java.simpleName}")
                    append("\n").append("- sharedApplicationContext:")
                    append("\n").append(it.sharedApplicationContext)
                    append("\n\n")
                }

                (context as? MainActivity)?.let {
                    append("INJECT in ${it::class.java.simpleName}")
                    append("\n").append("- sharedApplicationContext:")
                    append("\n").append(it.sharedApplicationContext)
                    append("\n").append("- canonicalName:")
                    append("\n").append(it.canonicalName)
                    append("\n\n")
                }

                append("INJECT in ${this@MainFragment::class.java.simpleName}")
                append("\n").append("- sharedApplicationContext:")
                append("\n").append(sharedApplicationContext)
                append("\n").append("- canonicalName:")
                append("\n").append(canonicalName)
            }
            .also { message.text = it }
    }
}
