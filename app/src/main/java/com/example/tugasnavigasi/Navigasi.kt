package com.example.tugasnavigasi

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugasnavigasi.view.FormPendaftaran
import com.example.tugasnavigasi.view.ListData
import com.example.tugasnavigasi.view.TampilanUtama

enum class Navigasi {
    Homeku,
    Formku,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
){
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Homeku.name,

            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = Navigasi.Homeku.name){
                TampilanUtama(
                    OnMasukBtnClick = {
                        navController.navigate(route = Navigasi.Detail.name)
                    }
                )
            }

            composable(route = Navigasi.Detail.name){
                ListData(
                    onBerandaBtnClick = {
                        cancelAndBackToHome(navController)
                    },
                    OnFormulirBtnClick = {
                        navController.navigate(route = Navigasi.Formku.name)
                    }
                )
            }

            composable(route = Navigasi.Formku.name) {
                FormPendaftaran(
                    OnKembaliBtnClick = {
                        cancelAndBackToList(navController)
                    }
                )
            }
        }
    }
}

private fun cancelAndBackToHome(
    navController: NavHostController
){
    navController.popBackStack(route = Navigasi.Homeku.name, inclusive = false)
}

private fun cancelAndBackToList(
    navController: NavHostController
){
    navController.popBackStack(route = Navigasi.Detail.name, inclusive = false)
}