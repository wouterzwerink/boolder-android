package com.boolder.boolderflo.domain.model

import android.os.Parcelable
import com.boolder.boolderflo.view.search.BaseObject
import kotlinx.parcelize.Parcelize

@Parcelize
data class Area(
    val id: Int,
    val name: String,
    val description: String? = null,
    val warning: String? = null,
    val tags: List<Int> = emptyList(),
    val southWestLat: Float,
    val southWestLon: Float,
    val northEastLat: Float,
    val northEastLon: Float,
    val problemsCount: Int,
    val problemsCountsPerGrade: Map<String, Int>
) : BaseObject, Parcelable
