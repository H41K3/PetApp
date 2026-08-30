package com.example.petapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.petapp.ui.theme.PetAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PetAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        var telaAtual by remember { mutableStateOf("login") }

                        when (telaAtual) {
                            "login" -> LoginScreen(
                                onNavigateToCadastro = { telaAtual = "cadastro" },
                                onNavigateToHome = { telaAtual = "inicio" }
                            )
                            "cadastro" -> CadastroScreen(
                                onNavigateBackToLogin = { telaAtual = "login" }
                            )
                            "inicio" -> InicioScreen()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    PetAppTheme {
        LoginScreen(
            onNavigateToCadastro = {},
            onNavigateToHome = {}
        )
    }
}