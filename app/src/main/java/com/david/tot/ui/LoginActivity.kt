package com.david.tot.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.*
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.david.tot.ui.theme.TotTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TotTheme(darkTheme = false) {
                val loginViewModel = viewModel<LoginViewModel>()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colors.background
                    //color = addProductViewModel.backgroundColor
                ) {

                    var productName by rememberSaveable { mutableStateOf("") }
                    var email by rememberSaveable { mutableStateOf("") }
                    var password by rememberSaveable { mutableStateOf("") }
                    var productPrice by rememberSaveable { mutableStateOf("") }
                    if(loginViewModel.responseCode != 0){
                        if (loginViewModel.responseCode == 201) {
                            Toast.makeText(LocalContext.current, "Inicio de sesion exitoso", Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(LocalContext.current, "No se pudo iniciar sesion, verifique sus credenciales", Toast.LENGTH_LONG).show()
                        }
                        Thread.sleep(1000)
                        startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                        finish()
                    }
                    Column( horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.border(1.dp, Color.Gray, RectangleShape).fillMaxWidth().padding(20.dp)) {
                        Row(
                            modifier = Modifier.padding(all = 12.dp),horizontalArrangement = Arrangement.Center
                        ){
                            Text(text = "SISMEDICA", fontSize = 30.sp,fontWeight = FontWeight.Bold,textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(start = 16.dp, end = 50.dp, top = 20.dp)
                                    .fillMaxWidth())
                        }
                        Row(
                            modifier = Modifier.padding(all = 12.dp),horizontalArrangement = Arrangement.Center
                        ){
                            OutlinedTextField(
                                value = email,
                                onValueChange = {
                                    loginViewModel.productDescription = it
                                    email = loginViewModel.productDescription},
                                label = { Text("Usuario:") },
                                modifier = Modifier
                                    .padding(start = 16.dp, end = 16.dp, top = 20.dp)
                                    .fillMaxWidth()
                            )
                        }

                        /*
                        Row(
                            modifier = Modifier.padding(all = 12.dp),horizontalArrangement = Arrangement.Center
                        ){
                            OutlinedTextField(
                                value = productName,
                                onValueChange = {
                                    addProductViewModel.productName = it
                                    productName = addProductViewModel.productName},
                                label = { Text("") },
                                modifier = Modifier
                                    .padding(start = 16.dp, end = 16.dp, top = 20.dp)
                                    .fillMaxWidth()
                            )
                        }
                        */

                        Row(
                            modifier = Modifier.padding(all = 12.dp),horizontalArrangement = Arrangement.Center
                        ){
                            OutlinedTextField(
                                value = password,
                                onValueChange = {
                                    loginViewModel.productDescription = it
                                    password = loginViewModel.productDescription},
                                label = { Text("Contraseña:") },
                                modifier = Modifier
                                    .padding(start = 16.dp, end = 16.dp, top = 20.dp)
                                    .fillMaxWidth()
                            )
                        }
                        /*
                        Row(
                            modifier = Modifier.padding(all = 12.dp),horizontalArrangement = Arrangement.Center
                        ){
                            OutlinedTextField(
                                keyboardOptions = KeyboardOptions(
                                    capitalization = KeyboardCapitalization.None,
                                    autoCorrect = true,
                                    keyboardType = KeyboardType.Number,
                                    imeAction = ImeAction.Next
                                ),
                                value = ""+productPrice,
                                onValueChange = {
                                    addProductViewModel.productPrice = it.toInt()
                                    productPrice = it},
                                label = { Text("Precio: "+productPrice) },
                                modifier = Modifier
                                    .padding(start = 16.dp, end = 16.dp, top = 20.dp)
                                    .fillMaxWidth()
                            )
                        }
                        */
                        Row(
                            modifier = Modifier.padding(all = 12.dp),horizontalArrangement = Arrangement.Center
                        ){


                            Button(onClick = {loginViewModel.login()},
                                modifier = Modifier
                                    .padding(bottom = 10.dp)
                                    .height(60.dp)
                            ) {
                                Text("INICIAR SESION")
                            }
                        }
                    }
                }
            }
        }
    }
}