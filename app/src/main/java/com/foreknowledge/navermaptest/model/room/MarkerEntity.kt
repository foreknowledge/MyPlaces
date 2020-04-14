package com.foreknowledge.navermaptest.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.foreknowledge.navermaptest.util.MarkerUtil

/**
 * Create by Yeji on 08,April,2020.
 */
@Entity
data class MarkerEntity (
    val lat: Double,
    val lng: Double,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
) {
    fun toUserMarker() =
        MarkerUtil.createUserMarker(lat, lng, id) { true }
}