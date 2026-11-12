package gr.learn.programming.ui

import gr.learn.programming.util.SoundManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import gr.learn.programming.model.Lesson
import gr.learn.programming.python.PythonRunner
import gr.learn.programming.python.RunResult
import kotlinx.coroutines.launch
import gr.learn.programming.i18n.LocalStrings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonScreen(lesson: Lesson, onBack: () -> Unit, onStartQuiz: () -> Unit) {
    var code by rememberSaveable(lesson.id) { mutableStateOf(lesson.codeExample) }
    var result by remember(lesson.id) { mutableStateOf<RunResult?>(null) }
    var running by remember { mutableStateOf(value = false) }
    val scope = rememberCoroutineScope()
    val s = LocalStrings.current
    val language = s.programmingLanguages
        .firstOrNull { it.name.equals(lesson.category, ignoreCase = true) }
    val runnable = language?.runnable ?: true
    val previewHtml = language?.previewHtml ?: false
    var previewCode by remember(lesson.id) { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(lesson.title) },
                navigationIcon = {
                    IconButton(onClick = { SoundManager.playClick(); onBack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = s.back)
                    }
                },
            )
        },
        bottomBar = {
            Surface(tonalElevation = 3.dp) {
                Box(
                    Modifier
                        .navigationBarsPadding()
                        .padding(horizontal = 20.dp, vertical = 12.dp),
                ) {
                    Button(
                        onClick = { SoundManager.playClick(); onStartQuiz() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                    ) { Text(s.startQuiz) }
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
            AssistChip(onClick = {}, label = { Text(lesson.category) })
            Text(
                lesson.title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
            )
            Text(
                lesson.description,
                style = MaterialTheme.typography.bodyLarge,
                lineHeight = MaterialTheme.typography.bodyLarge.lineHeight * 1.15f,
            )

            Spacer(Modifier.height(4.dp))
            Text(s.codeExample, style = MaterialTheme.typography.titleMedium)
            CodeEditor(
                code = code,
                onCodeChange = { code = it },
                header = s.editorHeader(lesson.category),
            )

            if (runnable) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    FilledTonalButton(
                        enabled = !running,
                        onClick = {
                            SoundManager.playClick()
                            running = true
                            scope.launch {
                                result = PythonRunner.run(code, s.unknownError, s.languageCode)
                                running = false
                            }
                        },
                    ) {
                        Icon(Icons.Default.PlayArrow, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text(if (running) s.running else s.run)
                    }
                    Spacer(Modifier.width(8.dp))
                    TextButton(
                        onClick = {
                            SoundManager.playClick()
                            code = lesson.codeExample
                            result = null
                        },
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text(s.restore)
                    }
                }

                result?.let { OutputPanel(it) }
            } else if (previewHtml) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    FilledTonalButton(
                        onClick = {
                            SoundManager.playClick()
                            previewCode = code
                        },
                    ) {
                        Icon(Icons.Default.PlayArrow, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text(s.preview)
                    }
                    Spacer(Modifier.width(8.dp))
                    TextButton(
                        onClick = {
                            SoundManager.playClick()
                            code = lesson.codeExample
                            previewCode = null
                        },
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text(s.restore)
                    }
                }

                previewCode?.let { HtmlPreview(it, s.previewTitle) }
            } else {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextButton(
                        onClick = {
                            SoundManager.playClick()
                            code = lesson.codeExample
                        },
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text(s.restore)
                    }
                }
                lesson.sampleOutput?.let { SampleOutputPanel(it, s.sampleOutputTitle) }
                Text(
                    s.notRunnableHint,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}
