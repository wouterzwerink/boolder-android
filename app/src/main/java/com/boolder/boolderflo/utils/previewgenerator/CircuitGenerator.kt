package com.boolder.boolderflo.utils.previewgenerator

import com.boolder.boolderflo.domain.model.Circuit
import com.boolder.boolderflo.domain.model.CircuitColor
import com.mapbox.geojson.Point

fun dummyCircuit(
    id: Int = 0,
    color: CircuitColor = CircuitColor.ORANGE,
    averageGrade: String = "3b"
) = Circuit(
    id = id,
    color = color,
    averageGrade = averageGrade,
    isBeginnerFriendly = false,
    isDangerous = false,
    coordinateBounds = listOf(
        Point.fromLngLat(0.0, 0.0),
        Point.fromLngLat(0.0, 0.0)
    )
)
