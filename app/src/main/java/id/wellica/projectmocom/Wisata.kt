package id.wellica.projectmocom

import android.os.Parcel
import android.os.Parcelable

data class Wisata(
    var photo: Int,
    var name: String?,
    var overview: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(photo)
        parcel.writeString(name)
        parcel.writeString(overview)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Wisata> {
        override fun createFromParcel(parcel: Parcel): Wisata {
            return Wisata(parcel)
        }

        override fun newArray(size: Int): Array<Wisata?> {
            return arrayOfNulls(size)
        }
    }
}