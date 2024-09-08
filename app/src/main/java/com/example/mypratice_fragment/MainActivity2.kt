package com.example.mypratice_fragment

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mypratice_fragment.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn1.setOnClickListener {
            //新增了避免重複創建Fragment的功能
            val fragmentManager = supportFragmentManager
            val existingFragment = fragmentManager.findFragmentById(binding.fragmentContainerView.id)
            if(existingFragment == null){
                val fragmentTransation = supportFragmentManager.beginTransaction()
                fragmentTransation.add(binding.fragmentContainerView.id, MyFragment.instance)
                fragmentTransation.commit()
            }else{
                Toast.makeText(this, "Fragmaent已創建", Toast.LENGTH_SHORT).show()
            }
        }
    }
}