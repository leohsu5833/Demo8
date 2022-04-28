package com.example.demo8

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object {
        const val FILENAME = "default"
        const val ID1 = "id1"
    }
    lateinit var preferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferences = getSharedPreferences(FILENAME,0)
        editor = preferences.edit()
        findViewById<Button>(R.id.button).setOnClickListener { v->
            Toast.makeText(this,"button clicked", Toast.LENGTH_LONG).show()
            val editText = findViewById<EditText>(R.id.editText1)
            editor.putString(ID1, editText.text.toString())
            editor.apply()
        }

        findViewById<Button>(R.id.button2).setOnClickListener { v ->
            preferences = getSharedPreferences(FILENAME, 0)
            val id1String = preferences.getString(ID1, "defaul")
            val textView = findViewById<TextView>(R.id.textView1)
            textView.text = id1String
        }
        findViewById<Button>(R.id.button3).setOnClickListener { v->
            editor.clear()
            editor.apply()
        }
    }
}