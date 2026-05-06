package com.boolder.boolderflo.utils

import java.util.Locale

fun getLanguage(): String =
    when (Locale.getDefault().language) {
        "fr" -> "fr"
        else -> "en"
    }
