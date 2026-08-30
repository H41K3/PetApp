package com.example.petapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3EEE6))
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF7CB39E)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Person, contentDescription = null, tint = Color.White)
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text("Boa tarde,", fontSize = 14.sp, color = Color.Gray)
                        Text("Usuário", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                    }
                }

                // Sino com bolinha de notificação
                Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.size(46.dp)) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .align(Alignment.BottomStart)
                            .background(Color.White, CircleShape)
                            .border(1.dp, Color(0xFFE8E8E8), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notificações", tint = Color.Black, modifier = Modifier.size(20.dp))
                    }
                    Box(
                        modifier = Modifier
                            .padding(top = 2.dp, end = 2.dp)
                            .size(12.dp)
                            .background(Color(0xFFE04F4F), CircleShape)
                            .border(2.dp, Color(0xFFFDFBF7), CircleShape)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Barra de Busca Customizada
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .border(1.dp, Color(0xFFE8E8E8), RoundedCornerShape(16.dp))
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Search, contentDescription = null, tint = Color.Gray, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Text("Buscar serviço, produto ou vet", color = Color.LightGray, fontSize = 14.sp, modifier = Modifier.weight(1f))

                // Ícone de Filtro
                Canvas(modifier = Modifier.size(18.dp)) {
                    val stroke = 1.5.dp.toPx()
                    drawLine(Color.Gray, Offset(2.dp.toPx(), 4.dp.toPx()), Offset(16.dp.toPx(), 4.dp.toPx()), stroke, StrokeCap.Round)
                    drawLine(Color.Gray, Offset(5.dp.toPx(), 9.dp.toPx()), Offset(13.dp.toPx(), 9.dp.toPx()), stroke, StrokeCap.Round)
                    drawLine(Color.Gray, Offset(8.dp.toPx(), 14.dp.toPx()), Offset(10.dp.toPx(), 14.dp.toPx()), stroke, StrokeCap.Round)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Card do Pet
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF0F5B43), RoundedCornerShape(24.dp))
                    .padding(20.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(52.dp)
                                    .background(Color(0xFFFF9B70), CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("🐾", fontSize = 24.sp)
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text("Pet", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                Text("Raça • 4 anos • 32 kg", color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp)
                            }
                        }

                        // Botão Trocar
                        Row(
                            modifier = Modifier
                                .border(1.dp, Color.White.copy(alpha = 0.3f), CircleShape)
                                .padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Trocar", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Chips de Status
                    Row {
                        Row(
                            modifier = Modifier
                                .background(Color.White.copy(alpha = 0.15f), CircleShape)
                                .padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("💉", fontSize = 12.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Vacina em 12 dias", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Row(
                            modifier = Modifier
                                .background(Color.White.copy(alpha = 0.15f), CircleShape)
                                .padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Default.FavoriteBorder, contentDescription = null, tint = Color.White, modifier = Modifier.size(12.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Saudável", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("Serviços", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                Text("Ver todos", color = Color(0xFF0F5B43), fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Grid de Serviços
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                ServiceCard("Banho", "a partir R$ 59", "🛁", Color(0xFFE2F4EC), Modifier.weight(1f))
                ServiceCard("Tosa", "a partir R$ 75", "✂️", Color(0xFFFFEBEA), Modifier.weight(1f))
                ServiceCard("Vacinas", "a partir R$ 89", "💉", Color(0xFFFFF3DE), Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                ServiceCard("Consulta", "a partir R$ 129", "🩺", Color(0xFFF2E8FF), Modifier.weight(1f))
                ServiceCard("Hotel", "a partir R$ 110", "🛏️", Color(0xFFE0F6F5), Modifier.weight(1f))
                ServiceCard("Táxi pet", "a partir R$ 25", "🚐", Color(0xFFFFEBE0), Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Próximo agendamento", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))

            // Card de Agendamento
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .border(1.dp, Color(0xFFF0F0F0), RoundedCornerShape(20.dp))
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(Color(0xFFE2F4EC), RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🚿", fontSize = 24.sp)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text("Banho + hidratação", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Sáb, 29 ago • 10:30 • Loja Batel", color = Color.Gray, fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .background(Color(0xFFE2F4EC), CircleShape)
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                        Text("Confirmado", color = Color(0xFF0F5B43), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    }
                }
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = Color.DarkGray, modifier = Modifier.size(24.dp))
            }
            Spacer(modifier = Modifier.height(32.dp))
        }

        // Custom Bottom Navigation
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 12.dp, horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomBottomNavItem("Início", Icons.Default.Home, true)
            CustomBottomNavItem("Agenda", Icons.Default.DateRange, false)
            CustomBottomNavItem("Carrinho", Icons.Default.ShoppingCart, false)
            CustomBottomNavItem("Conta", Icons.Default.Person, false)
        }
    }
}

@Composable
fun ServiceCard(title: String, price: String, icon: String, bgColor: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.White, RoundedCornerShape(20.dp))
            .border(1.dp, Color(0xFFF7F7F7), RoundedCornerShape(20.dp))
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(52.dp)
                .background(bgColor, RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(icon, fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(title, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(2.dp))
        Text(price, color = Color(0xFFAAAAAA), fontSize = 10.sp)
    }
}

@Composable
fun CustomBottomNavItem(label: String, icon: ImageVector, selected: Boolean) {
    val color = if (selected) Color(0xFF0F5B43) else Color.LightGray
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {  }
    ) {
        Icon(icon, contentDescription = label, tint = color, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.height(4.dp))
        Text(label, fontSize = 10.sp, color = color, fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium)
        Spacer(modifier = Modifier.height(4.dp))
        if (selected) {
            Box(modifier = Modifier.size(4.dp).background(color, CircleShape))
        } else {
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}