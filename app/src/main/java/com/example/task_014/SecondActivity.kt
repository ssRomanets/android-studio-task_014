package com.example.task_014

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    var person: Person? = null

    private lateinit var firstInfoTV: TextView;
    private lateinit var secondInfoTV: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        person = intent.extras?.getSerializable(Person::class.java.simpleName) as Person

        firstInfoTV = findViewById(R.id.firstInfoTV)
        secondInfoTV = findViewById(R.id.secondInfoTV)

        val firstName: String = person?.firstName.toString()
        val secondName: String = person?.secondName.toString()
        firstInfoTV.text = "Имя: $firstName, фамилия: $secondName"

        val address: String = person?.address.toString()
        val phone: String = person?.phone.toString()
        secondInfoTV.text = "Адрес: $address, телефон: $phone"
    }
}