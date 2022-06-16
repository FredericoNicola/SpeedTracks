package com.example.speedtracks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.speedtracks.ui.register.Profile_Create
import com.example.speedtracks.ui.register.RegisterFragment

class ProfileCreate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_create)
        loginExpand()

    }
    private  fun loginExpand(){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_profile, Profile_Create())
        transaction.commit()
    }
}