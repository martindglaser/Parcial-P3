package com.example.parcialtp3.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.Void

@Composable
fun PasswordInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var showPin by remember { mutableStateOf(false) }

    Column(modifier) {
        if (label.isNotEmpty()) {
            Text(text = label, style = MaterialTheme.typography.bodyMedium, color = Void)
            Spacer(Modifier.height(6.dp))
        }

        TextField(
            value = value,
            onValueChange = { onValueChange(it.filter(Char::isDigit).take(6)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = if (showPin) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            trailingIcon = {
                val interaction = remember { MutableInteractionSource() }
                Icon(
                    painter = painterResource(if (showPin) R.drawable.eyespass_open else R.drawable.eyespass_close),
                    contentDescription = if (showPin) "Hide PIN" else "Show PIN",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(22.dp)
                        .clickable(
                            interactionSource = interaction,
                            indication = null
                        ) { showPin = !showPin }
                )
            },
            shape = RoundedCornerShape(18.dp),
            textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = LightGreen,
                unfocusedContainerColor = LightGreen,
                disabledContainerColor = LightGreen,
                cursorColor = Void,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedTextColor = Void,
                unfocusedTextColor = Void
            )
        )
    }
}
