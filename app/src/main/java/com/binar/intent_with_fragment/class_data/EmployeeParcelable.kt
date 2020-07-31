package com.binar.intent_with_fragment.class_data

import android.os.Parcel
import android.os.Parcelable

data class EmployeeParcelable(val name: String, val age: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EmployeeParcelable> {
        override fun createFromParcel(parcel: Parcel): EmployeeParcelable {
            return EmployeeParcelable(parcel)
        }

        override fun newArray(size: Int): Array<EmployeeParcelable?> {
            return arrayOfNulls(size)
        }
    }
}