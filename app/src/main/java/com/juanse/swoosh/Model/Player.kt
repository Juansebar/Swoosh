package com.juanse.swoosh.Model

import android.os.Parcel
import android.os.Parcelable

enum class LeagueGender {
    men, women, coed
}

enum class LeagueSkillLevel {
    beginner, baller
}

class Player constructor(var leagueGender: String = "", var skillLevel: String = ""): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(leagueGender)
        parcel.writeString(skillLevel)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    }

}