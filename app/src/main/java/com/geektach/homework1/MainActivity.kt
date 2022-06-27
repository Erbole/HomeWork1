package com.geektach.homework1


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.geektach.homework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nextActivity()
    }

    companion object {
        const val SENDING_DATE = "KEY"
    }

    private fun nextActivity() {
        val resultContract =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.data != null) {
                    val date = it.data?.getStringExtra(SecondActivity.DATA)
                    binding.etTitle.setText(date)
                }
            }
        binding.btnOk.setOnClickListener {
            if (binding.etTitle.text.trim().isEmpty()) {
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                Intent(this, SecondActivity::class.java).apply {
                    putExtra(SENDING_DATE, binding.etTitle.text.toString())
                    resultContract.launch(this)
                }
            }
        }
    }
}