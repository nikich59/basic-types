package uz.uzum.tezkor.courier.basic_types

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coordinate(
    val latitude: Double,
    val longitude: Double,
) : Parcelable
