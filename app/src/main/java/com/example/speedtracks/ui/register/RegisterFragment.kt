package com.example.speedtracks.ui.register

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import com.example.speedtracks.MainActivity
import com.example.speedtracks.ProfileCreate
import com.example.speedtracks.databinding.FragmentRegisterBinding
import com.google.android.gms.auth.api.phone.R
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
        val passwordTextc = binding.cpasswordText.text

        binding.registerButton.setOnClickListener{
            if (binding.userText.text != null && passwordTextc.toString() == passwordText.toString())
            createAccount(userText.toString(), passwordText.toString())
            if (passwordText == null){
                binding.textView.isVisible = true
            }
            if (passwordTextc == null){
                binding.textView.isVisible = true
            }
            if (userText == null){
                binding.textView.isVisible = true
            }
            if (passwordText.toString() != passwordTextc.toString()){
                binding.passDif.isVisible = true
            }

        }

        binding.loginButton.setOnClickListener{
            signIn(userText.toString(), passwordText.toString())
        }

        binding.registerText.setOnClickListener{
            binding.registerText.isVisible = false
            binding.cpassword.isVisible = true
            binding.registerButton.isVisible = true
            binding.loginButton.isVisible = false

        }
            // Initialize Firebase Auth




        return root







    }

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        if (currentUser != null){
            reload()
        }
    }

    private fun createAccount(email: String, password: String){


        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    Toast.makeText(context, "great sucess",
                        Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser
                    updateUI(user)
                    goToProfileCreate()
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
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(context,"weeeeeeeeeeeeeeeeeeeeeeeeeeeeee", Toast.LENGTH_LONG).show()
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                    goToActivity()
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
    private fun goToProfileCreate(){

        val i = Intent(context, ProfileCreate::class.java)
        startActivity(i)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}