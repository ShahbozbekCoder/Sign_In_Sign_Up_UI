package uz.shahbozbek.signInSignUpUI

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.shahbozbek.signInSignUpUI.ui.theme.Lesson6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lesson6Theme {
                MyNavigation()
            }
        }
    }
}

@Composable
fun MyNavigation() {
    val myNavController = rememberNavController()
    NavHost(navController = myNavController, startDestination = "LoginScreen") {
        composable("LoginScreen") {
            LoginScreen(myNavController)
        }
        composable("SignUpScreen") {
            SignUpScreen(myNavController)
        }
        composable("EmailScreen") {
            EmailScreen(myNavController)
        }
        composable("PasswordScreen") {
            PasswordScreen(myNavController)
        }
        composable("VerifyScreen") {
            VerifyScreen(myNavController)
        }

    }
}