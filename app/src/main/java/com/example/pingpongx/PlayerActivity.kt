package com.example.pingpongx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        btStart.setOnClickListener{
            val proximaTela = Intent(this, MainActivity::class.java)
            proximaTela.putExtra(Constants.KEY_EXTRA_PLAYER_1, etPlayerOne.text.toString())
            proximaTela.putExtra(Constants.KEY_EXTRA_PLAYER_2, etPlayerTwo.text.toString())
            startActivity(proximaTela)
            finish()
        }
    }
}