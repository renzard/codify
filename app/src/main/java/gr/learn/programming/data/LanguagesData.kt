package gr.learn.programming.data

import gr.learn.programming.model.Language

val languagesEl: List<Language> = listOf(
    Language(
        id = "python",
        name = "Python",
        description = "Ιδανική για αρχάριους. Καθαρή σύνταξη, πανίσχυρη και εξαιρετικά δημοφιλής γλώσσα προγραμματισμού.",
        badge = "Py",
    ),
    Language(
        id = "linux",
        name = "Linux",
        description = "Μάθε τις βασικές εντολές του τερματικού: αρχεία, φάκελοι, αναζήτηση, δικαιώματα και άλλα. Οι εντολές δοκιμάζονται στον υπολογιστή σου.",
        badge = ">_",
        runnable = false,
    ),
    Language(
        id = "html",
        name = "HTML",
        description = "Η γλώσσα των ιστοσελίδων. Μάθε tags, συνδέσμους, εικόνες, πίνακες και φόρμες και δες αμέσως το αποτέλεσμα σε προεπισκόπηση.",
        badge = "</>",
        runnable = false,
        previewHtml = true,
    ),
)

val languagesEn: List<Language> = listOf(
    Language(
        id = "python",
        name = "Python",
        description = "Ideal for beginners. Clean syntax, and a powerful and extremely popular programming language.",
        badge = "Py",
    ),
    Language(
        id = "linux",
        name = "Linux",
        description = "Learn the basic terminal commands: files, folders, searching, permissions and more. You try the commands on your own computer.",
        badge = ">_",
        runnable = false,
    ),
    Language(
        id = "html",
        name = "HTML",
        description = "The language of web pages. Learn tags, links, images, tables and forms and see the result instantly in a preview.",
        badge = "</>",
        runnable = false,
        previewHtml = true,
    ),
)
