package com.juanse.swoosh

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        getStartedButton.setOnClickListener {
            // Intent is an object that lets you interact with other applications or your own
            // ** Implicit type - specify action type and send it to the Android system, based on available
            //                     apps to serve that action it will serve up an app to respond to the Intent
            //                      (Not specifying which app in particular to open)
            // ** Explicit type - specify target class for the intent, not for opening a particular app cause it may not exist.
            //                      (ex: Going from one Activity to another)

            val leagueIntent = Intent(this, LeagueActivity::class.java)
            startActivity(leagueIntent)
        }
    }


}
