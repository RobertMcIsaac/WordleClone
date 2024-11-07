package com.example.word_guess.ui.theme

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class LetterBox(var char: MutableState<Char> = mutableStateOf(' '), // Char type for single character
                     var color: MutableState<Color> = mutableStateOf(Color.White),
                     var textColor: MutableState<Color> = mutableStateOf(Color.Black)) {

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
