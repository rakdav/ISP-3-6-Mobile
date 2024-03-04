package com.example.lab2

import android.app.Application
import com.example.lab2.database.StudentRepository

class Lab2Application:Application() {
    override fun onCreate() {
        super.onCreate()
        StudentRepository.initialize(this)
    }
}