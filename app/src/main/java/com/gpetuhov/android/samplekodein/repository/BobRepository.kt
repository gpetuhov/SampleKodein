package com.gpetuhov.android.samplekodein.repository

// Here we have a concrete repository that implements Repository interface
class BobRepository : Repository {
    override fun getGreeting(): String {
        return "Hi, Bob!"
    }
}