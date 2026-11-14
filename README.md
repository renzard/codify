# Codify

**Learn programming. Practice coding. Build your skills.**

Codify is a free and open-source Android application designed to teach programming to beginners. It works offline and allows users to read lessons, write and run code, complete quizzes, and practice programming through interactive exercises.

The application supports English and Greek.

## Features

- **Offline learning:** Access lessons and exercises without an internet connection.
- **Python:** 44 lessons, from Hello World to object-oriented programming.
- **Linux:** 20 lessons covering commands such as `pwd`, `ls`, `grep`, pipes, and `chmod`.
- **HTML:** 59 lessons covering HTML elements, forms, media, SVG, Canvas, and Web APIs.
- **Interactive Python editor:** Write, edit, and execute Python code directly on your device.
- **HTML preview:** Preview HTML examples locally using an integrated WebView.
- **Quizzes:** Test your knowledge after completing lessons.
- **Fill-in-the-blank exercises:** Practice writing code by completing missing sections.
- **Progress tracking:** Save completed lessons and points locally on your device.
- **Multilingual interface:** Choose between English and Greek.
- **Sound effects:** Optional audio feedback for correct and incorrect answers.

## Screenshots

Screenshots of the application will be available in the repository's `fastlane/metadata` directory.

## Supported Languages

| Language | Lessons | Execution |
|---|---:|---|
| Python | 44 | Yes |
| Linux | 20 | No |
| HTML | 59 | Preview |

## Built With

- **Kotlin** – Main application language.
- **Jetpack Compose** – User interface.
- **Material Design 3** – UI components.
- **Chaquopy** – Python integration for Android.
- **WebView** – Offline HTML preview.
- **SharedPreferences** – Local progress storage.

## Privacy

Codify is designed to work offline.

- No account registration is required.
- No internet connection is required for normal learning activities.
- Learning progress is stored locally on the device.
- User code is executed locally through the integrated Python runtime.

## Installation

Download the latest available APK from the project's GitHub Releases:

[**Download Codify for Android**](https://github.com/renzard/codify/releases/latest)

## Building from Source

### Requirements

- Android Studio.
- JDK compatible with the project's Gradle configuration.
- Android SDK.
- Internet connection for the initial dependency downloads.

### Build

Clone the repository:

```bash
git clone https://github.com/renzard/codify.git
cd codify
```

Build the debug APK:

```bash
./gradlew assembleDebug
```

The generated APK will be located at:

```text
app/build/outputs/apk/debug/app-debug.apk
```

## Project Structure

```text
app/src/main/
├── java/gr/learn/programming/
│   ├── data/          Lesson and language data
│   ├── i18n/          English and Greek translations
│   ├── model/         Application data models
│   ├── python/        Python integration
│   ├── ui/            Application screens
│   ├── util/          Utility classes
│   └── viewmodel/     Application state
├── python/            Python execution runtime
└── res/               Android resources
```

## Contributing

Contributions are welcome!

You can contribute by:
- Reporting bugs.
- Suggesting new features.
- Adding programming lessons.
- Improving translations.
- Improving the user interface.

Please open an issue or submit a pull request.

## License

Codify is distributed under the GNU General Public License v3.0 (GPL-3.0).

See the [LICENSE](LICENSE) file for details.

## Project Links

- **GitHub:** https://github.com/renzard/codify
- **Issues:** https://github.com/renzard/codify/issues
- **Releases:** https://github.com/renzard/codify/releases

---

*Codify – Programming education for everyone.*
