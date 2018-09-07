package com.gpetuhov.android.samplekodein

import android.app.Application
import com.gpetuhov.android.samplekodein.repository.BobRepository
import com.gpetuhov.android.samplekodein.repository.Repository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.eagerSingleton

// Application class must implement KodeinAware interface
// and override kodein property.
// This is where we say, which concrete implementations to instantiate.
// It is the analog of Dagger Module (where instances are provided).

// Don't forget to use this class in the manifest!

class SampleKodeinApp : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        // This is where we tell Kodein, which concrete implementation
        // to use for the Repository interface.
        // eagerSingleton is initialized eagerly (when the app is started).
        bind<Repository>() with eagerSingleton { BobRepository() }
    }
}