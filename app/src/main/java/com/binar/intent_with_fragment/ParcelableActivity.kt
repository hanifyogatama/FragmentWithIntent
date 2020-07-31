package com.binar.intent_with_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.intent_with_fragment.class_data.EmployeeParcelable
import kotlinx.android.synthetic.main.activity_parcelable.*
import kotlinx.android.synthetic.main.activity_serializable.*

class ParcelableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        val objEmployee = intent.getParcelableExtra("objparcelable") as EmployeeParcelable?

        tvSentNameParcelable.text = objEmployee?.name
        tvSentAgeParcelable.text = objEmployee?.age.toString()
    }
}