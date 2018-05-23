package com.juanse.swoosh.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.juanse.swoosh.R
import com.juanse.swoosh.Utilities.EXTRA_LEAGUE
import com.juanse.swoosh.Utilities.EXTRA_SKILL_LEVEL
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : BaseActivity() {

    private val TAG = "Finish"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val league = intent.getStringExtra(EXTRA_LEAGUE)
        val skillLevel = intent.getStringExtra(EXTRA_SKILL_LEVEL)

        Log.v(TAG, "League: ${league}, Skill Level: ${skillLevel}")
        descriptionTextView.text = "Looking for $league $skillLevel near you..."
    }
}
