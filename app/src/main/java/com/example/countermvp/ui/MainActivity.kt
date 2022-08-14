package com.example.countermvp.ui

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.countermvp.helper.Injector
import com.example.countermvp.databinding.ActivityMainBinding
import com.example.countermvp.showToast
import com.example.countermvp.view.CounterView

class MainActivity : AppCompatActivity(),CounterView {

    lateinit var binding: ActivityMainBinding
    private val presenter = Injector.getPresenter()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClicker()
    }


    private fun initClicker() {
        with(binding) {
            incrementBtn.setOnClickListener {
                presenter.increment()
            }
            decrementBtn.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun updateText(count: Int) {
        binding.counterTV.text = count.toString()
    }


    override fun getColor() {
        binding.counterTV.setBackgroundColor(Color.GREEN)
    }

    override fun showToastIncrement() {
        this.showToast("Поздравляю 10")
    }

}