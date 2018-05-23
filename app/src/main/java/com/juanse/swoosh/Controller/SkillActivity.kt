package com.juanse.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.juanse.swoosh.Utilities.EXTRA_LEAGUE
import com.juanse.swoosh.R
import com.juanse.swoosh.Utilities.EXTRA_SKILL_LEVEL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    private var league: League? = null
    private var skillLevel: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        // Get the values from Extra
        val leagueString = intent.getStringExtra(EXTRA_LEAGUE)
        league = League.valueOf(leagueString)

        println("Selected League: ${league}")

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

            finishActivityIntent.putExtra(EXTRA_SKILL_LEVEL, skillLevel)
            finishActivityIntent.putExtra(EXTRA_LEAGUE, league!!.toString())
            startActivity(finishActivityIntent)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onBeginnerSkillButtonClicked() {
        ballerSkillButton.isChecked = false
        skillLevel = "beginner"
    }

    private fun onBallerSkillButtonClicked() {
        beginnerSkillButton.isChecked = false
        skillLevel = "baller"
    }
}

