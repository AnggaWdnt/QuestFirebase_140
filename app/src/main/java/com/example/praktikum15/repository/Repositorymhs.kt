package com.example.praktikum15.repository

import com.example.praktikum15.model.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface Repositorymhs {

        // suspend digunakan untuk operasi yang berat seperti Create, Delete, Insert
        suspend fun insertMhs(mahasiswa: Mahasiswa)
        fun getAllMhs() : Flow<List<Mahasiswa>> //getAllMhs
        fun getMhs(nim: String): Flow<Mahasiswa> //getMhs
        suspend fun deleteMhs(mahasiswa: Mahasiswa) //deleteMhs
        suspend fun updateMhs(mahasiswa: Mahasiswa) //updateMhs
    }