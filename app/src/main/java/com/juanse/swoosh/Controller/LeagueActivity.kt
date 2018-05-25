package com.juanse.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.juanse.swoosh.Model.LeagueGender
import com.juanse.swoosh.Model.Player
import com.juanse.swoosh.R
import com.juanse.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    private var player: Player = Player()

    // Save vars when device orientation is changed or else gets deleted
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        // Nullable b/c if its first time running there is no previously save Instance State
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    // Access stored Instance State
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        setupViews()
    }

    private fun setupViews() {
//        Listeners
        nextButton.setOnClickListener {
            nextButtonClicked()
        }
        mensLeagueButton.setOnClickListener {
            onMensLeagueClicked()
        }
        womensLeagueButton.setOnClickListener {
            onWomensLeagueClicked()
        }
        coedLeagueButton.setOnClickListener {
            onCoedLeagueClicked()
        }
    }

    private fun nextButtonClicked() {
        if (player.leagueGender != "") {
            val skillActivityIntent = Intent(this, SkillActivity::class.java)

            // We can append data to the Intent as an extra
            skillActivityIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivityIntent)
        } else {
            // Use Toast to give feedback to the user
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onMensLeagueClicked() {
        mensLeagueButton.isChecked = true
        womensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false

        player.leagueGender = "men"
    }

    private fun onWomensLeagueClicked() {
        womensLeagueButton.isChecked = true
        mensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false

        player.leagueGender = "women"
    }

    private fun onCoedLeagueClicked() {
        coedLeagueButton.isChecked = true
        womensLeagueButton.isChecked = false
        mensLeagueButton.isChecked = false

        player.leagueGender = "coed"
    }
}
