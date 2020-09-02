package com.example.pingpongx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var playerOneScore = 0
    var playerTwoScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {
            playerOneScore = it.getInt(Constants.KEY_EXTRA_SCORE_PLAYER_1)
            playerTwoScore = it.getInt(Constants.KEY_EXTRA_SCORE_PLAYER_2)
        }

        setUpPlayers()
        setUpListeners()
    }

    private fun setUpListeners() {
        btPlayerOneScore.setOnClickListener{
            playerOneScore++
            setUpScorePlayerOne()
        }

        btPlayerTwoScore.setOnClickListener{
            playerTwoScore++
            setUpScorePlayerTwo()
        }

        btRevenge.setOnClickListener{
            rematch()
        }

        btFinishMatch.setOnClickListener{
            val telaPlayer = Intent(this, PlayerActivity::class.java)
            startActivityForResult(telaPlayer, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        setUpPlayers()
        rematch()
    }

    private fun rematch() {
        playerOneScore = 0
        playerTwoScore = 0
        setUpScorePlayerOne()
        setUpScorePlayerTwo()
    }

    private fun setUpScorePlayerOne(){
        tvPlayerOneScore.text = playerOneScore.toString()
    }

    private fun setUpScorePlayerTwo(){
        tvPlayerTwoScore.text = playerTwoScore.toString()
    }

    private fun setUpPlayers() {
        tvPlayerOneName.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_1)
        tvPlayerTwoName.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_2)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(Constants.KEY_EXTRA_SCORE_PLAYER_1, playerOneScore)
        outState.putInt(Constants.KEY_EXTRA_SCORE_PLAYER_2, playerTwoScore)
    }
}