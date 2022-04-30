package android.tvz.hr.listaosrecki.parceable

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Vehicle(
    var name: String,
    val year: Int,
    val price: Double,
    val acceleration: Double,
    val range: Int,
) : Parcelable {}