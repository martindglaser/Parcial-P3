package com.example.parcialtp3.ui.screens.profile.help.online_support

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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

/* =========================== DATA ============================ */

private enum class ChatTab { ASSISTANT, HELP_CENTER }

private data class ChatMessage(
    val id: String,
    val text: String,
    val time: String,
    val fromMe: Boolean
)

/* =========================== SCREEN ============================ */

@Composable
fun B_Online_Support_Screen(
    navController: NavHostController,
) {
    var tab by remember { mutableStateOf(ChatTab.ASSISTANT) }
    var input by remember { mutableStateOf("") }

    val messages = remember(tab) {
        // Mock según la vista de referencia
        listOf(
            ChatMessage("1", "Welcome, I am your virtual assistant.", "14:00", fromMe = false),
            ChatMessage("2", "How can I help you today?", "14:00", fromMe = false),
            ChatMessage("3", "Hello! I have a question. How can I record my expenses by date?", "14:01", fromMe = true),
            ChatMessage("4", "Response to your request:\nYou can register expenses in the top menu of the homepage.", "14:03", fromMe = false),
            ChatMessage("5", "Enter the purchase information, including the date, etc.", "14:03", fromMe = false),
            ChatMessage("6", "OK, thanks a lot.", "14:05", fromMe = true),
            ChatMessage("7", "It was a pleasure to accommodate your request. See you soon!", "14:06", fromMe = false),
        )
    }

    BackgroundScaffold(
        navController = navController,
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                title = "Online Support",
                navController = navController,
                onBackClick = { navController.popBackStack() },
            )
        },
        panelContent = {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(Modifier.height(12.dp))

                // Tabs
                ChatTabs(
                    selected = tab,
                    onSelect = { tab = it },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(12.dp))

                // Messages
                val listState = rememberLazyListState()
                LaunchedEffect(messages.size) {
                    // scrollear al final cada vez que cambian los mensajes
                    if (messages.isNotEmpty()) listState.scrollToItem(messages.lastIndex)
                }

                Box(modifier = Modifier.weight(1f)) {
                    LazyColumn(
                        state = listState,
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(vertical = 8.dp)
                    ) {
                        items(messages, key = { it.id }) { msg ->
                            MessageBubble(message = msg)
                        }

                        // "Chat Ended" pill (opcional)
                        item {
                            Spacer(Modifier.height(4.dp))
                            EndPill(text = "14:06  |  Chat Ended")
                        }
                    }
                }

                Spacer(Modifier.height(8.dp))

                // Input bar
                ChatInputBar(
                    value = input,
                    onValueChange = { input = it },
                    onAttach = {},
                    onVoice = {},
                    onSend = {}
                )

                Spacer(Modifier.height(16.dp))
            }
        }
    )
}

/* ========================= COMPONENTES ========================= */

@Composable
private fun ChatTabs(
    selected: ChatTab,
    onSelect: (ChatTab) -> Unit,
    modifier: Modifier = Modifier,
    height: Dp = 46.dp,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(Honeydew)
            .height(height)
            .padding(6.dp)
    ) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            @Composable
            fun TabItem(tab: ChatTab, label: String) {
                val isSel = selected == tab
                Surface(
                    color = if (isSel) CaribbeanGreen else Color.Transparent,
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable { onSelect(tab) }
                ) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            text = label,
                            fontFamily = poppinsFamily,
                            fontWeight = if (isSel) FontWeight.SemiBold else FontWeight.Medium,
                            color = Void,
                            fontSize = 13.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            TabItem(ChatTab.ASSISTANT, "Support Assistant")
            TabItem(ChatTab.HELP_CENTER, "Help Center")
        }
    }
}

@Composable
private fun MessageBubble(message: ChatMessage) {
    val bubbleColor = if (message.fromMe) CaribbeanGreen else LightGreen
    val textColor = Void

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (message.fromMe) Alignment.End else Alignment.Start
    ) {
        Surface(
            color = bubbleColor,
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier
                .widthIn(min = 80.dp, max = 280.dp)
        ) {
            Text(
                text = message.text,
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                color = textColor,
                fontFamily = poppinsFamily,
                fontSize = 13.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Spacer(Modifier.height(4.dp))
        Text(
            text = message.time,
            color = Void.copy(alpha = .6f),
            fontFamily = poppinsFamily,
            fontSize = 11.sp,
            modifier = Modifier.padding(horizontal = 6.dp)
        )
    }
}

@Composable
private fun EndPill(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(LightGreen),
        ) {
            Text(
                text = text,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                color = Void.copy(alpha = .75f),
                fontFamily = poppinsFamily,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun ChatInputBar(
    value: String,
    onValueChange: (String) -> Unit,
    onAttach: () -> Unit,
    onVoice: () -> Unit,
    onSend: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Contenedor principal VERDE (pill)
    Surface(
        color = CaribbeanGreen,
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icono izquierda (cámara/adjunto) en badge claro
            ActionSquare(
                icon = R.drawable.icon_camera_honeydew,
                onClick = onAttach,
                container = Honeydew,
                content = CaribbeanGreen
            )

            Spacer(Modifier.width(8.dp))

// Campo de texto BLANCO
            Surface(
                color = Color.White,
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(44.dp)
            ) {
                // Usamos BasicTextField para controlar el padding exacto
                androidx.compose.foundation.text.BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontFamily = poppinsFamily,
                        fontSize = 13.sp,
                        color = Void
                    ),
                    cursorBrush = androidx.compose.ui.graphics.SolidColor(Void),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp, vertical = 10.dp), // <-- centra visualmente
                    decorationBox = { inner ->
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart) {
                            if (value.isEmpty()) {
                                Text(
                                    "Write here…",
                                    fontFamily = poppinsFamily,
                                    color = Void.copy(alpha = .5f),
                                    fontSize = 13.sp
                                )
                            }
                            inner()
                        }
                    }
                )
            }


            Spacer(Modifier.width(8.dp))

            // Iconos derecha en badges claros
            ActionSquare(
                icon = R.drawable.icon_microphone_honeydew,
                onClick = onVoice,
                container = Honeydew,
                content = CaribbeanGreen
            )
            Spacer(Modifier.width(6.dp))
            ActionSquare(
                icon = R.drawable.icon_send_honeydew,
                onClick = onSend,
                container = Honeydew,
                content = CaribbeanGreen
            )
        }
    }
}


@Composable
private fun ActionSquare(
    icon: Int,
    onClick: () -> Unit,
    container: Color = Honeydew,
    content: Color = CaribbeanGreen
) {
    Surface(
        color = container,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .size(35.dp)
            .clickable { onClick() }
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        }
    }
}

/* =========================== PREVIEW =========================== */

@Preview(showBackground = true, showSystemUi = true, name = "Online Support - Chat")
@Composable
private fun Preview_B_Online_Support() {
    B_Online_Support_Screen(
        navController = rememberNavController(),
    )
}
