package com.calc.caculadorautilitria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_desconto.*

class Desconto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desconto)
        btnCalcular.setOnClickListener(){
            Calc()
        }
    }

    fun Calc(){
        if (edTxPreco.text.isNotEmpty()){
            if (edTxDesc.text.isNotEmpty() && edTxDesc.text.toString().toDouble() <= 100){
                var preco = edTxPreco.text.toString().toDouble()
                var desc = edTxDesc.text.toString().toDouble()
                var resul = preco * (desc/100)
                tvDesc.text = "R$ "+resul
                tvResultado.text = "R$ " + (preco - resul)

            }
        }
    }
}