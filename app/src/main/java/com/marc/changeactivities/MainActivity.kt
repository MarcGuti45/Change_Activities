package com.marc.changeactivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val imageButton : ImageButton = findViewById(R.id.imageButton3)

        var resultat = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val date: Intent? = result.data
                if(date != null){
                    Toast.makeText(this, "La categoria es:  ${date.getStringExtra("categories")}", Toast.LENGTH_SHORT).show()
                }

            }
        }

        button.setOnClickListener() {
            val intent = Intent(this, ActivityThree::class.java)
            resultat.launch(intent)
        }

        imageButton.setOnClickListener() {
            val intent = Intent(this,ActivityTwo::class.java)
            startActivity(intent)
        }

    }
}