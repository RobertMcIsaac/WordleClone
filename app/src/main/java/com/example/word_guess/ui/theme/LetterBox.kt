package com.example.word_guess.ui.theme

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class LetterBox(var char: MutableState<Char> = mutableStateOf('_'), // Char type for single character
                     var color: MutableState<Color> = mutableStateOf(Color.Gray)) {

}

//data class LetterBox(  char: Char = '_',
//   color: Color = Color.Gray

//) {
//
////  var observableChar by mutableStateOf(char)
////  var observableColor by mutableStateOf(color)
//
//
//}
