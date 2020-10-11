package com.calc.caculadorautilitria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_calculadora.*
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_Calc.setOnClickListener(){
            val intent = Intent(this, Calculadora::class.java)
            startActivity(intent)
        }
        btn_CalcDesc.setOnClickListener(){
            val intent = Intent(this, Desconto::class.java)
            startActivity(intent)
        }

    }
}