package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculateLoan()
        }
    }
    private fun calculateLoan(){
        //Getting input data from the user
        val car_price=editTextCarPrice.text.toString().toInt()
        val down_payment=editTextDownPayment.text.toString().toInt()
        val loan_period=editTextLoanPeriod.text.toString().toInt()
        val interest_rate=editTextInterestRate.text.toString().toFloat()

        val loan=car_price-down_payment
        val interest=loan*interest_rate*loan_period
        val monthpay=(loan+interest)/loan_period/12

        textViewCarLoan.text=getString(R.string.CarLoan)+" ${loan}"
        textViewInterest.text=getString(R.string.Interest)+" ${interest}"
        textViewMonthlyPayment.text=getString(R.string.MonthlyRepayment)+" ${monthpay}"
    }

     fun resetinput(view : View){
         editTextCarPrice.setText("")
         editTextDownPayment.setText("")
         editTextInterestRate.setText("")
         editTextLoanPeriod.setText("")
         textViewCarLoan.text=getString(R.string.CarLoan)
         textViewInterest.text=getString(R.string.Interest)
         textViewMonthlyPayment.text=getString(R.string.MonthlyRepayment)
    }

}
