package uz.shahbozbek.signInSignUpUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.shahbozbek.lesson6.R


@Composable
fun SignUpScreen(myNavController: NavController) {
    val name = remember {
        mutableStateOf("")
    }
    val birthday = remember {
        mutableStateOf("")
    }
    val address = remember {
        mutableStateOf("")
    }
    val phone = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "Logo",
                modifier = Modifier
                    .clickable {
                        myNavController.popBackStack()
                    }
                    .padding(24.dp)
            )
        }
        Text(
            text = "Create Account",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center) {
            Text(
                text = "Fill your information below or register with your social account",
                fontSize = 12.sp,
                color = Color(0xFFC4C4C4),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 64.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {

            RoundedTextField(
                value = name.value,
                onValueChange = {
                    name.value = it
                },
                label = "Name",
                placeholder = "Enter Your Name"
            )
            Spacer(modifier = Modifier.height(24.dp))

            RoundedTextField(
                value = birthday.value,
                onValueChange = {
                    birthday.value = it
                },
                label = "Birthday",
                placeholder = "MM/DD/YYYY",
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_calendar_month_24),
                        contentDescription = "Calendar"
                    )
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
            RoundedTextField(
                value = address.value,
                onValueChange = {
                    address.value = it
                },
                label = "Address",
                placeholder = "Enter Your Address"
            )
            Spacer(modifier = Modifier.height(24.dp))
            RoundedTextField(
                value = phone.value,
                onValueChange = {
                    phone.value = it
                },
                label = "Phone",
                placeholder = "Enter Your Phone",
                keyboardType = KeyboardType.Phone
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    myNavController.navigate("EmailScreen")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF41C485)
                ),
            ) {
                Text(
                    text = "Next",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Divider(
                    color = Color(0xFF000000),
                    modifier = Modifier
                        .padding(end = 16.dp, top = 7.dp)
                        .weight(1f)
                        .alignByBaseline()
                        .height(1.dp)
                )
                Text(
                    text = "Or sign in with",
                    fontSize = 14.sp,
                    color = Color(0xFFC4C4C4),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.alignByBaseline()
                )
                Divider(
                    color = Color(0xFF000000),
                    modifier = Modifier
                        .padding(start = 16.dp, top = 7.dp)
                        .weight(1f)
                        .alignByBaseline()
                        .height(1.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
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

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoundedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, fontSize = 12.sp, color = Color.Black) },
        placeholder = { Text(text = placeholder, color = Color.Gray) },
        trailingIcon = trailingIcon,
        singleLine = true,
        shape = RoundedCornerShape(32.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFFCFCFCF),
            unfocusedBorderColor = Color(0xFFCFCFCF),
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
    )
}
//
//@Preview(showBackground = true)
//@Composable
//fun SignUpScreenPreview() {
//    SignUpScreen(myNavController = myNavController)
//}