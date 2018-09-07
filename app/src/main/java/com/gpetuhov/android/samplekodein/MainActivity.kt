package com.gpetuhov.android.samplekodein

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gpetuhov.android.samplekodein.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

// To use injected properties activities and fragments
// must also implement KodeinAware interface.

class MainActivity : AppCompatActivity(), KodeinAware {

    // kodein property must be initialized by closestKodein() function.
    // This will work only if the Application class implements KodeinAware
    // and declares bindings.
    override val kodein by closestKodein()

    // This is the injection.
    // Property has Repository type.
    // Concrete implementation is injected by Kodein.
    private val repo: Repository by instance()

    // We may leave everything like in the code above and it will be enough.
    // Repository will by initialized lazily.
    // But to be sure everything's working fine it is better
    // to trigger injection in onCreate. To do this, override kodeinTrigger property:
    override val kodeinTrigger = KodeinTrigger()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Trigger injections here before anything is used.
        // (This is like SampleKodeinApp.getAppComponent().inject(this) in Dagger)
        kodeinTrigger.trigger()

        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = repo.getGreeting()
        }
    }
}
