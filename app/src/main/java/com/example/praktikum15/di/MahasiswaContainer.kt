package com.example.praktikum15.di

import android.content.Context
import com.example.praktikum15.repository.NetworkRepositoryMhs
import com.example.praktikum15.repository.Repositorymhs
import com.google.firebase.firestore.FirebaseFirestore

interface InterfaceContainerApp {
    val repositorymhs : Repositorymhs
}

class MahasiswaContainer(private val context: Context) : InterfaceContainerApp {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    override val repositorymhs: Repositorymhs by lazy {
        NetworkRepositoryMhs(firestore)
    }
}