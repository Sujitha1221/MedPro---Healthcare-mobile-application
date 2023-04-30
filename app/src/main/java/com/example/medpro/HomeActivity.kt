package com.example.medpro

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {
    private lateinit var profile: CardView
    private lateinit var article: CardView
    private lateinit var logout: Button
    private lateinit var check: CardView
    private lateinit var medi: CardView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        profile = (findViewById(R.id.cardMyProfile))
        logout = findViewById(R.id.lout)
        article = findViewById(R.id.cardArticles)
        check = findViewById(R.id.cardDoctor)
        medi = findViewById(R.id.cardMedicine)

        val sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
        val email = sharedPreferences.getString("email", "").toString()
        Toast.makeText(applicationContext, "Welcome ${email}!!!", Toast.LENGTH_LONG).show()

        profile.setOnClickListener {
            val intent = Intent(this, UserProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        logout.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(this, MainActivity::class.java))
        }

        article.setOnClickListener {
            startActivity(Intent(this, ArticleActivity::class.java))
        }

        check.setOnClickListener {
            val intent = Intent(this, ShippingActivity::class.java)
            startActivity(intent)
            finish()
        }

        medi.setOnClickListener {
            startActivity(Intent(this, MedicineActivity::class.java))
        }


    }


}