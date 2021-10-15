package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val windows: Window = this@MainActivity.window
        windows.navigationBarColor = ContextCompat.getColor(this@MainActivity,R.color.purple_500)

        btn00.setOnClickListener {  appendOnClick(true,"00")  }
        btn0.setOnClickListener {  appendOnClick(true,"0")}
        btn1.setOnClickListener {  appendOnClick(true,"1")}
        btn2.setOnClickListener {  appendOnClick(true,"2")}
        btn3.setOnClickListener {  appendOnClick(true,"3")}
        btn4.setOnClickListener {  appendOnClick(true,"4")}
        btn5.setOnClickListener {  appendOnClick(true,"5")}
        btn6.setOnClickListener {  appendOnClick(true,"6")}
        btn7.setOnClickListener {  appendOnClick(true,"7")}
        btn8.setOnClickListener {  appendOnClick(true,"8")}
        btn9.setOnClickListener {  appendOnClick(true,"9")}


        btnPlus.setOnClickListener {  appendOnClick(false,"+")}
        btnMinus.setOnClickListener {  appendOnClick(false,"-")}
        btnMultiply.setOnClickListener {  appendOnClick(false,"*")}
        btnDivide.setOnClickListener {  appendOnClick(false,"/")}
        btnLeftB.setOnClickListener {  appendOnClick(false,"(")}
        btnRightB.setOnClickListener {  appendOnClick(false,")")}

        btnClear.setOnClickListener {
            clearText()
        }

        btnEqual.setOnClickListener {
            calculate()
        }
    }
    fun appendOnClick(clear: Boolean, string: String){
        if (clear){
            tvOutput.text = ""
            tvInput.append(string)
        }else{
            tvInput.append(tvOutput.text)
            tvInput.append(string)
            tvOutput.text = ""
        }
    }
    fun clearText(){
        tvInput.text = ""
        tvOutput.text = ""
    }
    fun calculate(){
        try {
            val input = ExpressionBuilder(tvInput.text.toString()).build()
            val output = input.evaluate()
            val longOutput = output.toLong()

            if (output == longOutput.toDouble()){
                tvOutput.text = longOutput.toString()
            }else{
                tvOutput.text = output.toString()
            }
        }catch (e: Exception){
            Toast.makeText(this, "${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}