package com.eugene.compound_interest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var inputPrincipal: EditText = findViewById(R.id.InputPrincipal)
        var inputRate: EditText = findViewById(R.id.InputRate)
        var inputTime: EditText = findViewById(R.id.InputTime)
        var myButton: Button = findViewById(R.id.Calculate)
        var myResult: TextView = findViewById(R.id.TxtResult)

        myButton.setOnClickListener {
            //get the text that the user has entered
            var textPrincipal = inputPrincipal.text.toString().trim()
            var textRate = inputRate.text.toString().trim()
            var textTime = inputTime.text.toString().trim()



            try {
                //convert to numbers
                var rate = textRate.toDouble() /100.0
                var principal = textPrincipal.toDouble()
                var time = textTime.toDouble() /12


                if (rate < 0 || principal <0 || time< 0 ){
                    println("Enter valid input")
                }else {
                    //Add the numbers
                    var amount = principal * ((1 + rate).pow(time))


                    //Display
                    myResult.text = "The result is $amount"
               }
            }catch (e : Exception){
                Toast.makeText(applicationContext,"Enter valid input", Toast.LENGTH_LONG).show()
            }


        }
    }
}