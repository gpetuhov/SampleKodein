package com.gpetuhov.android.samplekodein

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gpetuhov.android.samplekodein.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by closestKodein()

    private val repo: Repository by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = repo.getGreeting()
        }
    }
}
