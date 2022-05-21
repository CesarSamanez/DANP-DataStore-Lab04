package com.example.datastore_lab04

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.*
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var txtView_Main1: TextView
    lateinit var txtView_Main2: TextView
    lateinit var txtView_Main3: TextView
    lateinit var txtView_Main4: TextView
    lateinit var txtView_Main5: TextView
    lateinit var txtView_Main6: TextView
    lateinit var txtView_Main7: TextView
    lateinit var txtView_Main8: TextView
    lateinit var txtView_Main9: TextView
    lateinit var editTextPeriodoAcademico: EditText
    lateinit var editTextEscuelaProfesional: EditText
    lateinit var editTextCodigoDeAsignatura: EditText
    lateinit var editTextNombreDeAsignatura: EditText
    lateinit var editTextSemestre: EditText
    lateinit var editTextDuracion: EditText
    lateinit var buttonGuardar: Button
    lateinit var buttonVerRegistro: Button
    lateinit var spinnerColor: Spinner
    lateinit var spinnerSizeFont: Spinner
    lateinit var spinnerTypeFont: Spinner
    lateinit var layoutScreen: ScrollView
    lateinit var dataStoreManager: DataStoreService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializacion DataStore
        dataStoreManager = DataStoreService(this)

        // Inicializacion de componentes
        editTextPeriodoAcademico = findViewById(R.id.editTextPeriodoAcademico)
        editTextEscuelaProfesional = findViewById(R.id.editTextEscuelaProfesional)
        editTextCodigoDeAsignatura = findViewById(R.id.editTextCodAsignatura)
        editTextNombreDeAsignatura = findViewById(R.id.editTextNombreDeLaAsignatura)
        editTextSemestre = findViewById(R.id.editTextSemestre)
        editTextDuracion = findViewById(R.id.editTextDuracion)

        txtView_Main1 = findViewById(R.id.txtView_Main1)
        txtView_Main2 = findViewById(R.id.txtView_Main2)
        txtView_Main3 = findViewById(R.id.txtView_Main3)
        txtView_Main4 = findViewById(R.id.txtView_Main4)
        txtView_Main5 = findViewById(R.id.txtView_Main5)
        txtView_Main6 = findViewById(R.id.txtView_Main6)
        txtView_Main7 = findViewById(R.id.txtView_Main7)
        txtView_Main8 = findViewById(R.id.txtView_Main8)
        txtView_Main9 = findViewById(R.id.txtView_Main9)

        // Selector de colores
        spinnerColor = findViewById(R.id.spinnerColor)
        val valuesColor: List<String> = listOf("White", "Red", "Yellow", "Green")

        if (spinnerColor != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, valuesColor
            )
            spinnerColor.adapter = adapter
        }

        // Selector de tamaño de fuente
        spinnerSizeFont = findViewById(R.id.spinnerSizeFont)
        val valuesSizeFont: List<String> = listOf("12", "14", "16", "18", "20", "22", "24", "26");

        if (spinnerSizeFont != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, valuesSizeFont
            )
            spinnerSizeFont.adapter = adapter
        }

        // Selector de tipo de fuente
        spinnerTypeFont = findViewById(R.id.spinnerTypeFont)
        val valuesTypeFont: List<String> = listOf("Serif", "Sans Serif", "Monospace");

        if (spinnerTypeFont != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, valuesTypeFont
            )
            spinnerTypeFont.adapter = adapter
        }

        // Funcionalidad boton para ver el registro almacenado
        buttonVerRegistro = findViewById(R.id.btnVerRegistro)
        buttonVerRegistro.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        // Funcionalidad para almacenar un nuevo registro
        buttonGuardar = findViewById(R.id.btnGuardar)
        buttonGuardar.setOnClickListener {
            lifecycleScope.launch {
                dataStoreManager.setPeriodoAcademico(editTextPeriodoAcademico.text.toString())
            }

            lifecycleScope.launch {
                dataStoreManager.setEscuelaProfesional(editTextEscuelaProfesional.text.toString())
            }

            lifecycleScope.launch {
                dataStoreManager.setCodigoAsignatura(editTextCodigoDeAsignatura.text.toString())
            }

            lifecycleScope.launch {
                dataStoreManager.setNombreAsignatura(editTextNombreDeAsignatura.text.toString())
            }

            lifecycleScope.launch {
                dataStoreManager.setSemestre(editTextSemestre.text.toString())
            }

            lifecycleScope.launch {
                dataStoreManager.setDuracion(editTextDuracion.text.toString())
            }

            lifecycleScope.launch {
                val color = spinnerColor.selectedItem.toString()

                when (color) {
                    "White" -> dataStoreManager.setColorBackground(Color.WHITE.toString())
                    "Red" -> dataStoreManager.setColorBackground(Color.RED.toString())
                    "Yellow" -> dataStoreManager.setColorBackground(Color.YELLOW.toString())
                    "Green" -> dataStoreManager.setColorBackground(Color.GREEN.toString())
                }
            }

            lifecycleScope.launch {
                val sizeFont = spinnerSizeFont.selectedItem.toString()

                when (sizeFont) {
                    "12" -> dataStoreManager.setTamanioFuente(12.0f)
                    "14" -> dataStoreManager.setTamanioFuente(14.0f)
                    "16" -> dataStoreManager.setTamanioFuente(16.0f)
                    "18" -> dataStoreManager.setTamanioFuente(18.0f)
                    "20" -> dataStoreManager.setTamanioFuente(20.0f)
                    "22" -> dataStoreManager.setTamanioFuente(22.0f)
                    "24" -> dataStoreManager.setTamanioFuente(24.0f)
                    "26" -> dataStoreManager.setTamanioFuente(26.0f)
                }
            }

            lifecycleScope.launch {
                val typeFont = spinnerSizeFont.selectedItem.toString()

                when (typeFont) {
                    "Serif" -> dataStoreManager.setTipoFuente(Typeface.SERIF.toString())
                    "Sans Serif" -> dataStoreManager.setTipoFuente(Typeface.SANS_SERIF.toString())
                    "Monospace" -> dataStoreManager.setTipoFuente(Typeface.MONOSPACE.toString())
                }
            }

            // Cambiar de activity para ver el registro almacenado y refresco de datos
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        /* ************************************************
         * Actualizar tamaño de fuente en los componentes
         * ***********************************************/
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView_Main1.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView_Main2.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView_Main3.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView_Main4.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView_Main5.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView_Main6.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView_Main7.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView_Main8.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView_Main9.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                editTextPeriodoAcademico.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                editTextEscuelaProfesional.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                editTextCodigoDeAsignatura.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                editTextNombreDeAsignatura.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                editTextSemestre.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                editTextDuracion.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                buttonVerRegistro.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                buttonGuardar.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }

        /* ************************************************
         * Actualizar tipo de fuente en los componentes
         * ***********************************************/

        // Funcion para convertir el tipo de fuente a valor
        fun getFontFamily(value: String): Typeface {
            when (value) {
                Typeface.SERIF.toString() -> return Typeface.SERIF
                Typeface.SANS_SERIF.toString() -> return Typeface.SANS_SERIF
                Typeface.MONOSPACE.toString() -> return Typeface.MONOSPACE
            }
            return Typeface.SANS_SERIF
        }

        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                txtView_Main1.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                txtView_Main2.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                txtView_Main3.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                txtView_Main4.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                txtView_Main5.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                txtView_Main6.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                txtView_Main7.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                txtView_Main8.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                txtView_Main9.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                editTextPeriodoAcademico.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                editTextEscuelaProfesional.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                editTextCodigoDeAsignatura.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                editTextNombreDeAsignatura.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                editTextSemestre.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                editTextDuracion.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                buttonVerRegistro.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                buttonGuardar.setTypeface(getFontFamily(tipoFuente))
            }
        }

        // Referencia a la pantalla para poder aplicar la propiedad de cambio de color de fondo
        layoutScreen = findViewById(R.id.lyt_ScrollViewMain)
        // Color de fondo
        lifecycleScope.launch {
            dataStoreManager.colorBackground.collect { colorBackground ->
                layoutScreen.setBackgroundColor(Integer.parseInt(colorBackground))
            }
        }
    }
}