package com.example.speedtracks.ui.register

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.speedtracks.MainActivity
import com.example.speedtracks.ProfileCreate
import com.example.speedtracks.R
import com.example.speedtracks.databinding.FragmentProfileCreateBinding
import com.example.speedtracks.databinding.FragmentRegisterBinding

class Profile_Create : Fragment() {

    companion object {
        fun newInstance() = Profile_Create()
    }

    private lateinit var viewModel: ProfileCreateViewModel
    private var _binding: FragmentProfileCreateBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileCreateBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.saveBTN.setOnClickListener {
            val i = Intent(context, MainActivity::class.java)
            startActivity(i)
        }


        return root
    }

}