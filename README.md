# Psychometrics
While taking online job interviews, I was asked questions that tested verbal reasoning, logical reasoning, and pattern recognition. I struggled to solve these questions and sought ways to improve. Through research, I learned the questions are known as psychometrics and found a book titled "Ultimate Psychometric Tests" by Mike Byron. However, I found studying with the book tedious as its questions and answers are on different pages.

Inspired by Duolingo's language lessons, I created an app that allows me to take short lessons based on the book's questions. Each lesson has 5 questions and provides immediate feedback. The lessons are a mix of question types; for instance, the first question could be a word link and the next could be common features. This approach has made my studying much more convenient.

[Figma design by me](https://www.figma.com/design/mTmVQjJffWs7gyRKGaor7c/_Psychometrics?node-id=0-1&t=kKlOWvk8vrhuFspa-1)

##Screenshots<br>
<img width="320" alt="0" src="https://github.com/kuntito/Psychometrics/assets/106985013/3c7520b6-4589-487e-b821-2ee77c4f02b1"><span>&nbsp;</span><span>&nbsp;</span>
<img width="320" alt="1" src="https://github.com/kuntito/Psychometrics/assets/106985013/a3e0ae62-ad37-4d6a-8001-3acef63fb145"><span>&nbsp;</span><span>&nbsp;</span>
<img width="320" alt="2" src="https://github.com/kuntito/Psychometrics/assets/106985013/e5ac072a-1cf6-4424-8f72-bbe07b8f4794"><span>&nbsp;</span><span>&nbsp;</span>
<img width="320" alt="3" src="https://github.com/kuntito/Psychometrics/assets/106985013/7c3ceb5f-c8d5-4c15-b65a-a8d9dc427ddc"><span>&nbsp;</span><span>&nbsp;</span> 
<img width="320" alt="4" src="https://github.com/kuntito/Psychometrics/assets/106985013/ff295b3e-8bed-4eeb-a1ea-cdd0b1d7e226"><span>&nbsp;</span><span>&nbsp;</span>


## Installation

1. Clone the repository to your local machine.

2. Open the project in Android Studio.
3. Build and run the app on an Android emulator or a physical device.


## Features
Analogy Questions: foo is to bar as jay is to ____
Antonym Questions: Provides a word and asks for the opposite.
Word Link Questions: Shows two lists of words and the user selects the words with the strongest connection.
Common Features Questions: Shows a pattern of images and provides the user options to select which option continues the sequence or has common features.

## Note
The questions on the app are not from the book as it would infringe copyrights. Dummy text questions were generated using ChatGPT, and images were downloaded from the internet. One of the image questions is from the book.

Each lesson is a random mix of question types. The number of questions per lesson can be modified in `AppViewModel`
The app is a work in progress, and more types of questions will be added in the future.

## Technologies Used
- Android Studio
- Kotlin
- Jetpack Compose
- Navigation Compose
