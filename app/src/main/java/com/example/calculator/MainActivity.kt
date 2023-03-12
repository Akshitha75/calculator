package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonclear.setOnClickListener {

            buttoninput.text = ""
            buttonoutput.text = ""
        }

        buttonbracketleft.setOnClickListener {
            buttoninput.text = addToInputText("(")
        }
        buttonbracketright.setOnClickListener {
            buttoninput.text = addToInputText(")")
        }
        button0.setOnClickListener {
            buttoninput.text = addToInputText("0")
        }
        button1.setOnClickListener {
            buttoninput.text = addToInputText("1")
        }
        button2.setOnClickListener {
            buttoninput.text = addToInputText("2")
        }
        button3.setOnClickListener {
            buttoninput.text = addToInputText("3")
        }
        button4.setOnClickListener {
            buttoninput.text = addToInputText("4")
        }
        button5.setOnClickListener {
            buttoninput.text = addToInputText("5")
        }
        button6.setOnClickListener {
            buttoninput.text = addToInputText("6")
        }
        button7.setOnClickListener {
            buttoninput.text = addToInputText("7")
        }
        button8.setOnClickListener {
            buttoninput.text = addToInputText("8")
        }
        button9.setOnClickListener {
            buttoninput.text = addToInputText("9")
        }
        buttonpoint.setOnClickListener {
            buttoninput.text = addToInputText(".")
        }
        buttondivision.setOnClickListener {
            buttoninput.text = addToInputText("÷") // ALT + 0247
        }
        buttonmultiplication.setOnClickListener {
            buttoninput.text = addToInputText("×") // ALT + 0215
        }
        buttonminus.setOnClickListener {
            buttoninput.text = addToInputText("-")
        }
        buttonplus.setOnClickListener {
            buttoninput.text = addToInputText("+")
        }

        buttonequal.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {
        return "${buttoninput.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = buttoninput.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    @SuppressLint("SetTextI18n")
    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                buttonoutput.text = "Error"
                buttonoutput.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                buttonoutput.text = DecimalFormat("0.######").format(result).toString()
                buttonoutput.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // Show Error Message
            buttonoutput.text = "Error"
            buttonoutput.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }

   
}




