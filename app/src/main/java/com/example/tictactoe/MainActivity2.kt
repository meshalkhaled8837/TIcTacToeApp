package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Reset.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }
    fun buClick(view: View){
        val buSelected = view as Button
        var cellId = 0

        when(buSelected.id){
            R.id.B1 -> cellId = 1
            R.id.B2 -> cellId = 2
            R.id.B3 -> cellId = 3
            R.id.B4 -> cellId = 4
            R.id.B5 -> cellId = 5
            R.id.B6 -> cellId = 6
            R.id.B7 -> cellId = 7
            R.id.B8 -> cellId = 8
            R.id.B9 -> cellId = 9
        }
        playgame(cellId, buSelected)
    }
    var activePlayer = 1
    var Player1 = arrayListOf<Int>()
    var Player2 = arrayListOf<Int>()

    fun playgame(cellId:Int, buSelected:Button){
        if(activePlayer == 1){
            buSelected.text = "X"
            Player1.add(cellId)
            activePlayer = 2
            buSelected.setBackgroundColor(Color.YELLOW)
        }
        else{
            buSelected.text = "O"
            Player2.add(cellId)
            activePlayer = 1
            buSelected.setBackgroundColor(Color.BLUE)
        }
        buSelected.isEnabled = false
        win()
    }
    fun win(){
        var win = 0
//Straight
        if(B1.text == "X" && B2.text == "X" && B3.text == "X"){ win = 1 }
        if(B4.text == "X" && B5.text == "X" && B6.text == "X"){ win = 1 }
        if(B7.text == "X" && B8.text == "X" && B9.text == "X"){ win = 1 }

//Vertical
        if(B1.text == "X" && B4.text == "X" && B7.text == "X"){ win = 1 }
        if(B2.text == "X" && B5.text == "X" && B8.text == "X"){ win = 1 }
        if(B3.text == "X" && B6.text == "X" && B9.text == "X"){ win = 1 }

//Diagonal
        if(B1.text == "X" && B5.text == "X" && B9.text == "X"){ win = 1 }
        if(B3.text == "X" && B5.text == "X" && B7.text == "X"){ win = 1 }




//Straight
        if(B1.text == "O" && B2.text == "O" && B3.text == "O"){ win = 2 }
        if(B4.text == "O" && B5.text == "O" && B6.text == "O"){ win = 2 }
        if(B7.text == "O" && B8.text == "O" && B9.text == "O"){ win = 2 }

//Vertical
        if(B1.text == "O" && B4.text == "O" && B7.text == "O"){ win = 2 }
        if(B2.text == "O" && B5.text == "O" && B8.text == "O"){ win = 2 }
        if(B3.text == "O" && B6.text == "O" && B9.text == "O"){ win = 2 }

//Diagonal
        if(B1.text == "O" && B5.text == "O" && B9.text == "O"){ win = 2 }
        if(B3.text == "O" && B5.text == "O" && B7.text == "O"){ win = 2 }


        if(win == 0 && Player1.size + Player2.size ==9){
            winner.text = "Draw"
        }
        if(win == 1){winner.text = "X wins, click reset"}
        if(win == 2){winner.text = "O wins, click reset"}
    }
}