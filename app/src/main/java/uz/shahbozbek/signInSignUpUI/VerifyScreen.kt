package uz.shahbozbek.signInSignUpUI

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.shahbozbek.lesson6.R

@Composable
fun VerifyScreen(myNavController: NavController) {
    val otpLength = 4
    val otpInputs = remember { mutableListOf("", "", "", "") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
        Spacer(modifier = Modifier.height(32.dp))
//        Text(
//            text = "Verify OTP", fontSize = 28.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color(0xFF14304A),
//            textAlign = TextAlign.Start,
//            modifier = Modifier.padding(horizontal = 32.dp)
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Text(
//            text = "Please enter the code we sent you to email",
//            fontSize = 14.sp,
//            color = Color(0xFFC4C4C4)
//        )
//        Spacer(modifier = Modifier.height(32.dp))
//
//        Row(
//            horizontalArrangement = Arrangement.SpaceEvenly,
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            for (i in 0 until otpLength) {
//                OutlinedTextField(
//                    value = otpInputs[i],
//                    onValueChange = { newValue ->
//                        otpInputs[i] = newValue
//                        if (newValue.length == 1) {
//                            otpInputs[i] = newValue
//                        }
//                    },
//                    singleLine = true,
//                    shape = RoundedCornerShape(8.dp),
//                    modifier = Modifier
//                        .size(60.dp)
//                        .padding(4.dp),
//                    textStyle = LocalTextStyle.current.copy(
//                        fontSize = 20.sp,
//                        fontWeight = FontWeight.Bold,
//                        textAlign = TextAlign.Center
//                    ),
//                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                    colors = OutlinedTextFieldDefaults.colors(
//                        focusedBorderColor = Color(0xFFD9D9D9),
//                        unfocusedBorderColor = Color(0xFFD9D9D9)
//                    )
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//            }
//        }
        VerifyOtpScreen()
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Didn't Receive OTP ?",
            fontSize = 16.sp,
            color = Color(0xFFC4C4C4)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Resend Code",
            color = Color(0xFF41C485),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {
//                myNavController.navigate("EmailScreen")
            }
        )
        Spacer(modifier = Modifier.height(32.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "3 of 3",
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
            progress = { 1f },
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
                Toast.makeText(
                    myNavController.context,
                    "Verified",
                    Toast.LENGTH_SHORT
                ).show()
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
                text = "Verify",
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
@Composable
fun VerifyOtpScreen() {
    // Har bir TextField uchun kodni saqlash
    val otpValues = remember { mutableStateListOf("", "", "", "") }

    // FocusRequester har bir TextField uchun
    val focusRequesters = List(4) { FocusRequester() }

    // UI-ni yaratish
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Verify OTP",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp),
            color = Color(0xFF14304A),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Please enter the code we sent you to email",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 24.dp),
            color = Color(0xFFC4C4C4)
        )

        // TextFieldlar uchun qator
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            (0..3).forEach { index ->
                OutlinedTextField(
                    value = otpValues[index],
                    onValueChange = { value ->
                        if (value.length <= 1 && value.all { it.isDigit() }) {
                            otpValues[index] = value
                            // Keyingi TextFieldga o'tish
                            if (value.isNotEmpty() && index < 3) {
                                focusRequesters[index + 1].requestFocus()
                            }
                        }
                    },
                    singleLine = true,
                    textStyle = LocalTextStyle.current.copy(
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    ),
                    modifier = Modifier
                        .width(60.dp)
                        .focusRequester(focusRequesters[index]),
                    shape = RoundedCornerShape(8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = if (index == 3) ImeAction.Done else ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            if (index < 3) focusRequesters[index + 1].requestFocus()
                        },
                        onDone = {
                            // Oxirgi TextFielddan oxirgi tugmani bosish
                            focusRequesters[index].freeFocus()
                        }
                    )
                )
            }
        }
    }
}
