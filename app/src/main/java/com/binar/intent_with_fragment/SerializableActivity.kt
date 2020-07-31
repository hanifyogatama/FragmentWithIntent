package com.binar.intent_with_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.intent_with_fragment.class_data.EmployeeSerializable
import kotlinx.android.synthetic.main.activity_serializable.*

class SerializableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serializable)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}


        val objEmployee = intent.getSerializableExtra("objserializable") as EmployeeSerializable
        // set in text view
        tvSentNameSerializable.text= objEmployee.name
        tvSentAgeSerializable.text= objEmployee.age.toString()
    }
}