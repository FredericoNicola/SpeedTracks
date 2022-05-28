package com.example.speedtracks.ui.register

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.speedtracks.MainActivity
import com.example.speedtracks.R
import com.example.speedtracks.databinding.FragmentHomeBinding
import com.example.speedtracks.databinding.FragmentRegisterBinding
import com.example.speedtracks.ui.home.HomeViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!


    private lateinit var viewModel: RegisterViewModel
    //instance declare
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        auth = Firebase.auth
        val registerViewModel =
            ViewModelProvider(this).get(RegisterViewModel::class.java)

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val userText = binding.userText.text
        val passwordText = binding.passwordText.text

        binding.registerButton.setOnClickListener{
            if (binding.userText.text != null)
            createAccount(userText.toString(), passwordText.toString())
            else{

                binding.textView.isVisible = true

            }
        }
            // Initialize Firebase Auth




        return root







    }

    public override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        if (currentUser != null){
            reload();
        }
    }

    private fun createAccount(email: String, password: String){

        Toast.makeText(context,"weeeeeeeeeeeeeeeeeeeeeeeeeeeeee", Toast.LENGTH_LONG).show()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    Toast.makeText(context, "great sucess",
                        Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser
                    updateUI(user)

                    goToActivity()


                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(context, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    private fun signIn(email: String, password: String) {
        // [START sign_in_with_email]
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)




                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(context, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
        // [END sign_in_with_email]
    }


    private fun reload(){}
    private fun updateUI(user: FirebaseUser?) {

    }

    private fun goToActivity(){
        val i = Intent(context, MainActivity::class.java)
        startActivity(i)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}