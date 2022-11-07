package com.marc.changeactivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class ActivityThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)

        val buttonTick: ImageButton = findViewById(R.id.imageButton)
        val input: EditText = findViewById(R.id.editTextTextPersonName2)



        buttonTick.setOnClickListener() {
            val text = input.text.toString()
            val intent = Intent(this, MainActivity::class.java)

            if (!text.isNullOrBlank()) {
                intent.putExtra("categories", text)
                setResult(Activity.RESULT_OK, intent)
            } else {
                intent.putExtra("categories", "buida")
                setResult(Activity.RESULT_CANCELED, intent)
            }

            finish()
        }
    }
}