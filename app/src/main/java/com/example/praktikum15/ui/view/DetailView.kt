package com.example.praktikum15.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum15.ui.viewmodel.DetailUiState

@Composable
fun DetailBody(
    detailUiState: DetailUiState,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (detailUiState) {
        is DetailUiState.Loading -> {
            CircularProgressIndicator(modifier = modifier.fillMaxSize())
        }
        is DetailUiState.Error -> {
            Text(
                text = detailUiState.message,
                color = Color.Red,
                modifier = modifier.fillMaxSize().wrapContentSize(Alignment.Center)
            )
        }
        is DetailUiState.Success -> {
            val mahasiswa = detailUiState.mahasiswa
            Column(
                verticalArrangement = Arrangement.spacedBy(18.dp),
                modifier = Modifier.padding(12.dp)
            ) {
                ComponentDetailMhs(judul = "Nama", isinya = mahasiswa.nama)
                ComponentDetailMhs(judul = "Nama", isinya = mahasiswa.nama)
                ComponentDetailMhs(judul = "NIM", isinya = mahasiswa.nim)
                ComponentDetailMhs(judul = "Alamat", isinya = mahasiswa.alamat)
                ComponentDetailMhs(judul = "Kelas", isinya = mahasiswa.kelas)
                ComponentDetailMhs(judul = "Angkatan", isinya = mahasiswa.angkatan)
                ComponentDetailMhs(judul = "JudulSkripsi", isinya = mahasiswa.judulskripsi)
                ComponentDetailMhs(judul = "DosenBimbing1", isinya = mahasiswa.dpb1)
                ComponentDetailMhs(judul = "DosenBimbing2", isinya = mahasiswa.dpb2)
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = onDeleteClick,
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Hapus")
                }
            }
        }
    }
}

@Composable
fun ComponentDetailMhs(
    modifier: Modifier = Modifier,
    judul: String,
    isinya: String,
){
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "$judul : ",
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Text(
            text = isinya,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold
        )
    }
}