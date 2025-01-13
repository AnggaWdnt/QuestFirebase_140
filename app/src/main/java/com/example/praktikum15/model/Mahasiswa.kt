package com.example.praktikum15.model

data class Mahasiswa(
    val nim: String,
    val nama: String,
    val alamat: String,
    val gender: String,
    val kelas: String,
    val angkatan: String,
    val judulskripsi: String,
    val dpb1: String,
    val dpb2: String
){
    constructor() : this("", "", "", "", "", "","","","")
}
