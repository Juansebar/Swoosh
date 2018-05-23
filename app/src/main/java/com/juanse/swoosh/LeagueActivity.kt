package com.juanse.swoosh

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

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
        nextButton.setOnClickListener {
            nextButtonClicked()
        }
    }

    private fun nextButtonClicked() {
        val skillActivityIntent = Intent(this, SkillActivity::class.java)
        startActivity(skillActivityIntent)
    }
}
