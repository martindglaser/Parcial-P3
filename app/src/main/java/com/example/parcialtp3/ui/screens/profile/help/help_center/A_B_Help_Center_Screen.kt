package com.example.parcialtp3.ui.screens.profile.help.help_center

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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

@Composable
fun A_B_Help_Center_Screen(
    navController: NavHostController,
    onClickCustomService : () -> Unit = {}
) {
    BackgroundScaffold(
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                title = "Help & FAQS",
                navController = navController,
                onBackClick = { navController.popBackStack() }
            )
        },
        panelContent = {
            var tab by remember { mutableStateOf(HelpTab.FAQ) }
            var category by remember { mutableStateOf(HelpCategory.General) }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(Modifier.height(12.dp))

                // Switch (FAQ / Contact Us)
                HelpSegmentedSwitch(
                    selected = tab,
                    onSelect = { tab = it },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(12.dp))

                // NUEVO: Segmento de categorías
                CategorySegment(
                    selected = category,
                    onSelect = { category = it },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(12.dp))

                // Buscador
                var query by remember { mutableStateOf("") }
                TextField(
                    value = query,
                    onValueChange = { query = it },
                    placeholder = { Text("Search", fontSize = 13.sp) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(2.dp, CaribbeanGreen, RoundedCornerShape(14.dp)),
                    shape = RoundedCornerShape(14.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = LightGreen,
                        unfocusedContainerColor = LightGreen,
                        disabledContainerColor = LightGreen,
                        cursorColor = Void,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        focusedTextColor = Void,
                        unfocusedTextColor = Void,
                        focusedPlaceholderColor = Void.copy(alpha = .6f),
                        unfocusedPlaceholderColor = Void.copy(alpha = .6f)
                    )
                )

                Spacer(Modifier.height(16.dp))

                when (tab) {
                    HelpTab.FAQ -> FaqSection()
                    HelpTab.CONTACT -> ContactSection(onClickCustomService)
                }

                Spacer(Modifier.height(24.dp))
            }
        }
    )
}

/* ======================== FAQ SECTION ========================== */

@Composable
private fun FaqSection() {
    val faqs = listOf(
        "How to use FinWise?",
        "How much does it cost to use FinWise?",
        "How to contact support?",
        "How can I reset my password if I forget it?",
        "Are there any privacy or data security measures in place?",
        "Can I customize settings within the application?",
        "How can I delete my account?",
        "How do I access my expense history?",
        "Can I use the app offline?"
    )

    Column {
        faqs.forEachIndexed { i, q ->
            FaqItem(
                question = q,
                answer = "Here goes a short answer/explanation for: \"$q\"."
            )
            if (i != faqs.lastIndex) {
                Divider(
                    thickness = 1.dp,
                    color = LightGreen.copy(alpha = 0.7f),
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }
        }
    }
}

@Composable
private fun FaqItem(
    question: String,
    answer: String
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded }
            .animateContentSize()
            .padding(vertical = 6.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = question,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
                color = Void,
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = painterResource(R.drawable.icon_chevron_down),
                contentDescription = "Expand/Collapse",
                modifier = Modifier.size(14.dp)
            )
        }

        if (expanded) {
            Spacer(Modifier.height(4.dp))
            Text(
                text = answer,
                style = MaterialTheme.typography.bodyMedium,
                color = Void.copy(alpha = .85f)
            )
        }
    }
}

/* =========== Segmento “General / Account / Services” =========== */

private enum class HelpCategory { General, Account, Services }

@Composable
private fun CategorySegment(
    selected: HelpCategory,
    onSelect: (HelpCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = LightGreen,
        shape = RoundedCornerShape(18.dp),
        modifier = modifier
            .height(44.dp)
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(6.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            @Composable
            fun Seg(cat: HelpCategory, label: String) {
                val isSel = selected == cat
                Surface(
                    color = if (isSel) CaribbeanGreen else Color.Transparent,
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable { onSelect(cat) }
                ) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            text = label,
                            color = if (isSel) Color.White else Void,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            Seg(HelpCategory.General, "General")
            Seg(HelpCategory.Account, "Account")
            Seg(HelpCategory.Services, "Services")
        }
    }
}

/* ===================== CONTACT SECTION ========================= */

@Composable
private fun ContactSection(
    onClickCustomService: () -> Unit = {}
) {
    Column {
        ContactRow(
            iconRes = R.drawable.icon_bonsupport_caribbeangreen,
            label = "Customer Service",
            onClick = onClickCustomService
        )
        DividerLight()

        ContactRow(
            iconRes = R.drawable.icon_botwebsite_caribbeangreen,
            label = "Website"
        )
        DividerLight()

        ContactRow(
            iconRes = R.drawable.icon_botfacebook_caribbeangreen,
            label = "Facebook"
        )
        DividerLight()

        ContactRow(
            iconRes = R.drawable.icon_botwhatssapp_caribbeangreen,
            label = "Whatsapp"
        )
        DividerLight()

        ContactRow(
            iconRes = R.drawable.icon_botinstagram_caribbeangreen,
            label = "Instagram"
        )
    }
}

@Composable
private fun DividerLight() {
    Divider(
        thickness = 1.dp,
        color = LightGreen.copy(alpha = 0.7f),
        modifier = Modifier.padding(vertical = 6.dp)
    )
}

@Composable
private fun ContactRow(
    iconRes: Int,
    label: String,
    onClick: () -> Unit = {}
) {
    Row(
        Modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .clickable { onClick() }
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Honeydew),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(iconRes),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(Modifier.width(12.dp))

        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = Void,
            modifier = Modifier.weight(1f)
        )

        Image(
            painter = painterResource(R.drawable.icon_chevron_right),
            contentDescription = "Go",
            modifier = Modifier.size(16.dp)
        )
    }
}

/* ====================== SEGMENTED SWITCH (FAQ / CONTACT) ======================= */

private enum class HelpTab { FAQ, CONTACT }

@Composable
private fun HelpSegmentedSwitch(
    selected: HelpTab,
    onSelect: (HelpTab) -> Unit,
    modifier: Modifier = Modifier,
    height: Dp = 52.dp,
    padding: Dp = 6.dp
) {
    BoxWithConstraints(
        modifier = modifier
            .height(height)
            .clip(RoundedCornerShape(height / 2))
            .background(Honeydew)
    ) {
        val segmentWidth = (maxWidth - padding * 2) / 2
        val xOffset by animateDpAsState(
            targetValue = if (selected == HelpTab.FAQ) padding else padding + segmentWidth,
            label = "help-pill"
        )

        Box(
            Modifier
                .offset(x = xOffset, y = padding)
                .size(width = segmentWidth, height = maxHeight - padding * 2)
                .clip(RoundedCornerShape(20.dp))
                .background(CaribbeanGreen)
        )

        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SegmentTab(
                text = "FAQ",
                selected = selected == HelpTab.FAQ,
                onClick = { onSelect(HelpTab.FAQ) }
            )
            SegmentTab(
                text = "Contact Us",
                selected = selected == HelpTab.CONTACT,
                onClick = { onSelect(HelpTab.CONTACT) }
            )
        }
    }
}

@Composable
private fun RowScope.SegmentTab(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (selected) Color.Black else Void,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Medium
        )
    }
}

/* =========================== PREVIEW =========================== */

@Preview(showBackground = true, showSystemUi = true, name = "Help & FAQS")
@Composable
private fun PreviewHelpCenter() {
    A_B_Help_Center_Screen(navController = rememberNavController())
}
