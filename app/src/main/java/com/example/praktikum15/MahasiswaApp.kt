package com.example.praktikum15

import android.app.Application
import com.example.praktikum15.di.InterfaceContainerApp
import com.example.praktikum15.di.MahasiswaContainer

class MahasiswaApp : Application() {
    lateinit var containerApp: MahasiswaContainer

    override fun onCreate() {
     super.onCreate()
     containerApp = MahasiswaContainer(this)
    }
}