package com.example.word_guess

import android.util.Log
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.ViewModel
import com.example.word_guess.ui.theme.LetterBox

class WordGuessViewModel : ViewModel() {

    var guessList = mutableStateListOf(
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
    var letterposition = mutableIntStateOf(0)
        private set
    var answerisTrue: Boolean = false
        private set
    //  var blankArrays = mutableStateListOf("____", "____", "____", "____", "____", "____")
    var blankArrays = mutableStateListOf(
        mutableStateListOf(LetterBox(), LetterBox(), LetterBox(), LetterBox(), LetterBox()),
        mutableStateListOf(LetterBox(), LetterBox(), LetterBox(), LetterBox(), LetterBox()),
        mutableStateListOf(LetterBox(), LetterBox(), LetterBox(), LetterBox(), LetterBox()),
        mutableStateListOf(LetterBox(), LetterBox(), LetterBox(), LetterBox(), LetterBox()),
        mutableStateListOf(LetterBox(), LetterBox(), LetterBox(), LetterBox(), LetterBox()),
        mutableStateListOf(LetterBox(), LetterBox(), LetterBox(), LetterBox(), LetterBox())
    )
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

    fun addLetterToArray(letter: Char) {
        println("blankArrays[blankArrayPosition.intValue] " + blankArrays[blankArrayPosition.intValue])
        var array = blankArrays[blankArrayPosition.intValue]
//        var charArray = array.toCharArray()
        array[letterposition.intValue].char.value = letter
//        blankArrays[blankArrayPosition.intValue] = String(charArray)
        letterposition.intValue += 1
        println(blankArrays)
    }

    fun checkArray(letter: Char) {

        addLetterToArray(letter)

        val checkArray: Boolean =
            blankArrays[blankArrayPosition.intValue].all { char -> char.char.value != '_' }

        println("checkArray " + checkArray)

        if (checkArray) {
        var answer = ""
            val targetWord = wordList[wordCount.intValue]
            letterposition.intValue = 0
            for (index in 0..4) {
                val currentLetter = blankArrays[blankArrayPosition.intValue][index].char.value

                answer +=  currentLetter

                // Check if the current letter is in the target word
                if (currentLetter in targetWord) {
                    // Check if the letter is in the correct position
                    if (currentLetter == targetWord[index]) {
                        blankArrays[blankArrayPosition.intValue][index].color.value = Color.Green
                    } else {
                        blankArrays[blankArrayPosition.intValue][index].color.value = Color.Yellow
                    }
                } else {
                    // Letter is not in the target word
                    blankArrays[blankArrayPosition.intValue][index].color.value = Color.Red
                }
            }
            if(answer == targetWord){
                // if wordlist position = wordlist.length - the answerisTrue will be true
                // navigates to the last page which displays the final score
                //else continue with wordslist
                    //i.e. resets the arrays to _____ and blankarrayposition

                answerisTrue = true
            }
            blankArrayPosition.intValue += 1
        }

//            wordList[wordCount.intValue].forEachIndexed { index, let ->
//                if (blankArrays[blankArrayPosition.intValue][index].char.value in wordList[wordCount.intValue]){
//                    if(blankArrays[blankArrayPosition.intValue][index].char.value == wordList[wordCount.intValue][index]){
//                        blankArrays[blankArrayPosition.intValue][index].color.value = Color.Green
//                }else{
//                        blankArrays[blankArrayPosition.intValue][index].color.value = Color.Yellow
//            }
//        } else{
//                    blankArrays[blankArrayPosition.intValue][index].color.value = Color.Red
//        }

//        if blank array is empty then iterate through and do this ->
//                        //  if letter in word
////                            if blankarray[index] == word[index] then letter should be green
////                            else letter is amber
////                    else letter should be red

//            wordList[wordCount.intValue].forEachIndexed { index, let ->
//                Log.e(
//                    "WordGuessViewModel",
//                    "Index $index out of bounds for blankArray with size ${blankArrays.size}"
//                )
//                if (let in blankArrays[blankArrayPosition.intValue]) {
//                    if (blankArrays[blankArrayPosition.intValue][index] == wordList[wordCount.intValue][index]) {
//                        blankArrays[blankArrayPosition.intValue][index].
//
//                    }
//                }
//
//            }
//
//        }
//  if blank array is empty then iterate through and do this ->
//                        //  if letter in word
////                            if blankarray[index] == word[index] then letter should be green
////                            else letter is amber
////                    else letter should be red

//        if (letter.toString() in wordList[wordCount.intValue]) {
//            Log.e(
//                "letter in word",
//                "true"
//            )
//        }
//        else {
//            takeLife()
//        }

//                if (let == letter) {
//                    blankArrays[index] = letter
//
//
//                    val checkArray: Boolean = blankArray[certsain position].all { char -> char != '_' }
//                    if (checkArray) {
//
//                        addWordCount()
//
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
//        }
//        else if (letter.toString() !in wordList[wordCount]) {
//            livesCount -= 1
//        }

//    }
//}