package gr.learn.programming.i18n

import gr.learn.programming.data.languagesEn
import gr.learn.programming.data.lessonsEn
import gr.learn.programming.model.Language
import gr.learn.programming.model.Lesson

object EnglishStrings : Strings {
    override val languageCode = "en"
    override val lessonList: List<Lesson> = lessonsEn
    override val programmingLanguages: List<Language> = languagesEn

    // Common
    override val back = "Back"
    override val cancel = "Cancel"
    override val resetAction = "Reset"
    override val menu = "Menu"
    override val settings = "Settings"

    // Programming language selection
    override val chooseProgrammingLanguageTitle = "Choose a Language"
    override val whichLanguageQuestion = "Which programming language do you want to learn?"
    override val pickLanguageToStart = "Pick a language to start the interactive lessons."
    override fun lessonCount(count: Int) = if (count == 1) "1 lesson" else "$count lessons"
    override val select = "Select"

    // Lesson list
    override val lessons = "Lessons"
    override val resetProgress = "Reset progress"
    override val resetProgressConfirmShort = "All your completed lessons and points will be deleted. Continue?"
    override val yourProgress = "Your progress"
    override fun lessonsCompleted(done: Int, total: Int) = "$done of $total lessons completed"
    override fun pointsLabel(score: Int) = "Points: $score"
    override val completed = "Completed"
    override val locked = "Locked"
    override fun completePrevious(previousTitle: String) = "Complete the lesson “$previousTitle” first!"

    // Lesson
    override val startQuiz = "Start the Quiz"
    override val codeExample = "Code example"
    override val running = "Running…"
    override val run = "Run"
    override val restore = "Reset code"
    override val unknownError = "Unknown error"

    // Code box
    override val codeEditorHeader = "Python · you can edit the code"
    override val output = "Output"
    override val noOutput = "(the code printed nothing)"
<<<<<<< HEAD
    override val sampleOutputTitle = "Sample output"
    override val preview = "Preview"
    override val previewTitle = "Result"
    override val notRunnableHint = "These commands run in a Linux terminal, not inside the app. Try them on your computer."
    override fun editorHeader(languageName: String) = "$languageName · you can edit the code"
=======
>>>>>>> 631cd6e1e97d010cb81b07551d6836e85c298b6c

    // Quiz
    override val correctAnswer = "Correct answer!"
    override val wrongAnswer = "Wrong answer. Try again!"
    override val tryAgain = "Try again"
    override val finishLesson = "Complete lesson"
    override val nextStep = "Continue"

    // Fill in the blanks
    override val fillBlankTitle = "Fill in the blanks"
    override val fillBlankInstruction = "Fill in the blanks so the code works correctly."
    override val checkAnswers = "Check"
    override val fillBlankCorrect = "Well done! Everything is correct!"
    override val fillBlankWrong = "Some blanks are wrong. Try again!"

    // Messages (Toast)
    override val lessonLocked = "This lesson is locked!"
    override fun lessonCompletedAgain(title: String) = "You completed the lesson “$title” again!"
    override fun lessonCompletedFirst(title: String) = "Well done! (+10 points) You completed the lesson “$title”."

    // Settings
    override val appLanguageSection = "App language"
    override val appLanguageDescription = "Choose the language of the app's menus and messages."
    override val soundSection = "Sound & Effects"
    override val appSounds = "App sounds"
    override val appSoundsDescription = "Sound effects for correct and wrong quiz answers"
    override val progressSection = "Progress & Data"
    override val resetProgressTitle = "Reset Progress"
    override fun progressSummary(lessons: Int, points: Int) =
        "$lessons completed ${if (lessons == 1) "lesson" else "lessons"} · $points points"
    override val deleteProgress = "Delete progress"
    override val resetProgressConfirmLong = "All your completed lessons and points will be deleted. Are you sure?"
    override val aboutSection = "About"
    override val versionInfo = "Version 1.0.0 · Python 3.11 (Offline Runner)"
}
