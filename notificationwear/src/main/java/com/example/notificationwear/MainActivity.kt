package com.example.notificationwear

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : WearableActivity() {
    private lateinit var etfirstnumber:EditText
    private lateinit var etsecondnumber: EditText

    private lateinit var btnadd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etfirstnumber = findViewById(R.id.etfirstnumber)
        etsecondnumber = findViewById(R.id.etsecondnumber)

        btnadd= findViewById(R.id.btnadd)

        btnadd.setOnClickListener {
            addnumber()
        }




        // Enables Always-on
        setAmbientEnabled()
    }

    private fun addnumber() {
        val num1 : Int = etfirstnumber.text.toString().toInt()
        val num2 :Int = etsecondnumber.text.toString().toInt()

        val result = num1 + num2;

        Toast.makeText(this,"The sum of two number is"+result,Toast.LENGTH_SHORT).show()
    }
}