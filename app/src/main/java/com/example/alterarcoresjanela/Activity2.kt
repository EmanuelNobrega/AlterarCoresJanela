package com.example.alterarcoresjanela

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class Activity2 : AppCompatActivity() {

    private lateinit var tvColor: TextView
    private lateinit var alpha: SeekBar
    private lateinit var redColor: SeekBar
    private lateinit var greenColor: SeekBar
    private lateinit var blueColor: SeekBar

    private lateinit var tvAlpha: TextView
    private lateinit var tvRed: TextView
    private lateinit var tvGreen: TextView
    private lateinit var tvBlue: TextView

    private lateinit var btSave: Button
    private lateinit var btCancel: Button


    var start = 0
    var end = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        this.tvColor = findViewById(R.id.TV2_Color)
        this.alpha = findViewById(R.id.Alpha)
        this.redColor = findViewById(R.id.Red)
        this.greenColor = findViewById(R.id.Green)
        this.blueColor = findViewById(R.id.Blue)

        this.tvAlpha = findViewById(R.id.TVAlpha)
        this.tvRed = findViewById(R.id.TVRed)
        this.tvGreen = findViewById(R.id.TVGreen)
        this.tvBlue = findViewById(R.id.TVBlue)

        this.btSave = findViewById(R.id.BTSave)
        this.btCancel = findViewById(R.id.BTCancel)

        tvColor.setTextColor(Color.WHITE)
        tvColor.setBackgroundColor(Color.BLACK)

        this.alpha.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvColor.setBackgroundColor(Color.argb(progress, this@Activity2.redColor.progress, this@Activity2.greenColor.progress, this@Activity2.blueColor.progress))
                tvColor.text = java.lang.Integer.toHexString(this@Activity2.alpha.progress).toString() + java.lang.Integer.toHexString(this@Activity2.redColor.progress).toString() + java.lang.Integer.toHexString(this@Activity2.greenColor.progress).toString() + java.lang.Integer.toHexString(this@Activity2.blueColor.progress).toString()
                tvAlpha.text = progress.toString()
                color()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    start = seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    end = seekBar.progress
                }
            }

        })

        redColor.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvColor.setBackgroundColor(Color.argb(this@Activity2.alpha.progress, progress, this@Activity2.greenColor.progress, this@Activity2.blueColor.progress))
                tvColor.text = java.lang.Integer.toHexString(this@Activity2.alpha.progress).toString() + java.lang.Integer.toHexString(this@Activity2.redColor.progress).toString() + java.lang.Integer.toHexString(this@Activity2.greenColor.progress).toString() + java.lang.Integer.toHexString(this@Activity2.blueColor.progress).toString()
                tvRed.text = progress.toString()
                color()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    start = seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    end = seekBar.progress
                }
            }

        })

        this.greenColor.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvColor.setBackgroundColor(Color.argb(this@Activity2.alpha.progress, this@Activity2.redColor.progress, progress, this@Activity2.blueColor.progress))
                tvColor.text = java.lang.Integer.toHexString(this@Activity2.alpha.progress).toString() + java.lang.Integer.toHexString(this@Activity2.redColor.progress).toString() + java.lang.Integer.toHexString(this@Activity2.greenColor.progress).toString() + java.lang.Integer.toHexString(this@Activity2.blueColor.progress).toString()
                tvGreen.text = progress.toString()
                color()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    start = seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    end = seekBar.progress
                }
            }

        })

        this.blueColor.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvColor.setBackgroundColor(Color.argb(this@Activity2.alpha.progress, this@Activity2.redColor.progress, this@Activity2.greenColor.progress, progress))
                tvColor.text = java.lang.Integer.toHexString(this@Activity2.alpha.progress).toString() + java.lang.Integer.toHexString(this@Activity2.redColor.progress).toString() + java.lang.Integer.toHexString(this@Activity2.greenColor.progress).toString() + java.lang.Integer.toHexString(this@Activity2.blueColor.progress).toString()
                tvBlue.text = progress.toString()
                color()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    start = seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    end = seekBar.progress
                }
            }

        })

        this.btSave.setOnClickListener{
            val intent2 = Intent(this, MainActivity::class.java)
            intent2.putExtra("alpha",this@Activity2.alpha.progress )
            intent2.putExtra("red",this@Activity2.redColor.progress )
            intent2.putExtra("green",this@Activity2.greenColor.progress )
            intent2.putExtra("blue",this@Activity2.blueColor.progress )
            setResult(RESULT_OK, intent2)
            this.finish()
        }

        this.btCancel.setOnClickListener{
            setResult(RESULT_CANCELED)
            this.finish()
        }

    }




    fun color(){
        if (this@Activity2.redColor.progress + this@Activity2.greenColor.progress + this@Activity2.blueColor.progress < 120 && this@Activity2.alpha.progress > 100){
            tvColor.setTextColor(Color.WHITE)
        }
        else{
            tvColor.setTextColor(Color.BLACK)
        }

    }
}