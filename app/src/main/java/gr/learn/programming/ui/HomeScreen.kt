package gr.learn.programming.ui

import gr.learn.programming.util.SoundManager
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import gr.learn.programming.data.isLessonUnlocked
import gr.learn.programming.data.lessonsFor
import gr.learn.programming.model.Language
import gr.learn.programming.model.Lesson
import gr.learn.programming.model.UserProgress
import gr.learn.programming.i18n.LocalStrings

private val DoneGreen = Color(0xFF2E7D32)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    language: Language,
    progress: UserProgress,
    onLessonClick: (Lesson) -> Unit,
    onBack: () -> Unit,
    onReset: () -> Unit,
) {
    var menuOpen by remember { mutableStateOf(value = false) }
    val (confirmReset, setConfirmReset) = remember { mutableStateOf(value = false) }
    val context = LocalContext.current
    val s = LocalStrings.current
    val languageLessons = lessonsFor(language, s.lessonList)
    val total = languageLessons.size
    val done = languageLessons.count { progress.isCompleted(it.id) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(language.name) },
                navigationIcon = {
                    IconButton(onClick = { SoundManager.playClick(); onBack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = s.back)
                    }
                },
                actions = {
                    Box {
                        IconButton(onClick = { SoundManager.playClick(); menuOpen = true }) {
                            Icon(Icons.Default.MoreVert, contentDescription = s.menu)
                        }
                        DropdownMenu(expanded = menuOpen, onDismissRequest = { menuOpen = false }) {
                            DropdownMenuItem(
                                text = { Text(s.resetProgress) },
                                onClick = {
                                    SoundManager.playClick()
                                    menuOpen = false
                                    setConfirmReset(true)
                                },
                            )
                        }
                    }
                },
            )
        },
    ) { inner ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(inner),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item { ProgressCard(done = done, total = total, score = progress.totalScore) }
            item {
                Text(
                    s.lessons,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 16.dp, bottom = 4.dp),
                )
            }
            itemsIndexed(languageLessons, key = { _, lesson -> lesson.id }) { index, lesson ->
                val completed = progress.isCompleted(lesson.id)
                val unlocked = isLessonUnlocked(lesson, languageLessons, progress)
                LessonRow(
                    lesson = lesson,
                    completed = completed,
                    unlocked = unlocked,
                ) {
                    if (unlocked) {
                        onLessonClick(lesson)
                    } else {
                        val prevTitle = if (index > 0) languageLessons[index - 1].title else ""
                        Toast.makeText(
                            context,
                            s.completePrevious(prevTitle),
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
            }
        }
    }

    if (confirmReset) {
        AlertDialog(
            onDismissRequest = { setConfirmReset(false) },
            title = { Text(s.resetProgress) },
            text = { Text(s.resetProgressConfirmShort) },
            confirmButton = {
                TextButton(
                    onClick = {
                        SoundManager.playClick()
                        setConfirmReset(false)
                        onReset()
                    },
                ) {
                    Text(s.resetAction)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { SoundManager.playClick(); setConfirmReset(false) },
                ) {
                    Text(s.cancel)
                }
            },
        )
    }
}

@Composable
private fun ProgressCard(done: Int, total: Int, score: Int) {
    val colors = MaterialTheme.colorScheme
    val s = LocalStrings.current
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = colors.primaryContainer,
            contentColor = colors.onPrimaryContainer,
        ),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(Modifier.padding(20.dp)) {
            Text(s.yourProgress, style = MaterialTheme.typography.labelLarge)
            Text(
                s.lessonsCompleted(done, total),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 4.dp),
            )
            LinearProgressIndicator(
                progress = { if (total == 0) 0f else done.toFloat() / total },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .height(10.dp)
                    .clip(RoundedCornerShape(8.dp)),
            )
            Row(Modifier.padding(top = 12.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Star, contentDescription = null)
                Spacer(Modifier.width(6.dp))
                Text(s.pointsLabel(score), style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Composable
private fun LessonRow(
    lesson: Lesson,
    completed: Boolean,
    unlocked: Boolean,
    onClick: () -> Unit,
) {
    val colors = MaterialTheme.colorScheme
    val s = LocalStrings.current
    val cardColor = if (unlocked) {
        colors.surfaceVariant.copy(alpha = 0.4f)
    } else {
        colors.surfaceVariant.copy(alpha = 0.15f)
    }

    Card(
        onClick = { SoundManager.playClick(); onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            when {
                completed -> {
                    Icon(
                        Icons.Default.CheckCircle,
                        contentDescription = s.completed,
                        tint = DoneGreen,
                        modifier = Modifier.size(30.dp),
                    )
                }
                unlocked -> {
                    Box(
                        Modifier
                            .size(28.dp)
                            .border(BorderStroke(2.dp, colors.outline), CircleShape),
                    )
                }
                else -> {
                    Icon(
                        Icons.Default.Lock,
                        contentDescription = s.locked,
                        tint = colors.outline,
                        modifier = Modifier.size(28.dp),
                    )
                }
            }
            Column(
                Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
            ) {
                Text(
                    lesson.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = if (unlocked) colors.onSurface else colors.onSurface.copy(alpha = 0.5f),
                )
                Text(
                    when {
                        completed -> "${lesson.category} · ${s.completed}"
                        unlocked -> lesson.category
                        else -> "${lesson.category} · ${s.locked}"
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (unlocked) colors.onSurfaceVariant else colors.onSurfaceVariant.copy(alpha = 0.5f),
                )
            }
            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = if (unlocked) colors.onSurfaceVariant else colors.outline.copy(alpha = 0.4f),
            )
        }
    }
}
