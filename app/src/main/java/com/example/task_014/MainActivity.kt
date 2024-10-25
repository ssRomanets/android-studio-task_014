package com.example.task_014

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var notes: MutableList<String> = mutableListOf()
    var personList: MutableList<Person> = mutableListOf()

    private lateinit var firstNameET: EditText
    private lateinit var secondNameET: EditText
    private lateinit var addressET: EditText
    private lateinit var phoneET: EditText
    private lateinit var saveBTN:  Button

    private lateinit var listViewLV:  ListView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNameET   = findViewById(R.id.firstNameET)
        secondNameET  = findViewById(R.id.secondNameET)
        addressET     = findViewById(R.id.addressET)
        phoneET       = findViewById(R.id.phoneET)
        saveBTN       = findViewById(R.id.saveBTN)
        listViewLV    = findViewById(R.id.listViewLV)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notes)
        listViewLV.adapter = adapter
        saveBTN.setOnClickListener{
            if (firstNameET.text.toString() != "" && secondNameET.text.toString() != "")
            {
                notes.add("${firstNameET.text.toString()} ${secondNameET.text.toString()}")
                personList.add(Person(firstNameET.text.toString(), secondNameET.text.toString(), addressET.text.toString(), phoneET.text.toString()))
                adapter.notifyDataSetChanged()

                firstNameET.text.clear()
                secondNameET.text.clear()
                addressET.text.clear()
                phoneET.text.clear()
            }
        }

        listViewLV.onItemClickListener = AdapterView.OnItemClickListener {parent, v, position, id ->
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Person::class.java.simpleName, personList.get(position))
            startActivity(intent)
        }
    }
}



