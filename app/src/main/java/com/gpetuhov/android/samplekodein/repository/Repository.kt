package com.gpetuhov.android.samplekodein.repository

// This is the interface of the repository.
// Any concrete repository will implement this interface
interface Repository {
    fun getGreeting(): String
}