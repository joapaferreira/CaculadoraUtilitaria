package com.calc.caculadorautilitria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_calculadora.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        // Numbers
        tvOne.setOnClickListener(){appendOnExpresstion("1", true)}
        tvTwo.setOnClickListener(){appendOnExpresstion("2", true)}
        tvThree.setOnClickListener(){appendOnExpresstion("3", true)}
        tvFour.setOnClickListener(){appendOnExpresstion("4", true)}
        tvFive.setOnClickListener(){appendOnExpresstion("5", true)}
        tvSix.setOnClickListener(){appendOnExpresstion("6", true)}
        tvSeven.setOnClickListener(){appendOnExpresstion("7", true)}
        tvEight.setOnClickListener(){appendOnExpresstion("8", true)}
        tvNine.setOnClickListener(){appendOnExpresstion("9", true)}
        tvZero.setOnClickListener(){appendOnExpresstion("0", true)}
        tvDot.setOnClickListener(){appendOnExpresstion(".", true)}

        // Operators
        tvPlus.setOnClickListener(){appendOnExpresstion("+", true)}
        tvMinus.setOnClickListener(){appendOnExpresstion("-", true)}
        tvMul.setOnClickListener(){appendOnExpresstion("*", true)}
        tvDiv.setOnClickListener(){appendOnExpresstion("/", true)}
        tvOpen.setOnClickListener(){appendOnExpresstion("(", true)}
        tvClose.setOnClickListener(){appendOnExpresstion(")", true)}

        tvClear.setOnClickListener() {
            tvExpression.text = ""
            tvResult.text = ""
        }

        tvBack.setOnClickListener(){

            val string = tvExpression.text.toString()
            if (string.isNotEmpty()){
                tvExpression.text = string.substring(0,string.length-1 )
            }
            tvResult.text = ""
        }

        tvEquals.setOnClickListener(){
            try {

                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    tvResult.text = result.toString()
                else
                    tvResult.text = result.toString()
            } catch (e: Exception) {
                Log.d("Exception", "message: " + e.message)
            }
        }
    }
    fun appendOnExpresstion( string: String, canClear:Boolean ) {
        if (tvResult.text.isNotEmpty()){

            tvResult.text = ""
        }
        if(canClear){
            tvResult.text = ""
            tvExpression.append(string)
        }else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }

    }
}
