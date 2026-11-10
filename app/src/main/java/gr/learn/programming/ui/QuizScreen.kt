package gr.learn.programming.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import gr.learn.programming.model.Lesson
import gr.learn.programming.util.SoundManager
import gr.learn.programming.i18n.LocalStrings

private val GreenBg = Color(0xFFE8F5E9)
private val GreenFg = Color(0xFF1B5E20)
private val RedBg = Color(0xFFFFEBEE)
private val RedFg = Color(0xFFB71C1C)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(lesson: Lesson, onBack: () -> Unit, onFinish: () -> Unit) {
    val quiz = lesson.quiz
    // Τυχαία σειρά απαντήσεων: ανακατεύεται μία φορά όταν ανοίγει το quiz και μένει σταθερή (και στην περιστροφή οθόνης)
    val order = rememberSaveable(lesson.id) { ArrayList(quiz.options.indices.shuffled()) }
    val options = order.map { quiz.options[it] }
    val correctIndex = order.indexOf(quiz.correctOptionIndex)
    val (selected, setSelected) = rememberSaveable(lesson.id) { mutableStateOf<Int?>(null) }
    val answered = selected != null
    val isCorrect = selected == correctIndex
    val s = LocalStrings.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Quiz") },
                navigationIcon = {
                    IconButton(onClick = { SoundManager.playClick(); onBack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = s.back)
                    }
                },
            )
        },
        bottomBar = {
            Surface(tonalElevation = 3.dp) {
                Column(
                    Modifier
                        .navigationBarsPadding()
                        .padding(horizontal = 20.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    if (answered) {
                        Text(
                            if (isCorrect) s.correctAnswer else s.wrongAnswer,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = if (isCorrect) Color(0xFF2E7D32) else Color(0xFFC62828),
                        )
                    }
                    if (answered && !isCorrect) {
                        FilledTonalButton(
                            onClick = { SoundManager.playClick(); setSelected(null) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                        ) { Text(s.tryAgain) }
                    } else {
                        Button(
                            onClick = {
                                SoundManager.playClick()
                                onFinish()
                            },
                            enabled = answered,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                        ) { Text(s.nextStep) }
                    }
                }
            }
        },
    ) { inner ->
        Column(
            Modifier
                .padding(inner)
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                lesson.title,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                quiz.question,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp),
            )

            options.forEachIndexed { index, option ->
                val isSelected = selected == index
                val isRight = index == correctIndex
                val scheme = MaterialTheme.colorScheme

                var background = scheme.surface
                var foreground = scheme.onSurface
                var border = scheme.outlineVariant
                if (isSelected && isRight) {
                    background = GreenBg; foreground = GreenFg; border = GreenFg
                } else if (isSelected) {
                    background = RedBg; foreground = RedFg; border = RedFg
                }

                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = background,
                    border = BorderStroke(if (isSelected) 2.dp else 1.dp, border),
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .clickable(enabled = !answered) {
                                setSelected(index)
                                if (index == correctIndex) {
                                    SoundManager.playCorrect()
                                } else {
                                    SoundManager.playIncorrect()
                                }
                            }
                            .padding(horizontal = 16.dp, vertical = 18.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            option,
                            color = foreground,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                            modifier = Modifier.weight(1f),
                        )
                        if (isSelected) {
                            Icon(
                                if (isRight) Icons.Default.CheckCircle else Icons.Default.Close,
                                contentDescription = null,
                                tint = foreground,
                            )
                        }
                    }
                }
            }
        }
    }
}
