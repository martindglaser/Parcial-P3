package com.example.parcialtp3.ui.screens.profile.help.online_support

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.poppinsFamily

/* =========================== DATA (mock) ============================ */

private data class SupportChatUi(
    val id: String,
    val title: String,
    val subtitle: String,
    val rightPillText: String, // "2 Min Ago" o "Feb 08 · 2024"
)

/* =========================== SCREEN ============================ */

@Composable
fun A_Online_Support_Screen(
    navController: NavHostController,
    onBack: () -> Unit = {},
    onStartNewChat: () -> Unit = {},
    onOpenChat: (String) -> Unit = {}
) {
    BackgroundScaffold(
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                title = "Online Support",
                navController = navController,
                onBackClick = onBack
            )
        },
        panelContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(Modifier.height(12.dp))

                // Active
                SectionTitle(text = "Active Chats")
                Spacer(Modifier.height(10.dp))

                ChatRow(
                    chat = SupportChatUi(
                        id = "active-1",
                        title = "Support Assistant",
                        subtitle = "Hello! I'm here to assist you",
                        rightPillText = "2 Min Ago"
                    ),
                    onClick = onOpenChat
                )

                Spacer(Modifier.height(18.dp))

                // Ended
                SectionTitle(text = "Ended Chats")
                Spacer(Modifier.height(10.dp))

                val ended = listOf(
                    SupportChatUi(
                        id = "end-1",
                        title = "Help Center",
                        subtitle = "Your account is ready to use…",
                        rightPillText = "Feb 08 · 2024"
                    ),
                    SupportChatUi(
                        id = "end-2",
                        title = "Support Assistant",
                        subtitle = "Hello! I'm here to assist you",
                        rightPillText = "Dec 24 · 2023"
                    ),
                    SupportChatUi(
                        id = "end-3",
                        title = "Support Assistant",
                        subtitle = "Hello! I'm here to assist you",
                        rightPillText = "Sep 10 · 2023"
                    ),
                    SupportChatUi(
                        id = "end-4",
                        title = "Help Center",
                        subtitle = "Hi, how are you today?",
                        rightPillText = "June 12 · 2023"
                    )
                )

                ended.forEachIndexed { index, chat ->
                    ChatRow(chat = chat, onClick = onOpenChat)
                    if (index != ended.lastIndex) {
                        Spacer(Modifier.height(12.dp))
                    }
                }

                Spacer(Modifier.height(24.dp))

                Button(
                    onClick = onStartNewChat,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .align(Alignment.CenterHorizontally)
                        .height(48.dp),
                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CaribbeanGreen,
                        contentColor = Void
                    )
                ) {
                    Text(
                        text = "Start Another Chat",
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(Modifier.height(24.dp))
            }
        }
    )
}

/* ========================= COMPONENTES ========================= */

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        color = Void,
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    )
}

@Composable
private fun ChatRow(
    chat: SupportChatUi,
    onClick: (String) -> Unit
) {
    Surface(
        color = LightGreen,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 72.dp)
            .clickable { onClick(chat.id) }
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Leading icon (en badge Honeydew)
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Honeydew),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_bonsupport_caribbeangreen /* o el que tengas: icon_botsupport_caribbeangreen */),
                    contentDescription = null,
                    modifier = Modifier.size(45.dp)
                )
            }

            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = chat.title,
                    color = Void,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = chat.subtitle,
                    color = Void.copy(alpha = .85f),
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(Modifier.width(8.dp))

            // Right pill
            DatePill(text = chat.rightPillText)
        }
    }
}

@Composable
private fun DatePill(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Honeydew)
            .padding(horizontal = 10.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Void.copy(alpha = .8f),
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp
        )
    }
}

/* ============================================== */

@Preview(showBackground = true, name = "Online Support")
@Composable
private fun Preview_OnlineSupport() {
    val nav = rememberNavController()
    A_Online_Support_Screen(
        navController = nav,
        onBack = {},
        onStartNewChat = {},
        onOpenChat = {}
    )
}
