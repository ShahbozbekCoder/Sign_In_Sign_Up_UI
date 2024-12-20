package uz.shahbozbek.signInSignUpUI

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.shahbozbek.lesson6.R

@Composable
fun PasswordScreen(myNavController: NavController) {
    val password = remember { mutableStateOf("") }
    val isChecked = remember { mutableStateOf(false) }
    val isPasswordVisible = remember { mutableStateOf(false) }
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Email input field
        // ...
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "Logo",
                modifier = Modifier
                    .clickable {
                        myNavController.popBackStack()
                    }
                    .padding(24.dp)
            )
            Text(
                text = "Sign Up",
                color = Color(0xFF14304A),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 24.dp, end = 60.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Create a Password ", fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF14304A),
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(horizontal = 32.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = {
                password.value = it
            },
            placeholder = {
                Text(
                    text = "Password",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color(0xFFC4C4C4)
                )
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color.Transparent),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .border(2.dp, Color(0xFFC4C4C4), CircleShape)
                    .background(
                        if (isChecked.value) Color(0xFF41C485) else Color.Transparent,
                        CircleShape
                    )
                    .clickable {
                        isChecked.value = !isChecked.value
                        isPasswordVisible.value = !isPasswordVisible.value
                    },
                contentAlignment = Alignment.Center
            ) {
                if (isChecked.value) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(Color.White, CircleShape)
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Show Password",
                fontSize = 16.sp,
                color = Color(0xFF14304A),
                modifier = Modifier.clickable {
                    isChecked.value = !isChecked.value
                })
        }
        Spacer(modifier = Modifier.height(64.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "2 of 3",
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 32.dp),
                fontWeight = FontWeight.Bold,
                color = Color(0xFF14304A),
                fontSize = 12.sp,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = { 0.67f },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .padding(horizontal = 32.dp),
            color = Color(0xFF41C485),
            trackColor = Color(0xFFF0F0F0),
            strokeCap = StrokeCap.Round
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                myNavController.navigate("VerifyScreen")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF41C485)
            ),
        ) {
            Text(
                text = "Sign Up",
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        TermsAndPrivacyText(
            onTermsClick = {
                Toast.makeText(context, "Terms of Service", Toast.LENGTH_SHORT).show()
            },
            onPrivacyClick = {
                Toast.makeText(context, "Privacy Policy", Toast.LENGTH_SHORT).show()
            }
        )
    }
}

@Composable
fun TermsAndPrivacyText(
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = buildAnnotatedString {
                append("By signing up, you agree to our ")

                // Terms of Service
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF14304A)
                    )
                ) {
                    pushStringAnnotation(tag = "TERMS", annotation = "terms")
                    append("Terms of Service")
                    pop()
                }

                append(" and ")

                // Privacy Policy
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF14304A)
                    )
                ) {
                    pushStringAnnotation(tag = "PRIVACY", annotation = "privacy")
                    append("Privacy Policy")
                    pop()
                }
            },
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            lineHeight = 20.sp,
            modifier = Modifier.clickable {
                // Ma'lum tag bosilganda amal bajarish
                onTermsClick()
                onPrivacyClick()
            }
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PasswordScreenPreview() {
//    PasswordScreen()
//}