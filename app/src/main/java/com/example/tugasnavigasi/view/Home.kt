package com.example.tugasnavigasi.view

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasnavigasi.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilanUtama(
    OnMasukBtnClick : () -> Unit
){
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(modifier = Modifier.padding(top = 130.dp),
            text = stringResource(id = R.string.welcome),
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.coklat)
        )
        Image(
            painter = painterResource(id = R.drawable.rabg),
            contentDescription = null,
            modifier = Modifier
                .size(size = 350.dp)
                .padding(top = 100.dp)
        )
        Text(
            text = stringResource(id = R.string.namaku),
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.coklat),
            modifier = Modifier.padding(top = 70.dp)
        )
        Text(
            text = stringResource(id = R.string.nim),
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.padding(top = 70.dp))

        Button(
            modifier = Modifier.fillMaxWidth(1f)
                .padding(start = 110.dp, end = 100.dp)
                .size(40.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.coklat)
            ),
            onClick = OnMasukBtnClick
        ) {
            Text(text = stringResource(id = R.string.masuk))
        }
    }
}