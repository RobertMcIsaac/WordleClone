# Kotlin Wordle Clone

A **Wordle-inspired word-guessing game** built with **Kotlin** and **Jetpack Compose** in **Android Studio**. This project was created as the final assignment for a mobile development module at the Makers Software Development Bootcamp. The goal was to replicate the core Wordle gameplay with 5-letter words and 6 lives, all within a 3-day timeframe as part of a 3-person team.

---

## Table of Contents
- [Overview](#overview)
- [Screenshots](#screenshots)
- [Key Features](#key-features)
- [Project Structure](#project-structure)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Future Plans](#future-plans)
- [Authors](#authors)

---

## Overview
**Kotlin Wordle Clone** provides a quick, fun word-guessing experience on Android devices. Users are presented with 6 rows (representing their 6 “lives”) to guess a 5-letter word. Each row is color-coded after submission:
- **Green**: Correct letter, correct position  
- **Orange**: Correct letter, wrong position  
- **Red**: Letter not in the word  

Once a user guesses the correct word, they advance to the next word in a predefined list. If they run out of lives, the game ends and reveals whether they have remaining words to guess.

This was originally built as a short demonstration project (3 days) to practice **Kotlin**, **Jetpack Compose**, and basic Android development concepts.

---

## Screenshots
Below are example screenshots showing the app’s main screen with color-coded feedback:

| Early Guess | Later Guess |
| --- | --- |
| ![Screenshot1](https://i.ibb.co/R2kvYnN/crowd-cheat.png) | ![Screenshot2](https://i.ibb.co/99wX0YM/crowd-cheat-china.png) |

*(Images are representative; please use your own hosting or repository paths if you prefer.)*

---

## Key Features
- **5-Letter Word Logic**: Users guess a fixed 5-letter word.
- **6 Lives**: Each incorrect row submission uses up one life.
- **Color Feedback**: Letters update to green, orange, or red.
- **Basic Word List**: A small hardcoded list (`china`, `smart`, `cloud`, `maker`, etc.) is used for demonstration.
- **Jetpack Compose UI**: Renders the grid, letters, and on-screen keyboard.
- **Live Data Handling**: Uses a `ViewModel` (`WordGuessViewModel`) to track guesses, lives, and words left.

---

## Project Structure
Notable files and folders:
app/ ┣ manifests/ ┃ ┗ AndroidManifest.xml ┣ kotlin+java/ ┃ ┗ com.example.word_guess/ ┃ ┣ ui.theme/ ┃ ┃ ┣ Color.kt ┃ ┃ ┣ LetterBox.kt ┃ ┃ ┣ Theme.kt ┃ ┃ ┗ Type.kt ┃ ┣ MainActivity.kt ┃ ┗ WordGuessViewModel.kt ┣ res/ ┃ ┣ drawable/ ┃ ┣ mipmap/ ┃ ┣ values/ ┃ ┗ xml/ ┣ build.gradle.kts (Module-level) ┗ build.gradle.kts (Project-level)

- `WordGuessViewModel.kt` contains the core game logic (handling letters, checking guesses, color coding).
- `MainActivity.kt` is the primary entry point, setting up the Compose UI.
- `ui.theme/` holds Compose UI styling components (colors, theming, etc.).

---

## Requirements
- **Android Studio** (Electric Eel/2022.1.1 or newer recommended)
- **Kotlin** (bundled with latest Android Studio versions)
- **Jetpack Compose** support (included in recent Android Studio releases)
- A device or emulator running **Android API Level 21** (Lollipop) or higher *(check your `build.gradle.kts` for exact minSdkVersion)*

---

## Installation
1. **Clone the Repository**  
   ```bash
   git clone https://github.com/YourUsername/KotlinWordleClone.git
   cd KotlinWordleClone

2. **Open in Android Studio**
- Launch Android Studio.
- File > Open… and select the cloned folder.
- Let Gradle sync and download required dependencies.

3. **Check/Modify the minSdk and targetSdk**
- Open ```build.gradle.kts``` (module-level) to confirm or change your minimum and target SDK versions if necessary.

---

## Usage
1. **Run the App**
- Connect an Android device or start an emulator.
- In Android Studio, click the green “Run” button (or **Run > Run ‘app’**).
- The app should install and launch automatically.

2. **Gameplay**
- Use the on-screen keyboard to guess a 5-letter word.
- After each guess, letters turn **green**, **orange**, or **red**.
- You have 6 attempts (lives). Lose a life each time you guess incorrectly.
- If you guess the target word correctly, you move on to the next word in the list.
- If you run out of lives, the game ends.

3. **End of Game**
- If you guess all words in the list, you win. If you run out of lives first, you lose.
- The game then resets or can be restarted using the provided logic in ```WordGuessViewModel```.

---

## Future Plans
- Additional Word Validation: Possibly integrating a dictionary or a larger word list.
- Enhanced UI/UX: Better animations, transitions, or hints.
- Testing: Implement Espresso (UI tests) or unit tests for WordGuessViewModel.
- Persistence: Store game progress (e.g., current word, guesses) via SharedPreferences or Room DB.

---

## Authors
This project was developed as a team effort for a Makers Bootcamp module:

- Avnita Bhandal
- Robert McIsaac
- Tom England

---

Enjoy the Game! If you have any suggestions or find any bugs, please open an issue or submit a pull request. Have fun guessing!
