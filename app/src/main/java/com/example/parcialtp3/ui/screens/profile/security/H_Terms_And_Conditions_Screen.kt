package com.example.parcialtp3.ui.screens.profile.security

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar

@Composable
fun H_Terms_And_Conditions_Screen(
    navController: NavHostController,
    onOpenLink: (String) -> Unit = {},
    onAccept: () -> Unit = {}
) {
    var accepted by remember { mutableStateOf(false) }
    val scroll = rememberScrollState()
    val link = "https://www.finwiseapp.de"

    BackgroundScaffold(
        navController = navController,
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                navController = navController,
                title = "Terms And Conditions",
                onBackClick = { navController.popBackStack() }
            )
        },
        panelContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .navigationBarsPadding()   // deja aire para la bottom bar
                    .padding(bottom = 16.dp)
            ) {
                Spacer(Modifier.height(8.dp)) // menos margen arriba

                /* ---------- CARD SCROLLABLE CON EL TEXTO ---------- */
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    color = Honeydew
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .verticalScroll(scroll)
                    ) {
                        Text(
                            "Est Fugiat Assumenda Aut Reprehenderit",
                            // título más chico
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            ),
                            color = Void
                        )

                        Spacer(Modifier.height(8.dp))

                        ParagraphSmall(
                            "Lorem ipsum dolor sit amet, et odio officia aut voluptate internos est amet vitae ut architecto sunt non tenetur fuga ut provident vero..."
                        )

                        NumberedListCompactSmall(
                            listOf(
                                "Ea voluptates omnis aut sequi sequi.",
                                "Est dolore quae in aliquid ducimus et autem repellendus.",
                                "Aut ipsum Quis qui porro quasi aut minus placeat!",
                                "Sit consequatur neque ab vitae facere."
                            )
                        )

                        ParagraphSmall(
                            "Aut quidem accusantium nam alias autem eum officiis placeat et omnis autem id officiis perspiciatis qui corrupti officia eum aliquam provident..."
                        )

                        BulletedListCompactSmall(
                            listOf(
                                "Aut fuga sequi eum voluptatibus provident.",
                                "Eos consequuntur voluptas vel amet eaque aut dignissimos velit."
                            )
                        )

                        ParagraphSmall(
                            "Vel exercitationem quam vel eligendi rerum At harum obcaecati et nostrum beatae? Ea accusantium dolores qui rerum aliquam est perferendis mollitia et ipsum ipsa qui enim autem At corporis sunt."
                        )

                        val annotated = buildAnnotatedString {
                            append("Read the terms and conditions in more detail at ")
                            withStyle(
                                SpanStyle(
                                    color = CaribbeanGreen,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) { append(link) }
                        }
                        Text(
                            text = annotated,
                            style = MaterialTheme.typography.bodySmall,
                            color = Void,
                            modifier = Modifier.clickable { onOpenLink(link) }
                        )
                    }
                }

                /* ---------- CHECKBOX + BOTÓN (FUERA DEL SCROLL) ---------- */
                Spacer(Modifier.height(12.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = accepted,
                        onCheckedChange = { accepted = it },
                        colors = CheckboxDefaults.colors(checkedColor = CaribbeanGreen)
                    )
                    Text(
                        "I accept all the terms and conditions",
                        style = MaterialTheme.typography.bodySmall, // texto más chico
                        color = Void
                    )
                }

                Spacer(Modifier.height(12.dp))

                Button(
                    onClick = onAccept,
                    enabled = accepted,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(0.5f)
                        .height(44.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CaribbeanGreen,
                        contentColor = Void,
                        disabledContainerColor = LightGreen,
                        disabledContentColor = Void.copy(alpha = 0.6f)
                    )
                ) {
                    Text(
                        "Accept",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }
        }
    )
}

/* -------- Helpers -------- */

@Composable
private fun ParagraphSmall(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall, // más chico
        color = Void,
        lineHeight = 16.sp
    )
    Spacer(Modifier.height(8.dp))
}

@Composable
private fun NumberedListCompactSmall(items: List<String>) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        items.forEachIndexed { idx, it ->
            Text(
                text = "${idx + 1}. $it",
                style = MaterialTheme.typography.bodySmall,
                color = Void
            )
        }
    }
    Spacer(Modifier.height(8.dp))
}

@Composable
private fun BulletedListCompactSmall(items: List<String>) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        items.forEach { it ->
            Text(
                text = "• $it",
                style = MaterialTheme.typography.bodySmall,
                color = Void
            )
        }
    }
    Spacer(Modifier.height(8.dp))
}
