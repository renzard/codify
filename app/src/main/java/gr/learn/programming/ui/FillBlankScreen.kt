package gr.learn.programming.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gr.learn.programming.i18n.LocalStrings
import gr.learn.programming.model.BLANK_MARKER
import gr.learn.programming.model.FillBlank
import gr.learn.programming.model.Lesson
import gr.learn.programming.util.SoundManager

private val CodeBackground = Color(0xFF1E1E2E)
private val CodeText = Color(0xFFE6E6F0)
private val CodeMuted = Color(0xFF9399B2)
private val BlankBg = Color(0xFF2E2E44)
private val BlankBorder = Color(0xFF6C7086)
private val OkColor = Color(0xFFA6E3A1)
private val WrongColor = Color(0xFFF38BA8)

private val MonoStyle = TextStyle(
    fontFamily = FontFamily.Monospace,
    fontSize = 14.sp,
    lineHeight = 21.sp,
    color = CodeText,
)

private sealed interface Piece {
    data class Code(val text: String) : Piece
    data class Gap(val index: Int) : Piece
}

/** Σπάει τον κώδικα σε γραμμές και κάθε γραμμή σε κομμάτια κώδικα και κενά. */
private fun parse(code: String): List<List<Piece>> {
    var next = 0
    return code.lines().map { line ->
        val parts = line.split(BLANK_MARKER)
        buildList<Piece> {
            parts.forEachIndexed { i, part ->
                if (part.isNotEmpty()) add(Piece.Code(part))
                if (i < parts.lastIndex) {
                    add(Piece.Gap(next))
                    next++
                }
            }
        }
    }
}

/** Ίδιες απαντήσεις ανεξάρτητα από κενά γύρω-γύρω και από τα εισαγωγικά ('x' = "x"). */
private fun normalize(text: String): String = text.trim().replace('\'', '"')

private fun isCorrect(input: String, accepted: List<String>): Boolean =
    normalize(input).let { value -> accepted.any { normalize(it) == value } }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FillBlankScreen(
    lesson: Lesson,
    fillBlank: FillBlank,
    onBack: () -> Unit,
    onFinish: () -> Unit,
) {
    val s = LocalStrings.current
    val lines = remember(fillBlank) { parse(fillBlank.code) }
    val count = fillBlank.answers.size

    var values by rememberSaveable(lesson.id) { mutableStateOf<List<String>>(List(count) { "" }) }
    var checked by rememberSaveable(lesson.id) { mutableStateOf(false) }

    val correct = List(count) { isCorrect(values[it], fillBlank.answers[it]) }
    val allCorrect = correct.all { it }
    val allFilled = values.all { it.isNotBlank() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(s.fillBlankTitle) },
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
                    if (checked) {
                        Text(
                            if (allCorrect) s.fillBlankCorrect else s.fillBlankWrong,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = if (allCorrect) Color(0xFF2E7D32) else Color(0xFFC62828),
                        )
                    }
                    if (checked && allCorrect) {
                        Button(
                            onClick = { SoundManager.playClick(); onFinish() },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                        ) { Text(s.finishLesson) }
                    } else {
                        Button(
                            onClick = {
                                checked = true
                                if (allCorrect) SoundManager.playCorrect() else SoundManager.playIncorrect()
                            },
                            enabled = allFilled,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                        ) { Text(s.checkAnswers) }
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
                s.fillBlankInstruction,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp),
            )

            Column(
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(CodeBackground)
                    .padding(16.dp),
            ) {
                lines.forEach { pieces ->
                    if (pieces.isEmpty()) {
                        Text(" ", style = MonoStyle)
                    } else {
                        Row(
                            Modifier.horizontalScroll(rememberScrollState()),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            pieces.forEach { piece ->
                                when (piece) {
                                    is Piece.Code -> Text(piece.text, style = MonoStyle, softWrap = false)
                                    is Piece.Gap -> BlankField(
                                        value = values[piece.index],
                                        widthChars = fillBlank.answers[piece.index].maxOf { it.length },
                                        state = when {
                                            !checked -> null
                                            correct[piece.index] -> true
                                            else -> false
                                        },
                                        onValueChange = { text ->
                                            values = values.toMutableList().also { it[piece.index] = text }
                                            checked = false
                                        },
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

/** Ένα κενό μέσα στον κώδικα. [state]: null = δεν ελέγχθηκε, true = σωστό, false = λάθος. */
@Composable
private fun BlankField(
    value: String,
    widthChars: Int,
    state: Boolean?,
    onValueChange: (String) -> Unit,
) {
    val density = LocalDensity.current
    val charWidth = with(density) { (14.sp * 0.62f).toDp() }
    val border = when (state) {
        true -> OkColor
        false -> WrongColor
        null -> BlankBorder
    }
    Box(
        Modifier
            .padding(horizontal = 2.dp, vertical = 1.dp)
            .width(charWidth * (maxOf(widthChars, 3) + 1) + 16.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(BlankBg)
            .border(BorderStroke(if (state == null) 1.dp else 2.dp, border), RoundedCornerShape(6.dp))
            .padding(horizontal = 8.dp, vertical = 2.dp),
        contentAlignment = Alignment.CenterStart,
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = MonoStyle.copy(color = if (state == false) WrongColor else if (state == true) OkColor else CodeText),
            cursorBrush = SolidColor(CodeText),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.None),
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
