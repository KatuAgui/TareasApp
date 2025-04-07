package com.codingka.tareasapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room
import com.codingka.tareasapp.config.Screens
import com.codingka.tareasapp.dao.TareaDao
import com.codingka.tareasapp.db.TareaDatabase
import com.codingka.tareasapp.factory.TareaViewModelFactory
import com.codingka.tareasapp.repository.TareaRepository
import com.codingka.tareasapp.screens.AgregarTarea
import com.codingka.tareasapp.screens.EditarTarea
import com.codingka.tareasapp.screens.TareasScreen
import com.codingka.tareasapp.ui.theme.TareasAppTheme
import com.codingka.tareasapp.viewmodel.TareaViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = TareaDatabase.getDatabase(applicationContext)
        val tareaDao = db.tareaDao()
        val repository = TareaRepository(tareaDao)

        //val tareaViewModel = TareaViewModel(repository)
        val tareaViewModel = ViewModelProvider(
            this,
            TareaViewModelFactory(repository)
        ).get(TareaViewModel::class.java)

        enableEdgeToEdge()
        setContent {
            TareasAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    PrincipalNavHost(navController, tareaViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun PrincipalNavHost(navController: NavHostController, tareaViewModel: TareaViewModel) {
    NavHost(navController = navController, startDestination = Screens.TareasScreen.route) {

        composable(Screens.TareasScreen.route) {
            TareasScreen(tareaViewModel, navController)
        }

        composable(Screens.AgregarTarea.route) {
            AgregarTarea(tareaViewModel)
        }

        composable(
            Screens.EditarTarea.route,
            arguments = listOf(navArgument("tareaId") { type = NavType.LongType })
        ) { backStackEntry ->
            val tareaId = backStackEntry.arguments?.getLong("tareaId") ?: 0L
            EditarTarea(tareaViewModel, tareaId)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TareasAppTheme {
        Greeting("Katia")
    }
}