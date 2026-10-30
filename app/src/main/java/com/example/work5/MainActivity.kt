package com.example.work5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke // <-- Вот этот импорт
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.work5.ui.theme.Work5Theme
import com.example.work5.ui.theme.SoftTeal
import com.example.work5.ui.theme.OceanBlue
import com.example.work5.ui.theme.DarkTeal
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Work5Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    FitnessScreen()
                }
            }
        }
    }
}

@Composable
fun FitnessScreen() {
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            SoftTeal,
            OceanBlue,
            DarkTeal
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBrush)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.End, // Аватарка справа
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
            )
        }

        // --- Список карточек ---
        MenuButton(text = "Упражнения")
        Spacer(modifier = Modifier.height(12.dp))
        MenuButton(text = "Статистика")
        Spacer(modifier = Modifier.height(12.dp))
        MenuButton(text = "Помощь тренера", isHighlighted = true)
        Spacer(modifier = Modifier.height(12.dp))
        MenuButton(text = "Подключить устр-во")
    }
}

@Composable
fun MenuButton(text: String, isHighlighted: Boolean = false) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = if (isHighlighted) BorderStroke(2.dp, OceanBlue) else null // Рамка для выделения
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color.Black)
            )

            Spacer(modifier = Modifier.width(16.dp))


            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FitnessScreenPreview() {
    Work5Theme {
        FitnessScreen()
    }
}