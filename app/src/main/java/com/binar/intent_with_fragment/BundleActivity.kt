package com.binar.intent_with_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bundle.*

class BundleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bundle)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        val bundle = intent.extras
        val name = bundle?.getString("name")
        tvSentNameBundle.setText(name)

        val age = bundle?.getString("age")
        tvSentAgeBundle.setText(age)

    }
}