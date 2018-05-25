package com.juanse.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.juanse.swoosh.Model.Player
import com.juanse.swoosh.R
import com.juanse.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    // Behaves like lazy var (declare but don't initialize)
    private lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        // Get the values from Extra
        player = intent.getParcelableExtra(EXTRA_PLAYER)

        println("Selected League: ${player.leagueGender}")

        setupViews()
    }

    private fun setupViews() {
        skillFinishButton.setOnClickListener {
            onSkillFinishButtonClicked()
        }
        beginnerSkillButton.setOnClickListener {
            onBeginnerSkillButtonClicked()
        }
        ballerSkillButton.setOnClickListener {
            onBallerSkillButtonClicked()
        }
    }

    private fun onSkillFinishButtonClicked() {
        if (ballerSkillButton.isChecked || beginnerSkillButton.isChecked) {
            val finishActivityIntent = Intent(this, FinishActivity::class.java)

            // Using Parcelable Extra
            finishActivityIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivityIntent)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onBeginnerSkillButtonClicked() {
        ballerSkillButton.isChecked = false
        player.skillLevel = "beginner"
    }

    private fun onBallerSkillButtonClicked() {
        beginnerSkillButton.isChecked = false
        player.skillLevel = "baller"
    }
}

