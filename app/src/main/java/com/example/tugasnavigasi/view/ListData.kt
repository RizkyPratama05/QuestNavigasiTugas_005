package com.example.tugasnavigasi.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasnavigasi.R

data class FormData(
    val nama: String,
    val gender: String,
    val status: String,
    val alamat: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListData(
    onBerandaBtnClick : () -> Unit,
    OnFormulirBtnClick: () -> Unit
){
    val dataList = listOf(
        FormData(
            nama = "Rizky Pratama Putra",
            gender = "Laki - laki",
            status = "Lajang",
            alamat = "Yogyakarta"
        ),
        FormData(
            nama = "Masayu Eqfalarissa",
            gender = "Perempuan",
            status = "Lajang",
            alamat = "Makasar"
        ),
        FormData(
            nama = "Zaky Malika",
            gender = "Laki - laki",
            status = "Cerai",
            alamat = "Bengkulu"
        ),
        FormData(
            nama = "Nabil Udin",
            gender = "Laki - laki",
            status = "Kawin",
            alamat = "Sidoarjo"
        ),
        FormData(
            nama = "Sascha Danu",
            gender = "Laki - laki",
            status = "Cerai",
            alamat = "Solo"
        ),
        FormData(
            nama = "Arya Bagas Saputra",
            gender = "Laki - laki",
            status = "Kawin",
            alamat = "Gombong"
        )
    )
    Scaffold(
        containerColor = colorResource(R.color.coklat),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = stringResource(R.string.list),
                            color = colorResource(R.color.coklat),
                            fontWeight = FontWeight.Bold,
                            fontSize = 27.sp,
                            modifier = Modifier.padding(top = 40.dp, bottom = 20.dp)
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(modifier = Modifier.height(130.dp))
            {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ElevatedButton(
                        modifier = Modifier
                            .width(160.dp).padding(bottom = 30.dp).height(height = 60.dp),
                        shape = MaterialTheme.shapes.medium,
                        onClick = onBerandaBtnClick
                    ) {
                        Text(
                            text = stringResource(R.string.beranda),
                            color = colorResource(R.color.coklat),
                            fontSize = 20.sp
                        )
                    }
                    ElevatedButton(
                        modifier = Modifier
                            .width(160.dp).padding(bottom = 30.dp).height(height = 60.dp),
                        shape = MaterialTheme.shapes.medium,
                        onClick = OnFormulirBtnClick
                    ) {
                        Text(
                            text = stringResource(id = R.string.btnformulir),
                            color = colorResource(R.color.coklat),
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    ) {
        isiRuang ->
        LazyColumn(
            modifier = Modifier
                .padding(isiRuang),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(dataList) {
                item ->
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    ),
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.5f))
                ) {
                    Row(
                        modifier = Modifier
                            .padding(top = 12.dp, start = 16.dp, end = 20.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = stringResource(R.string.nama_lengkap),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.coklat)
                            )
                            Text(item.nama,
                                fontFamily = FontFamily.Serif
                            )
                        }
                        Column {
                            Text(text = stringResource(R.string.jenis_kelamin),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.coklat)
                            )
                            Text(item.gender,
                                fontFamily = FontFamily.Serif
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(modifier = Modifier.padding(start = 16.dp, end = 20.dp, bottom = 12.dp)
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween)
                    {
                        Column {
                            Text(text = stringResource(R.string.alamat),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.coklat)
                            )
                            Text(item.alamat,
                                fontFamily = FontFamily.Serif
                            )
                        }
                        Column(modifier = Modifier.padding(end = 70.dp)) {
                            Text(text = stringResource(R.string.status1),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.coklat)
                            )
                            Text(item.status,
                                fontFamily = FontFamily.Serif
                            )
                        }
                    }
                }
            }
        }
    }

}