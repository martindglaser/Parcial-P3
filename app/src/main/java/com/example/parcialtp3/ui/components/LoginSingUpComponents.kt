package com.example.parcialtp3.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.VividBlue
import com.example.parcialtp3.ui.Void

@Composable
fun RoundedInputField(
    label: String,
    placeholder: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = LightGreen,
    textColor: Color = Color(0xFF1A1A1A),
    placeholderColor: Color = Color(0xFF7C8A86),
    labelPaddingLeft: Dp = 20.dp
) {
    var value by remember { mutableStateOf("") }

    Column(
        modifier = modifier.widthIn(max = 356.dp),
        horizontalAlignment = Alignment.Start
    ) {
        SimpleText(
            text = label,
            color = textColor,
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            modifier = Modifier.padding(start = labelPaddingLeft)
        )
        Spacer(Modifier.height(5.dp))

        Surface(
            color = backgroundColor,
            shape = RoundedCornerShape(50.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(41.dp)
                    .padding(horizontal = 40.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        color = placeholderColor,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = PoppinsFamily
                    )
                }
                BasicTextField(
                    value = value,
                    onValueChange = { value = it },
                    singleLine = true,
                    textStyle = TextStyle(color = textColor, fontSize = 15.sp),
                    cursorBrush = SolidColor(textColor),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
@Composable
fun RoundedPassInput(
    modifier: Modifier = Modifier,
    backgroundColor: Color = LightGreen,
    label: String = "Password",
    textColor: Color = Color(0xFF1A1A1A),
    placeholderColor: Color = Color(0xFF7C8A86),
    labelPaddingLeft: Dp = 20.dp,
    passPaddingLeft: Dp = 40.dp
) {
    var value by remember { mutableStateOf("") }

    Column(
        modifier = modifier.widthIn(max = 356.dp),
        horizontalAlignment = Alignment.Start
    ) {
        SimpleText(
            text = label,
            color = textColor,
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            modifier = Modifier.padding(start = labelPaddingLeft)
        )
        Spacer(Modifier.height(5.dp))

        Surface(
            color = backgroundColor,
            shape = RoundedCornerShape(50.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(41.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = "●  ●  ●  ●  ●  ●  ●  ●",
                        color = placeholderColor,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = PoppinsFamily,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = passPaddingLeft, end = 40.dp)
                    )
                }
                BasicTextField(
                    value = value,
                    onValueChange = { value = it },
                    singleLine = true,
                    textStyle = TextStyle(color = textColor, fontSize = 15.sp),
                    cursorBrush = SolidColor(textColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 40.dp, end = 40.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.eyepass),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 15.dp)
                        .size(20.dp)
                )
            }
        }
    }
}
@Composable
fun RoundedButton(
    text: String,
    modifier: Modifier = Modifier,
    width: Dp = 200.dp,
    height: Dp = 50.dp,
    backgroundColor: Color = CaribbeanGreen,
    textColor: Color = Void,
    onClick: () -> Unit = {}
) {
    Surface(
        color = backgroundColor,
        shape = RoundedCornerShape(50.dp),
        modifier = modifier
            .sizeIn(minWidth = width, minHeight = height)
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .height(height),
            contentAlignment = Alignment.Center
        ) {
            SimpleText(
                text = text,
                color = textColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
@Composable
fun FacebookGoogle(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        SimpleText("or sign up with", fontSize = 13.sp, fontWeight = FontWeight.Light)
        Spacer(Modifier.height(13.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
            )
            Spacer(Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
            )
        }
        Spacer(Modifier.height(30.dp))
        Text(
            buildAnnotatedString {
                append("Don’t have an account? ")
                withStyle(
                    style = SpanStyle(
                        color = VividBlue,
                    )
                ) {
                    append("Sign Up")
                }
            },
            fontSize = 13.sp,
            color = Void,
            fontWeight = FontWeight.Light,
            fontFamily = PoppinsFamily
        )
    }
}
@Composable
fun OtpCircleInput(
    modifier: Modifier = Modifier,
    circleSpacing: Dp = 15.dp,
    borderWidth: Dp = 3.dp,
    borderColor: Color = Color(0xFF00C19A),
    fillColor: Color = Color.Transparent,
    textColor: Color = Color(0xFF0D0D0D),
    onComplete: (String) -> Unit = {}
) {
    val length = 6
    val circleSize = 35.78.dp
    val textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold, fontFamily = PoppinsFamily)
    var value by remember { mutableStateOf("") }

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Row(horizontalArrangement = Arrangement.spacedBy(circleSpacing), verticalAlignment = Alignment.CenterVertically) {
            for (i in 0 until length) {
                val char = value.getOrNull(i)?.toString().orEmpty()
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(circleSize)
                        .background(fillColor, CircleShape)
                        .border(BorderStroke(borderWidth, borderColor), CircleShape)
                ) {
                    if (char.isNotEmpty()) {
                        Text(text = char, style = textStyle, color = textColor)
                    }
                }
            }
        }
        BasicTextField(
            value = value,
            onValueChange = { raw ->
                val digits = raw.filter { it.isDigit() }.take(length)
                value = digits
                if (digits.length == length) onComplete(digits)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            cursorBrush = SolidColor(Color.Transparent),
            textStyle = TextStyle(color = Color.Transparent),
            modifier = Modifier
                .matchParentSize()
                .clickable {}
        )
    }
}



