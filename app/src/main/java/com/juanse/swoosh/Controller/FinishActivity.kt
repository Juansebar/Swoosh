package com.juanse.swoosh.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.juanse.swoosh.Model.Player
import com.juanse.swoosh.R
import com.juanse.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : BaseActivity() {

    private val TAG = "Finish"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        // Must specify type of Parcelable since we are creating it directly
        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        Log.v(TAG, "League: ${player.leagueGender}, Skill Level: ${player.skillLevel}")
        descriptionTextView.text = "Looking for ${player.leagueGender}s ${player.skillLevel} near you..."
    }
}
