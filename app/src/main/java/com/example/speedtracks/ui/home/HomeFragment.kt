package com.example.speedtracks.ui.home

import android.graphics.Color
import android.graphics.Color.WHITE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.speedtracks.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.bar1.apply {
            progressMax = 100f
            setProgressWithAnimation(22f,1000)
            progressBarWidth = 5f
            backgroundProgressBarWidth = 7f
            progressBarColor = Color.GREEN
            roundBorder = true
            backgroundProgressBarColor = Color.WHITE
        }
        binding.bar2.apply {
            progressMax = 100f
            setProgressWithAnimation(79f,1000)
            progressBarWidth = 5f
            backgroundProgressBarWidth = 7f
            progressBarColor = Color.RED
            roundBorder = true
            backgroundProgressBarColor = Color.WHITE
        }
        binding.bar3.apply {
            progressMax = 100f
            setProgressWithAnimation(55f,1000)
            progressBarWidth = 5f
            backgroundProgressBarWidth = 7f
            progressBarColor = Color.YELLOW
            roundBorder = true
            backgroundProgressBarColor = Color.WHITE
        }
        binding.bar4.apply {
            progressMax = 100f
            setProgressWithAnimation(37f,1000)
            progressBarWidth = 5f
            backgroundProgressBarWidth = 7f
            progressBarColor = Color.BLUE
            roundBorder = true
            backgroundProgressBarColor = Color.WHITE
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}