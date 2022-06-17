package com.example.speedtracks

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.core.view.isVisible
import com.example.speedtracks.databinding.ActivityShoeDetailsBinding
import java.io.Console

class shoeDetails : AppCompatActivity() {
    private lateinit var binding: ActivityShoeDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoeDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

     val title =   intent.getStringExtra("Title")
     val model =   intent.getStringExtra("Model")
     val kmused = intent.getStringExtra("KmUsed")?.toFloat()
     val kmestimated =   intent.getStringExtra("KmEstimated")?.toFloat()

        binding.textView12.text = model
        binding.textView10.text = title
        binding.textView15.text = kmused.toString()
        binding.textView16.text = kmestimated.toString()



        val perc = kmestimated?.div(kmused!!)



        binding.shoeProgress.apply {
            progressMax = kmestimated!!
            setProgressWithAnimation(kmused!!,1000)
            progressBarWidth = 5f
            backgroundProgressBarWidth = 7f
            progressBarColor = Color.GREEN
            roundBorder = true
            backgroundProgressBarColor = Color.WHITE
        }

        binding.button.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nike.com"))
            startActivity(i)
        }
        binding.button2.setOnClickListener {
            binding.button2.isVisible=false
            binding.button3.isVisible=true
        }





    }
}