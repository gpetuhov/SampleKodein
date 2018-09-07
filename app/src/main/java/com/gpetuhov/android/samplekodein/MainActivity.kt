package com.gpetuhov.android.samplekodein

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gpetuhov.android.samplekodein.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = repo.getGreeting()
        }
    }
}
