package com.juanse.swoosh

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SkillActivity : BaseActivity() {

    private var league: League? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        // Get the values from Extra
        val leagueString = intent.getStringExtra(EXTRA_LEAGUE)
        league = League.valueOf(leagueString)

        println("Selected League: ${league}")
    }
}
