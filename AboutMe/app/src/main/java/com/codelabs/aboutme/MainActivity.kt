package com.codelabs.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.codelabs.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Robert Hdez")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName
        binding.doneButton.setOnClickListener { addNickName(it) }
        binding.nicknameText.setOnClickListener { updateNickName(it) }
    }

    private fun addNickName(view: View) {
        binding.apply {
            myName?.nickname = binding.nicknameEdit.text.toString()
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }

        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickName(view: View) {
        binding.nicknameEdit.visibility = View.VISIBLE
        binding.doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        binding.nicknameEdit.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)
    }
}
