package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startButton.setOnClickListener{
            val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
        var btn = findViewById<Button>(R.id.quitButton)
        quitButton.setOnClickListener {

            val alertdialog = AlertDialog.Builder(this).create()
            alertdialog.setMessage("Are you sure you want to quit?")

            alertdialog.setButton(AlertDialog.BUTTON_POSITIVE,"Yes"){
                dialog, which ->  finish()
                dialog.dismiss()
            }
            alertdialog.setButton(AlertDialog.BUTTON_NEGATIVE,"No"){
                dialog, which ->
                dialog.dismiss()
            }
            alertdialog.show()
        }
    }
}