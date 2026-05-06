package com.boolder.boolderflo.utils.previewgenerator

import com.boolder.boolderflo.domain.model.CompleteProblem

fun dummyCompleteProblem() = CompleteProblem(
    problemWithLine = dummyProblemWithLine(),
    variants = emptyList()
)
