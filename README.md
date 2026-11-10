# Codify

Codify is an offline Android app that teaches programming to beginners. Each lesson explains a concept, lets you edit and run the example code right on your phone, then tests you with a quiz and a fill-in-the-blank code exercise.

Right now it teaches **Python** (44 lessons, from "Hello, world!" to object-oriented programming), in **English** and **Greek**.

## Tested on

The app has been tested on a **Samsung Galaxy Z Flip 4**.

## Features

- **44 Python lessons**, unlocked one by one as you complete them.
- **Run code in the app**: edit the example and press Run. Python 3.11 runs on the phone through [Chaquopy](https://chaquo.com/chaquopy/), with no internet needed. Code is limited to 3 seconds so an endless loop can't freeze the app.
- **Quiz** at the end of every lesson.
- **Fill-in-the-blank test** after the quiz: the lesson's code is shown with gaps and you type the missing parts. Wrong gaps turn red, correct ones turn green. The lesson is completed (+10 points) only when every gap is correct.
- **Progress and points** saved on the device.
- **App language**: English or Greek, selectable in Settings.
- **Sound effects** for right and wrong answers (can be turned off in Settings).

## Built with

- Kotlin + Jetpack Compose (Material Design 3)
- Chaquopy (Python 3.11 on Android)
- SharedPreferences for saving progress

## How to run

1. Install **Android Studio** (Koala 2024.1.1 or newer) and open this folder with `File > Open`.
2. Wait for the Gradle sync. The first time it downloads Chaquopy and the Python runtime, so your computer needs internet **once**. The app on the phone never needs internet.
3. Pick a phone (with USB debugging) or an emulator and press **Run ▶**.

If the build asks for Python on your computer, install Python 3.11 or 3.12 and add `buildPython("/path/to/python3")` inside `chaquopy { defaultConfig { ... } }` in `app/build.gradle.kts`.

### Build an APK

- Android Studio: `Build > Build Bundle(s) / APK(s) > Build APK(s)`
- or from a terminal: `./gradlew assembleDebug`, which produces `app/build/outputs/apk/debug/app-debug.apk`

## Notes

- Don't upgrade only the Android Gradle Plugin. Chaquopy supports specific AGP versions, so if you upgrade AGP, upgrade the `com.chaquo.python` plugin version in the root `build.gradle.kts` too.
- Supported architectures: `arm64-v8a` (almost all modern phones) and `x86_64` (emulators). For old 32-bit phones add `"armeabi-v7a"` to `abiFilters`.
- The APK is fairly large (about 20–30 MB) because it contains the whole Python interpreter.
- User code does **not** run in a sandbox. It has time and output limits, but no permission restrictions. That is fine for learning on your own device.
- `input()` is not supported in the code runner (the app shows a message instead).

## Project structure

```
app/src/main/
  python/runner.py                       runs the user's code (time and output limits)
  java/gr/learn/programming/
    App.kt                               starts Python
    MainActivity.kt                      navigation: languages > home > lesson > quiz > fill-in-the-blanks
    python/PythonRunner.kt               Kotlin > Python bridge
    model/Models.kt                      Lesson, Quiz, FillBlank, UserProgress
    data/LanguagesData.kt                available programming languages
    data/LessonsData.kt                  the 44 lessons (Greek)
    data/LessonsDataEn.kt                the 44 lessons (English)
    data/FillBlanksData.kt               fill-in-the-blank exercises, keyed by lesson id
    data/ProgressRepository.kt           saving progress
    viewmodel/ProgressViewModel.kt       progress, sound and language state
    i18n/                                app texts for each language
    ui/                                  language selection, home, lesson, quiz, fill-in-the-blanks, settings, code box, theme
```

## Adding content

- **New lesson**: add a `Lesson(...)` to both `LessonsData.kt` and `LessonsDataEn.kt` with the same unique `id` (never change an `id` later), then add its exercise to `FillBlanksData.kt` using that `id`.
- **Fill-in-the-blank exercise**: write the code with `___` for each gap, then list the accepted answers for each gap in order. Every lesson needs one, otherwise its last step will be empty.
- **New programming language**: add a `Language(...)` to `LanguagesData.kt` and lessons whose `category` matches the language `name`.
- **New app language**: add a value to `AppLanguage`, a new `Strings` implementation, and the lessons for it.

## App icon

- `res/mipmap-*/ic_launcher*.png`: icons for Android 7.x (API 24–25).
- `res/drawable-nodpi/ic_launcher_foreground.png` + `res/mipmap-anydpi-v26/`: adaptive icon for Android 8+.
- `app_icon_512.png` (512×512): for the Play Store, if you ever publish there.
