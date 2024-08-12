package com.example.branch

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.branch.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var timer: CountDownTimer
    private var remainingTime = 10
    private var score = 0
    private var isGameFinished = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set initial values
        binding.sifir.text = remainingTime.toString()
        binding.ikincisifir.text = score.toString()

        // Hide all images initially
        val images = arrayOf(
            binding.bir, binding.iki, binding.uc, binding.dord, binding.bes,
            binding.alti, binding.yeddi, binding.sekkiz, binding.doqquz
        )
        images.forEach { it.visibility = View.INVISIBLE }

        // Start the game
        startGame()

        // Add click listener to replay button
        binding.replay.setOnClickListener {
            restartGame()
        }
    }

    private fun startGame() {
        timer = object : CountDownTimer(11000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                remainingTime--
                if (remainingTime == 0) {
                    binding.sifir.text = "Finished!"
                    binding.left.visibility = View.INVISIBLE
                } else {
                    binding.sifir.text = remainingTime.toString()
                }

                val random = Random()
                val images = arrayOf(
                    binding.bir, binding.iki, binding.uc, binding.dord, binding.bes,
                    binding.alti, binding.yeddi, binding.sekkiz, binding.doqquz
                )
                val imageIndex = random.nextInt(images.size)
                images.forEachIndexed { index, imageView ->
                    imageView.visibility = if (index == imageIndex) View.VISIBLE else View.INVISIBLE
                }
            }

            override fun onFinish() {
                val alertDialogBuilder = AlertDialog.Builder(this@MainActivity)
                alertDialogBuilder.setTitle("Game over")
                alertDialogBuilder.setMessage("Start again?")
                alertDialogBuilder.setPositiveButton("YES") { _, _ ->
                    restartGame()
                }
                alertDialogBuilder.setNegativeButton("NO", null)
                alertDialogBuilder.show()
            }
        }
        timer.start()
    }

    fun click(view: View) {
        if (!isGameFinished && view.visibility == View.VISIBLE && binding.sifir.text != "Finished!") {
            increaseScore()
        }
    }

    private fun increaseScore() {
        score++
        binding.ikincisifir.text = score.toString()
    }

    @SuppressLint("SetTextI18n")
    private fun restartGame() {
        // Reset variables
        remainingTime = 10
        score = 0
        isGameFinished = false
        binding.sifir.visibility = View.VISIBLE
        binding.left.visibility = View.VISIBLE
        timer.cancel()
        // Start the game again
        startGame()
    }
}
