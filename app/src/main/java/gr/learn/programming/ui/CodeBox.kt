package gr.learn.programming.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gr.learn.programming.python.RunResult
import gr.learn.programming.i18n.LocalStrings

private val CodeBackground = Color(0xFF1E1E2E)
private val CodeHeader = Color(0xFF2A2A3C)
private val CodeText = Color(0xFFE6E6F0)
private val CodeMuted = Color(0xFF9399B2)
private val CodeError = Color(0xFFF38BA8)

private val MonoStyle = TextStyle(
    fontFamily = FontFamily.Monospace,
    fontSize = 14.sp,
    lineHeight = 21.sp,
    color = CodeText,
)

/** Σκούρο, επεξεργάσιμο κουτί κώδικα με monospace γραμματοσειρά. */
@Composable
fun CodeEditor(code: String, onCodeChange: (String) -> Unit, modifier: Modifier = Modifier) {
    val s = LocalStrings.current
    Column(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(CodeBackground),
    ) {
        Text(
            text = s.codeEditorHeader,
            color = CodeText,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .background(CodeHeader)
                .padding(horizontal = 16.dp, vertical = 12.dp),
        )
        BasicTextField(
            value = code,
            onValueChange = onCodeChange,
            textStyle = MonoStyle,
            cursorBrush = SolidColor(CodeText),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.None),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )
    }
}

/** Εμφανίζει την έξοδο (ή το σφάλμα) από την εκτέλεση της Python. */
@Composable
fun OutputPanel(result: RunResult, modifier: Modifier = Modifier) {
    val s = LocalStrings.current
    Column(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(CodeBackground)
            .padding(16.dp),
    ) {
        Text(s.output, color = CodeMuted, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        if (result.output.isNotEmpty()) {
            Text(result.output.trimEnd(), style = MonoStyle, modifier = Modifier.padding(top = 6.dp))
        } else if (result.error == null) {
            Text(s.noOutput, style = MonoStyle.copy(color = CodeMuted), modifier = Modifier.padding(top = 6.dp))
        }
        result.error?.let { err ->
            Text(err, style = MonoStyle.copy(color = CodeError), modifier = Modifier.padding(top = 8.dp))
        }
    }
}
