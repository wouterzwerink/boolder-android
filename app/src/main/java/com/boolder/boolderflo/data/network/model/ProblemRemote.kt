package com.boolder.boolderflo.data.network.model

import com.boolder.boolderflo.view.search.BaseObject
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProblemRemote(
    val objectID: String,
    val name: String,
    val grade: String,
    @SerialName("area_name")
    val areaName: String
) : BaseObject
