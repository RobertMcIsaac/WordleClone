package com.example.word_guess

import android.util.Log
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class WordGuessViewModel : ViewModel() {

    var guessList = mutableStateListOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x" ,"y", "z")
        private set
    var wordList = listOf("chin", "newt", "soft", "flew")
        private set
    var wordCount = mutableIntStateOf(0)
        private set
    var livesCount = mutableIntStateOf(10)
        private set
    var blankArray = mutableStateListOf('_','_','_','_')

    fun takeLife() {
        livesCount.value -= 1
    }

    fun addGuess(guess: String) {
        guessList.removeIf { letter -> letter == guess}
    }
    fun addWordCount() {
        wordCount.value += 1
    }

    fun checkArray (letter: Char) {
        if (letter.toString() in wordList[wordCount.intValue]) {
            Log.e(
                "letter in word",
                "true"
            )
        }
        else {
            takeLife()
        }
        wordList[wordCount.intValue].forEachIndexed { index, let ->
                Log.e(
                    "WordGuessViewModel",
                    "Index $index out of bounds for blankArray with size ${blankArray.size}"
                )

                if (let == letter) {
                    blankArray[index] = letter

                    val checkArray: Boolean = blankArray.all { char -> char != '_' }
                    if (checkArray) {
                        addWordCount()
                        blankArray = mutableStateListOf<Char>('_', '_', '_', '_')
                        guessList = mutableStateListOf<String>(
                            "a",
                            "b",
                            "c",
                            "d",
                            "e",
                            "f",
                            "g",
                            "h",
                            "i",
                            "j",
                            "k",
                            "l",
                            "m",
                            "n",
                            "o",
                            "p",
                            "q",
                            "r",
                            "s",
                            "t",
                            "u",
                            "v",
                            "w",
                            "x",
                            "y",
                            "z"
                        )

                    }
                }
            }
//        }
//        else if (letter.toString() !in wordList[wordCount]) {
//            livesCount -= 1
//        }

    }
}