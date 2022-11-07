package com.marc.changeactivities

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityTwo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val buttonTelefon: Button = findViewById(R.id.buttonTelefon)
        val buttonMap: Button = findViewById(R.id.buttonMap)
        val buttonMail: Button = findViewById(R.id.buttonMail)
        val buttonWeb: Button = findViewById(R.id.buttonWeb)

        buttonTelefon.setOnClickListener() {
            val callIntent: Intent = Uri.parse("tlf:123456789").let { number ->
                Intent(Intent.ACTION_DIAL, number)
            }

            startActivity(callIntent)
        }

        buttonMap.setOnClickListener() {
            val mapIntent: Intent = Uri.parse(
                "geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California"
            ).let { location ->
                Intent(Intent.ACTION_VIEW, location)
            }

            startActivity(mapIntent)
        }

        buttonWeb.setOnClickListener() {
            val webIntent: Intent = Uri.parse("https://www.youtube.com").let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage)
            }

            startActivity(webIntent)
        }

        buttonMail.setOnClickListener() {
            val correuIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("test@example.com")) // recipients
                putExtra(Intent.EXTRA_SUBJECT, "Email subject")
                putExtra(Intent.EXTRA_TEXT, "Email message text")
                putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"))
            }

            startActivity(correuIntent)
        }
    }
}