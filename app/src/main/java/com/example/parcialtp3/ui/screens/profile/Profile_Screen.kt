package com.example.parcialtp3.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.OceanBlue
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.CabeceraTransactions
import com.example.parcialtp3.ui.components.DisplayName
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.ImagenFlotadora
import com.example.parcialtp3.ui.components.MonthSection
import com.example.parcialtp3.ui.components.ProfileOption
import com.example.parcialtp3.ui.components.TarjetaBalance
import com.example.parcialtp3.ui.components.Transaction
import com.example.parcialtp3.ui.poppinsFamily

@Composable
fun Profile_Screen() {
    BackgroundScaffold(
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(title = "Profile")
        },
        panelContent = {
            // Parte blanca: contenido debajo de la foto
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(Modifier.height(50.dp)) // deja espacio para la imagen

                DisplayName("25030024","John Smith")

                Spacer(Modifier.height(20.dp))

                ProfileOption(R.drawable.icon_profile, "Edit Profile")
                ProfileOption(R.drawable.icon_security, "Security")
                ProfileOption(R.drawable.icon_setting, "Setting")
                ProfileOption(R.drawable.icon_help, "Help")
                ProfileOption(R.drawable.icon_logout, "Logout")
            }
        }
    )

    // 🔥 Imagen de perfil superpuesta entre header y panel
    ImagenFlotadora(135.dp,R.drawable.profile_picture)
}




