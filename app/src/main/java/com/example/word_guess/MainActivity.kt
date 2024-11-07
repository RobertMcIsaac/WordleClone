package com.example.word_guess

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.TransferableContent.Source.Companion.Keyboard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.InputMode.Companion.Keyboard
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.word_guess.ui.theme.Word_GuessTheme
import kotlinx.coroutines.withTimeout
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    private val viewModel: WordGuessViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Word_GuessTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(viewModel)
                    println(innerPadding)
                }
            }
        }
    }
}

@Composable
fun App(viewModel: WordGuessViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "game") {
        // Game screen route
        composable("game") {
            GameScreen(viewModel = viewModel, navController = navController)
        }
        // Results screen route
        composable("results") {
            ResultScreen(viewModel = viewModel, onNextScreen = { viewModel.resetGame();
                navController.navigate("game")  })
        }
    }
}

@Composable
fun GameScreen(viewModel: WordGuessViewModel, navController: NavController) {
    // if(!viewModel.gameFinished) {
    Column(
        modifier = Modifier
            .fillMaxSize() // Make Column take the full screen size
            .padding(16.dp), // Optional padding around the screen
        verticalArrangement = Arrangement.SpaceBetween, // Space out children vertically
        horizontalAlignment = Alignment.CenterHorizontally // Center items horizontally
    ) {
        // Place the AnswerField at the top
        AnswerField(viewModel)

        // Place the Keyboard at the bottom
        Keyboard(viewModel, navController)
    }
}

    @Composable
    fun ResultScreen(onNextScreen: () -> Unit,
        viewModel: WordGuessViewModel) {
        // Composable content for the results page
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            var score = (viewModel.wordCount.intValue.toFloat() / viewModel.wordList.size.toFloat()) * 100

            if(viewModel.wonGame){
                Text(
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp), // Adds space below this Tex,
                    style = androidx.compose.ui.text.TextStyle(
                        lineHeight = 35.sp
                    ),
                        text = "You won: \n Your score is ${score.toInt()}%")
            }else {

                Text(
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp), // Adds space below this Tex,
                    style = androidx.compose.ui.text.TextStyle(
                        lineHeight = 35.sp
                    ),
                    text = "Game Over!\n Your score is ${score.toInt()}%")
                // Add additional result information here
            }

            Button(onClick =  onNextScreen) {

                Text("Play again")
            }
        }
    }

@Composable
fun AnswerField(
    viewModel: WordGuessViewModel
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth(),

        ) {
            Text(
                text = "Lives: ${viewModel.livesCount.value}",
                fontSize = 15.sp,
                style = androidx.compose.ui.text.TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = "Words left: ${viewModel.wordList.size - viewModel.wordCount.intValue}",
                fontSize = 15.sp,
                style = androidx.compose.ui.text.TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(2.dp)
            )

        }
                viewModel.blankArrays.forEach{array ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()

                    ){
                        array.forEach{el ->
                            Log.v( "char", "${el.char}")
                            Text(
                                text = el.char.value.toString(),
                                modifier = Modifier
                                    .padding(2.dp)
                                    .background(el.color.value)
                                    .border(1.dp, Color.Black)
                                    .width(70.dp)
                                ,
                                fontSize = 80.sp,
                                textAlign = TextAlign.Center,
                                color = el.textColor.value,
                            )  }
                    }
                }
        }
    }


@Composable
fun Keyboard(viewModel: WordGuessViewModel, navController: NavController) {
    Column {
        viewModel.guessList.chunked(9).forEach{ rowLetters ->
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()

            ) {
                rowLetters.forEach {
                    letter ->
                    Text(
                        text = letter,
                        fontSize = 40.sp,
                        modifier = Modifier
//                            .border(width = 1.dp, color = Color.Black)
                            .padding(8.dp)
                            .clickable {

                                viewModel.checkArray(letter[0])
                                if (viewModel.gameFinished) {
                                    navController.navigate("results")
                                    }

                                Log.v("thing", "${viewModel.guessList.size} hello")
                            }
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//
//    Word_GuessTheme {
//        App(WordGuessViewModel())
//    }
//}
