package com.example.muhammadrizwan.alertdialogue

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.dialogue_layout.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var open: Button

    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById<TextView>(R.id.tv1)
        open = findViewById<Button>(R.id.dialogue)
        open.setOnClickListener {
            openDialogue()
        }
    }

    private fun openDialogue() {
        var dialogue = AlertDialog.Builder(this)

        //inflate custom layout for alert dialogue
        var inflate = LayoutInflater.from(this).inflate(R.layout.dialogue_layout,null)
        dialogue.setTitle("Add Item").setMessage("Add Details")

        // set custom created layout to the alert dialogue
        dialogue.setView(inflate)
        dialogue.setPositiveButton("Add",object :DialogInterface.OnClickListener
        {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                var text  = inflate.ed_name.text.toString()
                tv.setText(text)
            }

        })

        //cancel button
        dialogue.setNegativeButton("Cancel",object :DialogInterface.OnClickListener
        {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                dialogue.create().dismiss()
            }

        })


        dialogue.show()
    }
}
