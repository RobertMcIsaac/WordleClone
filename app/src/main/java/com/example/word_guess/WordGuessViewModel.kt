package com.example.word_guess

import android.util.Log
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.ViewModel

class WordGuessViewModel : ViewModel() {

    var guessList = mutableStateListOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x" ,"y", "z")
        private set
//var guessList = KeyboardOptions(keyboardType = KeyboardType.Text)
//    private set
    var wordList = listOf("china", "smart", "cloud", "mouse", "testy", "pinch", "stuck")
        private set
    var wordCount = mutableIntStateOf(0)
        private set
    var livesCount = mutableIntStateOf(6)
        private set
    var blankArrayPosition = mutableIntStateOf(0)
        private set
    var letterposition =  mutableIntStateOf(0)
        private set
    var blankArrays = mutableStateListOf("____", "____", "____", "____", "____", "____")
        private set
    fun takeLife() {
        livesCount.value -= 1
    }
//    fun addGuess(guess: String) {
//        guessList.removeIf { letter -> letter == guess}
//    }
    fun addWordCount() {
        wordCount.value += 1
    }

    fun addLetterToArray (letter: Char) {
       var array =  blankArrays[blankArrayPosition.intValue]
        var charArray = array.toCharArray()
        charArray[letterposition.intValue] = letter
        letterposition.intValue += 1
        blankArrays[blankArrayPosition.intValue] = String(charArray)

        println(blankArrays)
    }

    fun checkArray (letter: Char) {

        addLetterToArray(letter)

//        if (letter.toString() in wordList[wordCount.intValue]) {
//            Log.e(
//                "letter in word",
//                "true"
//            )
//        }
//        else {
//            takeLife()
//        }
        wordList[wordCount.intValue].forEachIndexed { index, let ->
                Log.e(
                    "WordGuessViewModel",
                    "Index $index out of bounds for blankArray with size ${blankArrays.size}"
                )

//                if (let == letter) {
//                    blankArrays[index] = letter
//
//
//                    val checkArray: Boolean = blankArray[certsain position].all { char -> char != '_' }
//                    if (checkArray) {
//
//                        addWordCount()
//                        if blank array is empty then iterate through and do this ->
                        //  if letter in word
//                            if blankarray[index] == word[index] then letter should be green
//                            else letter is amber
//                    else letter should be red
//                        blankArray = mutableStateListOf<Char>('_', '_', '_', '_', '_')
//                        guessList = mutableStateListOf<String>(
//                            "a",
//                            "b",
//                            "c",
//                            "d",
//                            "e",
//                            "f",
//                            "g",
//                            "h",
//                            "i",
//                            "j",
//                            "k",
//                            "l",
//                            "m",
//                            "n",
//                            "o",
//                            "p",
//                            "q",
//                            "r",
//                            "s",
//                            "t",
//                            "u",
//                            "v",
//                            "w",
//                            "x",
//                            "y",
//                            "z"
//                        )

                    }
                }
            }
//        }
//        else if (letter.toString() !in wordList[wordCount]) {
//            livesCount -= 1
//        }

//    }
//}