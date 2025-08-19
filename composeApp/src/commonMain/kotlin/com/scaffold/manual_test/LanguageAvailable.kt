package com.scaffold.manual_test

fun languageAvailable(language: String): String {
    return language
}

//Here test for function (by using Manual Test)
fun testLanguageAvailable(): Boolean {
    val inputLanguage = "Arabic"
    val expectedOutput = "Arabic" // the output that i'm expected not actual (in brain "فى دماغى")

    // the output actual
    val actualOutput = languageAvailable(language = inputLanguage)

    // here "E3melele" test ---> if the output that i'm expected equal to the output actual
    return expectedOutput == actualOutput
}

