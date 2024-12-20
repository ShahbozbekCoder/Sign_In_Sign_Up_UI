package uz.shahbozbek.signInSignUpUI

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.shahbozbek.lesson6.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(myNavController: NavController) {

    val password = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val isPasswordVisible = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Log In",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Hi! Welcome",
            fontSize = 22.sp,
            color = Color(0xFFC4C4C4)
        )
        Spacer(modifier = Modifier.height(60.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Text(
                text = "Email Address",
                fontSize = 12.sp,
                color = Color(0xFF14304A),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))

            TextField(
                value = email.value, onValueChange = {
                    email.value = it
                },
                label = {
                    Text(
                        text = "Enter Your Email",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color(0xFFC4C4C4)
                    )
                },
                modifier = Modifier.fillMaxWidth(), colors = textFieldColors(
                    containerColor = Color.White,
                ),
                singleLine = true,
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Password",
                fontSize = 12.sp,
                color = Color(0xFF14304A),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            TextField(
                value = password.value, onValueChange = {
                    password.value = it
                },
                label = {
                    Text(
                        text = "Enter Your Password",
                        color = Color(0xFFC4C4C4),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                singleLine = true,
                maxLines = 1,
                colors = textFieldColors(
                    containerColor = Color.White,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (isPasswordVisible.value) {
                        R.drawable.baseline_visibility_off_24
                    } else {
                        R.drawable.baseline_visibility_24
                    }
                    IconButton(onClick = { isPasswordVisible.value = !isPasswordVisible.value }) {
                        Icon(
                            painter = painterResource(id = image),
                            contentDescription = null
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    myNavController.navigate("SignUpScreen")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF41C485)
                ),
            ) {
                Text(
                    text = "Log In",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Forgotten your password ?",
                fontSize = 16.sp,
                color = Color(0xFF14304A),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .padding(end = 16.dp, top = 7.dp)
                        .weight(1f)
                        .alignByBaseline()
                        .height(1.dp),
                    color = Color(0xFF000000)
                )
                Text(
                    text = "Or sign in with",
                    fontSize = 14.sp,
                    color = Color(0xFFC4C4C4),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.alignByBaseline()
                )
                HorizontalDivider(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 7.dp)
                        .weight(1f)
                        .alignByBaseline()
                        .height(1.dp),
                    color = Color(0xFF000000)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularImageButton(
                imageResId = R.drawable.apple_logo,
                contentDescription = "Apple",
            )
            Spacer(modifier = Modifier.padding(horizontal = 16.dp))
            CircularImageButton(
                imageResId = R.drawable.google_logo,
                contentDescription = "Google",
            )
            Spacer(modifier = Modifier.padding(horizontal = 16.dp))
            CircularImageButton(
                imageResId = R.drawable.fb_logo,
                contentDescription = "Facebook",
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Don't have an account ?",
            color = Color(0xFFC4C4C4),
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Create an Account",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {

            },
            color = Color(0xFF41C485),
            fontSize = 16.sp,
        )
    }
}

@Composable
fun CircularImageButton(imageResId: Int, contentDescription: String) {
    Card(
        modifier = Modifier
            .size(80.dp)
            .clickable {

            },
        shape = CircleShape,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = contentDescription,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun LoginScreenPreview() {
//    LoginScreen()
//}