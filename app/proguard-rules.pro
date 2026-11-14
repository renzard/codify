# ProGuard rules for Codify (F-Droid release build)

# Preserve Chaquopy classes and native method interfaces
-keep class com.chaquo.python.** { *; }
-dontwarn com.chaquo.python.**

# Preserve Kotlin model classes used for serialization / reflection
-keep class gr.learn.programming.model.** { *; }
-keep class gr.learn.programming.python.** { *; }

# Preserve Compose runtime annotations and components
-keepclassmembers class * {
    @androidx.compose.runtime.Composable *;
}
