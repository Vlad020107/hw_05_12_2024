package ru.example.a051220242

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import ru.example.a051220242.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(R.layout.activity_main)
        val img:ImageView = findViewById(R.id.Avatar)
        img.setImageResource(R.drawable.kapi)
        val status_spinner = resources.getStringArray(R.array.status)
        val spinner = findViewById<Spinner>(R.id.status_spinner)
        if (spinner != null){
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, status_spinner
            )
            spinner.adapter = adapter
        }
        val intent = Intent(this, SecondaryActivity::class.java)
        val start_new_act = findViewById<Button>(R.id.B)
        start_new_act.setOnClickListener {
            startActivity(intent)
        }
        val buttonSendEmail = findViewById<Button>(R.id.send_mail)
        buttonSendEmail.setOnClickListener {
            sendEmail()
        }
        val buttonCall = findViewById<Button>(R.id.go_to_ph_num)
        buttonCall.setOnClickListener {
            dialPhoneNumber("88005553535")
        }
    }
    @SuppressLint("QueryPermissionsNeeded")
    private fun sendEmail(){
        val recipient = "mail@yandex.ru"
        val subject = "Title"
        val message = "This is text of your mail"

        val intent_mail = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$recipient")
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)
        }

        if (intent_mail.resolveActivity(packageManager) != null){
            startActivity(intent_mail)
        }
        else {
            Toast.makeText(this, "Нет приложений для отправки почты", Toast.LENGTH_SHORT).show()
        }

    }
    private fun dialPhoneNumber(phoneNumber: String){
        val intent_phone_num = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        startActivity(intent_phone_num)
    }

}
