package com.example.alterarcoresjanela

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var novaCor: Button
    private lateinit var tvColor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvColor = findViewById(R.id.TV_Color)
        this.novaCor = findViewById(R.id.BTNewColor)

        val NewColor = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val alpha = it.data?.getIntExtra("alpha",0)
                val red: Int? = it.data?.getIntExtra("red",0)
                val green: Int? = it.data?.getIntExtra("green",0)
                val blue: Int? = it.data?.getIntExtra("blue",0)
                this.tvColor.setBackgroundColor(Color.argb(alpha!!,red!!,green!!,blue!!))
                this.tvColor.text = java.lang.Integer.toHexString(alpha!!).toString() + java.lang.Integer.toHexString(red!!).toString() + java.lang.Integer.toHexString(green!!).toString() + java.lang.Integer.toHexString(blue!!).toString()

            }
        }

//        val alpha:Int = intent.getIntExtra("alpha",0)
//        val red:Int = intent.getIntExtra("red",0)
//        val green:Int = intent.getIntExtra("green",0)
//        val blue:Int = intent.getIntExtra("blue",0)

        this.tvColor.setBackgroundColor(Color.argb(0,0,0,0))


        this.novaCor.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            NewColor.launch(intent)
        }


    }

}