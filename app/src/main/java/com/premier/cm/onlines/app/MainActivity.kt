package com.premier.cm.onlines.app

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import java.util.Timer
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialog:AlertDialog.Builder=AlertDialog.Builder(this)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#17B169")))
        val view=layoutInflater.inflate(R.layout.progress,null)
        dialog.setView(view)
        dialog.setCancelable(false)
        dialog.show()


        val timer:Timer
        timer=Timer()
        val intent:Intent=Intent(this,webview::class.java)

        timer.schedule(2000){
            startActivity(intent)
            finish()
        }
    }
}