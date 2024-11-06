package com.example.word_guess

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.word_guess.ui.theme.Word_GuessTheme

class MainActivity : ComponentActivity() {
    private val viewModel: WordGuessViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun App(viewModel: WordGuessViewModel) {
    if(!viewModel.answerisTrue) {
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
            Keyboard(viewModel)
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
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Lives: ${viewModel.livesCount.value}",
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = "Words: ${viewModel.wordCount.value}",
                modifier = Modifier.padding(2.dp)
            )

        }
                viewModel.blankArrays.forEach{array ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()

                    ){
                        array.forEach{el ->
                            Log.v( "char", "${el.char}")
                            Text(
                                text = el.char.value.toString(),
                                modifier = Modifier.padding(2.dp)
                                ,
                                fontSize = 80.sp,
                                color = el.color.value,
                            )  }
                    }
                }



        }
    }


@Composable
fun Keyboard(viewModel: WordGuessViewModel) {
//    var alphabet = mutableListOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x" ,"y", "z")
    Column {
        viewModel.guessList.chunked(9).forEach{ rowLetters ->
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()

            ) {
                rowLetters.forEach {
                    letter ->
                    Text(
                        text = letter.uppercase(),
                        modifier = Modifier
//                            .border(width = 1.dp, color = Color.Black)
                            .padding(8.dp)
                            .clickable {


                                viewModel.checkArray(letter[0])

                                Log.v("thing", "${viewModel.guessList.size} hello")
                            }

                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    Word_GuessTheme {
        App(WordGuessViewModel())
    }
}
