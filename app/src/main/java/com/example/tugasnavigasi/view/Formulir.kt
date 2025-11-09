package com.example.tugasnavigasi.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasnavigasi.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormPendaftaran(
    OnKembaliBtnClick : () -> Unit
) {
    var namaLengkap by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var namaLK by remember { mutableStateOf(value = "") }
    var jk by remember { mutableStateOf(value = "") }
    var almt by remember { mutableStateOf(value = "") }
    var stts by remember { mutableStateOf(value = "") }

    val statusList = listOf("Lajang", "Kawin", "Cerai")
    var expanded by remember { mutableStateOf(false) }
    var selectedStatus by remember { mutableStateOf("") }
    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    var showDialog by remember { mutableStateOf(false) }

    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.coklatbg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        }
        Text(
            text = stringResource(id = R.string.formulir),
            fontFamily = FontFamily.Serif,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.coklat),
            modifier = Modifier.padding(top = 70.dp)
        )

        Spacer(modifier = Modifier.padding(top = 20.dp))

        Card(
            modifier = Modifier.fillMaxWidth().height(height = 660.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.white).copy(
                    alpha = 0.4f
                )
            )
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Top
            )
            {
                Text(
                    text = stringResource(id = R.string.nama_lengkap),
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    color = colorResource(id = R.color.coklat),
                    modifier = Modifier
                        .padding(top = 20.dp, start = 20.dp)
                )

                Spacer(modifier = Modifier.padding(top = 10.dp))

                OutlinedTextField(
                    value = namaLengkap,
                    singleLine = true,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
                        .height(height = 70.dp),
                    label = {
                        Text(
                            text = "Isikan nama lengkap",
                            color = colorResource(id = R.color.coklat)
                        )
                    },
                    onValueChange = {
                        namaLengkap = it
                    }
                )

                Spacer(modifier = Modifier.padding(top = 10.dp))

                Text(
                    text = stringResource(id = R.string.jenis_kelamin),
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    color = colorResource(id = R.color.coklat),
                    modifier = Modifier
                        .padding(top = 20.dp, start = 20.dp)
                )

                Row {
                    gender.forEach { item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = jenisKelamin == item,
                                    onClick = {
                                        jenisKelamin = item
                                    }
                                ),
                            verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = jenisKelamin == item,
                                onClick = {
                                    jenisKelamin = item
                                })
                            Text(
                                text = item,
                                fontSize = 20.sp,
                                color = colorResource(id = R.color.coklat)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.padding(top = 10.dp))

                Text(
                    text = stringResource(id = R.string.status),
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    color = colorResource(id = R.color.coklat),
                    modifier = Modifier
                        .padding(top = 20.dp, start = 20.dp)
                )

                Spacer(modifier = Modifier.padding(top = 10.dp))

                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {
                    OutlinedTextField(
                        value = selectedStatus,
                        onValueChange = {},
                        readOnly = true,
                        shape = MaterialTheme.shapes.medium,
                        label = {
                            Text(
                                "Pilih status kawin",
                                color = colorResource(id = R.color.coklat)
                            )
                        },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        modifier = Modifier.fillMaxWidth().menuAnchor()
                            .padding(start = 20.dp, end = 20.dp).height(height = 70.dp)
                    )

                    ExposedDropdownMenu(
                        containerColor = Color.White,
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        statusList.forEach { status ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        status,
                                        color = colorResource(id = R.color.coklat)
                                    )
                                },
                                onClick = {
                                    selectedStatus = status
                                    expanded = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.padding(top = 10.dp))

                Text(
                    text = stringResource(id = R.string.alamat),
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    color = colorResource(id = R.color.coklat),
                    modifier = Modifier
                        .padding(top = 20.dp, start = 20.dp)
                )

                Spacer(modifier = Modifier.padding(top = 10.dp))

                OutlinedTextField(
                    value = alamat,
                    singleLine = true,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
                        .height(height = 70.dp),
                    label = {
                        Text(
                            text = "Isikan alamat",
                            color = colorResource(id = R.color.coklat)
                        )
                    },
                    onValueChange = {
                        alamat = it
                    }
                )

                Spacer(modifier = Modifier.padding(top = 40.dp))

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    OutlinedButton(
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                            .padding(end = 8.dp),
                        border = BorderStroke(2.dp, colorResource(id = R.color.coklat)),
                        onClick = OnKembaliBtnClick
                    ) {
                        Text(
                            text = stringResource(id = R.string.kembali),
                            color = colorResource(id = R.color.coklat),
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(width = 40.dp))

                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                            .padding(end = 8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.coklat)),
                        onClick = {
                            namaLK = namaLengkap
                            jk = jenisKelamin
                            stts = selectedStatus
                            almt = alamat

                            showDialog = true
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.submit),
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                }

