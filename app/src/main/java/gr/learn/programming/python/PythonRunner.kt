package gr.learn.programming.python

import com.chaquo.python.Python
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

data class RunResult(val output: String, val error: String?)

/** Γέφυρα Kotlin -> Python. Καλεί τη run_code() του app/src/main/python/runner.py */
object PythonRunner {

    suspend fun run(code: String, unknownError: String = "Unknown error", languageCode: String = "en"): RunResult = withContext(Dispatchers.Default) {
        try {
            val json = Python.getInstance()
                .getModule("runner")
                .callAttr("run_code", code, languageCode)
                .toString()
            val obj = JSONObject(json)
            RunResult(
                output = obj.optString("output", ""),
                error = if (obj.isNull("error")) null else obj.getString("error"),
            )
        } catch (e: Exception) {
            RunResult(output = "", error = e.message ?: unknownError)
        }
    }
}
