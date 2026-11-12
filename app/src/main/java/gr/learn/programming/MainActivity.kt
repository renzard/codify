package gr.learn.programming

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import gr.learn.programming.data.isLessonUnlocked
import gr.learn.programming.data.fillBlanks
import gr.learn.programming.ui.FillBlankScreen
import gr.learn.programming.ui.HomeScreen
import gr.learn.programming.ui.LanguageSelectionScreen
import gr.learn.programming.ui.LessonScreen
import gr.learn.programming.ui.QuizScreen
import gr.learn.programming.ui.SettingsScreen
import gr.learn.programming.ui.theme.LearnTheme
import gr.learn.programming.viewmodel.ProgressViewModel
import gr.learn.programming.i18n.LocalStrings
import gr.learn.programming.i18n.strings

private const val HOME_ROUTE = "home/{languageId}"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTheme {
                LearnApp()
            }
        }
    }
}

@Composable
fun LearnApp(vm: ProgressViewModel = viewModel()) {
    val nav = rememberNavController()
    val context = LocalContext.current
    val progress by vm.progress.collectAsState()
    val soundEnabled by vm.soundEnabled.collectAsState()
    val appLanguage by vm.appLanguage.collectAsState()
    val s = appLanguage.strings()
    val idArg = listOf(navArgument("id") { type = NavType.StringType })
    val languageArg = listOf(navArgument("languageId") { type = NavType.StringType })

    CompositionLocalProvider(LocalStrings provides s) {
        NavHost(navController = nav, startDestination = "languages") {
            composable("languages") {
                LanguageSelectionScreen(
                    onSelectLanguage = { language -> nav.navigate("home/${language.id}") },
                    onOpenSettings = { nav.navigate("settings") },
                )
            }
            composable(HOME_ROUTE, arguments = languageArg) { entry ->
                val langId = entry.arguments?.getString("languageId")
                val language = s.programmingLanguages.firstOrNull { it.id == langId }
                    ?: s.programmingLanguages.first()
                HomeScreen(
                    language = language,
                    progress = progress,
                    onLessonClick = { nav.navigate("lesson/${it.id}") },
                    onBack = { nav.popBackStack() },
                    onReset = vm::reset,
                )
            }
            composable("settings") {
                SettingsScreen(
                    progress = progress,
                    soundEnabled = soundEnabled,
                    onBack = { nav.popBackStack() },
                    onToggleSound = vm::setSoundEnabled,
                    appLanguage = appLanguage,
                    onSelectAppLanguage = vm::setAppLanguage,
                    onResetProgress = vm::reset,
                )
            }
            composable("lesson/{id}", arguments = idArg) { entry ->
                val lessonId = entry.arguments?.getString("id")
                val lesson = s.lessonList.firstOrNull { it.id == lessonId }
                    ?: return@composable
                val categoryLessons = s.lessonList.filter { it.category == lesson.category }
                if (!isLessonUnlocked(lesson, categoryLessons, progress)) {
                    Toast.makeText(context, s.lessonLocked, Toast.LENGTH_SHORT).show()
                    nav.popBackStack()
                    return@composable
                }
                LessonScreen(
                    lesson = lesson,
                    onBack = { nav.popBackStack() },
                ) {
                    nav.navigate("quiz/${lesson.id}")
                }
            }
            composable("quiz/{id}", arguments = idArg) { entry ->
                val lessonId = entry.arguments?.getString("id")
                val lesson = s.lessonList.firstOrNull { it.id == lessonId }
                    ?: return@composable
                val categoryLessons = s.lessonList.filter { it.category == lesson.category }
                if (!isLessonUnlocked(lesson, categoryLessons, progress)) {
                    Toast.makeText(context, s.lessonLocked, Toast.LENGTH_SHORT).show()
                    nav.popBackStack()
                    return@composable
                }
                QuizScreen(
                    lesson = lesson,
                    onBack = { nav.popBackStack() },
                ) {
                    nav.navigate("fill/${lesson.id}")
                }
            }
            composable("fill/{id}", arguments = idArg) { entry ->
                val lessonId = entry.arguments?.getString("id")
                val lesson = s.lessonList.firstOrNull { it.id == lessonId }
                    ?: return@composable
                val fillBlank = fillBlanks[lesson.id]
                    ?: return@composable
                val categoryLessons = s.lessonList.filter { it.category == lesson.category }
                if (!isLessonUnlocked(lesson, categoryLessons, progress)) {
                    Toast.makeText(context, s.lessonLocked, Toast.LENGTH_SHORT).show()
                    nav.popBackStack()
                    return@composable
                }
                FillBlankScreen(
                    lesson = lesson,
                    fillBlank = fillBlank,
                    onBack = { nav.popBackStack() },
                ) {
                    val alreadyCompleted = progress.isCompleted(lesson.id)
                    vm.completeLesson(lesson.id)
                    val msg = if (alreadyCompleted) {
                        s.lessonCompletedAgain(lesson.title)
                    } else {
                        s.lessonCompletedFirst(lesson.title)
                    }
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                    nav.popBackStack("lesson/{id}", inclusive = false)
                }
            }
        }
    }
}
