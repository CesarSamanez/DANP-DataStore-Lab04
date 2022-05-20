package com.example.datastore_lab04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Selector de colores
        val spinnerColor: Spinner = findViewById(R.id.spinnerColor)
        val valuesColor: List<String> = listOf("White", "Black", "Yellow")

        if (spinnerColor != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, valuesColor
            )
            spinnerColor.adapter = adapter
        }

        // Selector de tamaño de fuente
        val spinnerSizeFont: Spinner = findViewById(R.id.spinnerSizeFont)
        val valuesSizeFont: List<String> = listOf("12", "14", "16", "18", "20");

        if (spinnerSizeFont != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, valuesSizeFont
            )
            spinnerSizeFont.adapter = adapter
        }

        // Selector de tipo de fuente
        val spinnerTypeFont: Spinner = findViewById(R.id.spinnerTypeFont)
        val valuesTypeFont: List<String> = listOf("Font 1", "Font 2", "Font 3");

        if (spinnerTypeFont != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, valuesTypeFont
            )
            spinnerTypeFont.adapter = adapter
        }




    }
}