package com.example.speedtracks

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.speedtracks.databinding.ActivityLoginBinding
import com.example.speedtracks.ui.register.RegisterFragment

class Login : AppCompatActivity() {

private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginExpand()



    }
    private  fun loginExpand(){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_charger, RegisterFragment())
        transaction.commit()
    }
}