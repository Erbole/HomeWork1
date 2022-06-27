package com.geektach.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geektach.homework1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        result()
    }

    companion object {
        const val SENDING_DATE = "KEY"
        const val DATA = "DATA"
    }

    private fun result() {
        val desc = intent.getStringExtra(SENDING_DATE)
        binding.etTitleSecond.setText(desc)
        binding.btnOkSecond.setOnClickListener {
            if (binding.etTitleSecond.text.trim().isEmpty()) {
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val data = binding.etTitleSecond.text.toString()
            Intent().apply {
                putExtra(DATA, data)
                setResult(RESULT_OK, this)
                finish()
            }
        }
    }
}