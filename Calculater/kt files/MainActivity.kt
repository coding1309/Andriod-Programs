package com.example.neel

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {
    lateinit var btn1:android.widget.Button
    lateinit var btn2:android.widget.Button
    lateinit var btn3:android.widget.Button
    lateinit var btn4:android.widget.Button
    lateinit var btn5:android.widget.Button
    lateinit var btn6:android.widget.Button
    lateinit var btn7:android.widget.Button
    lateinit var btn8:android.widget.Button
    lateinit var btn9:android.widget.Button
    lateinit var btn0:android.widget.Button
    lateinit var btnclear:android.widget.Button
    lateinit var btn00:android.widget.Button
    lateinit var btnclose:android.widget.Button
    lateinit var btnper:android.widget.Button
    lateinit var btnadd:android.widget.Button
    lateinit var btnminus:android.widget.Button
    lateinit var btndivsion:android.widget.Button
    lateinit var btnmultiplication:android.widget.Button
    lateinit var btndot:android.widget.Button
    lateinit var btnequal:android.widget.Button
    lateinit var inputtext:EditText
    lateinit var resulttext:EditText
    var check = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)
        btn00 = findViewById(R.id.btn00)
        btnclear = findViewById(R.id.btnclear)
        btnclose = findViewById(R.id.btnclose)
        btnadd = findViewById(R.id.btnadd)
        btnmultiplication = findViewById(R.id.btnmultiplication)
        btndivsion = findViewById(R.id.btndivsion)
        btndot = findViewById(R.id.btndot)
        btnper = findViewById(R.id.btnper)
        btnequal = findViewById(R.id.btnequal)
        btnminus = findViewById(R.id.btnminus)
        inputtext = findViewById(R.id.inputtext)
        resulttext = findViewById(R.id.resulttext)

        inputtext.movementMethod = ScrollingMovementMethod()
        inputtext.setActivated(true)
        inputtext.setPressed(true)

        var text:String

        btn1.setOnClickListener{
            text = inputtext.text.toString() + "1"
            inputtext.setText(text)
            result(text)
        }
        btn2.setOnClickListener{
            text = inputtext.text.toString() + "2"
            inputtext.setText(text)
            result(text)
        }
        btn3.setOnClickListener{
            text = inputtext.text.toString() + "3"
            inputtext.setText(text)
            result(text)
        }
        btn4.setOnClickListener{
            text = inputtext.text.toString() + "4"
            inputtext.setText(text)
            result(text)
        }
        btn5.setOnClickListener{
            text = inputtext.text.toString() + "5"
            inputtext.setText(text)
            result(text)
        }
        btn6.setOnClickListener{
            text = inputtext.text.toString() + "6"
            inputtext.setText(text)
            result(text)
        }
        btn7.setOnClickListener{
            text = inputtext.text.toString() + "7"
            inputtext.setText(text)
            result(text)
        }
        btn8.setOnClickListener{
            text = inputtext.text.toString() + "8"
            inputtext.setText(text)
            result(text)
        }
        btn9.setOnClickListener{
            text = inputtext.text.toString() + "9"
            inputtext.setText(text)
            result(text)
        }
        btn0.setOnClickListener{
            text = inputtext.text.toString() + "0"
            inputtext.setText(text)
            result(text)
        }
        btn00.setOnClickListener{
            text = inputtext.text.toString() + "00"
            inputtext.setText(text)
            result(text)
        }
        btndot.setOnClickListener{
            text = inputtext.text.toString() + "."
            inputtext.setText(text)
            result(text)
        }
        btnadd.setOnClickListener{
            text = inputtext.text.toString()+"+"
            inputtext.setText(text)
            check = check+1
        }
        btnminus.setOnClickListener{
            text = inputtext.text.toString()+"-"
            inputtext.setText(text)
            check = check+1
        }
        btndivsion.setOnClickListener{
            text = inputtext.text.toString()+"/"
            inputtext.setText(text)
            check = check+1
        }
        btnmultiplication.setOnClickListener{
            text = inputtext.text.toString()+"*"
            inputtext.setText(text)
            check = check+1
        }
        btnper.setOnClickListener{
            text = inputtext.text.toString()+"%"
            inputtext.setText(text)
            check = check+1
        }
        btnequal.setOnClickListener{
            text = resulttext.text.toString()
            inputtext.setText(text)
            resulttext.setText(null)
        }
        btnclear.setOnClickListener{
            inputtext.setText(null)
            resulttext.setText(null)
        }
        btnclose.setOnClickListener{
            var close :String? = null
            if(inputtext.text.length>0){
                val stringBuilder: StringBuilder = java.lang.StringBuilder(inputtext.text)
                val find = inputtext.text.toString()
                val find2 = find.last()
                if (find2.equals('+')||find2.equals('-')||find2.equals('*')||find2.equals('/')||find2.equals('%')){
                    check = check-1
                }
                stringBuilder.deleteCharAt(inputtext.text.length-1)
                close = stringBuilder.toString()
                inputtext.setText(close)
                result(close)
            }
        }

    }

    private fun result(text: String) {
val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any = engine.eval(text)
            var mainr = result.toString()
            if (check ==0){
                resulttext.setText(null)
            }
            else{
                resulttext.setText(mainr)
            }
        }
        catch (e : ScriptException)
        {
            Log.d("Tag","Error")
        }
    }
}