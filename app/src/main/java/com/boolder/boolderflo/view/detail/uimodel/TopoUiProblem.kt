package com.boolder.boolderflo.view.detail.uimodel

import com.boolder.boolderflo.domain.model.CompleteProblem

/**
 * Container for a [CompleteProblem] and its associated UI data to render a
 * boulder problem start marker.
 *
 * @param completeProblem the boulder problem with its variants
 * @param problemStart the associated UI data to render a boulder problem start
 * marker
 */
data class UiProblem(
    val completeProblem: CompleteProblem,
    val problemStart: ProblemStart?
)
