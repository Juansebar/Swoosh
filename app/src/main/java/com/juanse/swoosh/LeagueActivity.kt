package com.juanse.swoosh

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

enum class League {
    men, women, coed
}

class LeagueActivity : BaseActivity() {

    private var selectedLeague: League? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

//        nextButton.setOnClickListener {
//            val skillActivityIntent = Intent(this, SkillActivity::class.java)
//            startActivity(skillActivityIntent)
//        }
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
        if (selectedLeague != null) {
            val skillActivityIntent = Intent(this, SkillActivity::class.java)

            // We can append data to the Intent as an extra
            skillActivityIntent.putExtra(EXTRA_LEAGUE, selectedLeague!!.toString())
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

        selectedLeague = League.men
    }

    private fun onWomensLeagueClicked() {
        womensLeagueButton.isChecked = true
        mensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false

        selectedLeague = League.women
    }

    private fun onCoedLeagueClicked() {
        coedLeagueButton.isChecked = true
        womensLeagueButton.isChecked = false
        mensLeagueButton.isChecked = false

        selectedLeague = League.coed
    }
}
