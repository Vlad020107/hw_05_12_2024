package ru.example.a051220242

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
        var end_new_act =  findViewById<Button>(R.id.button_label)
        val intent_back = Intent(this, MainActivity::class.java)
        end_new_act.setOnClickListener {
            startActivity(intent_back)
        }
    }
}