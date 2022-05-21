package com.example.datastore_lab04

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    lateinit var txtView1: TextView
    lateinit var txtView2: TextView
    lateinit var txtView3: TextView
    lateinit var txtView4: TextView
    lateinit var txtView5: TextView
    lateinit var txtView6: TextView
    lateinit var txtView7: TextView
    lateinit var editTextPeriodoAcademico: EditText
    lateinit var editTextEscuelaProfesional: EditText
    lateinit var editTextCodigoDeAsignatura: EditText
    lateinit var editTextNombreDeAsignatura: EditText
    lateinit var editTextSemestre: EditText
    lateinit var editTextDuracion: EditText
    lateinit var btnVolver: Button
    lateinit var layoutScreen: ScrollView
    lateinit var dataStoreManager: DataStoreService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        editTextPeriodoAcademico = findViewById(R.id.editTextPeriodoAcademico)
        editTextEscuelaProfesional = findViewById(R.id.editTextEscuelaProfesional)
        editTextCodigoDeAsignatura = findViewById(R.id.editTextCodAsignatura)
        editTextNombreDeAsignatura = findViewById(R.id.editTextNombreDeLaAsignatura)
        editTextSemestre = findViewById(R.id.editTextSemestre)
        editTextDuracion = findViewById(R.id.editTextDuracion)

        txtView1 = findViewById(R.id.txtView1)
        txtView2 = findViewById(R.id.txtView_Main4)
        txtView3 = findViewById(R.id.txtView_Main5)
        txtView4 = findViewById(R.id.txtView_Main6)
        txtView5 = findViewById(R.id.txtView_Main7)
        txtView6 = findViewById(R.id.txtView_Main8)
        txtView7 = findViewById(R.id.txtView_Main9)

        // Referencia a DataStore Manger
        dataStoreManager = DataStoreService(this)

        // Referencia a la pantalla
        layoutScreen = findViewById(R.id.lyt_ScrollViewMain2)

        // Boton de regreso
        btnVolver = findViewById(R.id.btnVolver)
        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        /* ***********************************
         * Inicializando valores de DataStore
         * ***********************************/
        // Color de fondo
        lifecycleScope.launch {
            dataStoreManager.colorBackground.collect { colorBackground ->
                layoutScreen.setBackgroundColor(Integer.parseInt(colorBackground))
            }
        }

        // Dato de periodo Academico
        lifecycleScope.launch {
            dataStoreManager.periodoAcademico.collect { periodoAcademico ->
                editTextPeriodoAcademico.setText(periodoAcademico)
            }
        }

        // Dato de escuela profesional
        lifecycleScope.launch {
            dataStoreManager.escuelaProfesional.collect { escuelaProfesional ->
                editTextEscuelaProfesional.setText(escuelaProfesional)
            }
        }

        // Dato de codigo de asignatura
        lifecycleScope.launch {
            dataStoreManager.codigoAsignatura.collect { codigoAsignatura ->
                editTextCodigoDeAsignatura.setText(codigoAsignatura)
            }
        }

        // Dato de nombre de asignatura
        lifecycleScope.launch {
            dataStoreManager.nombreAsignatura.collect { nombreAsignatura ->
                editTextNombreDeAsignatura.setText(nombreAsignatura)
            }
        }

        // Dato de semestre
        lifecycleScope.launch {
            dataStoreManager.semestre.collect { semestre ->
                editTextSemestre.setText(semestre)
            }
        }

        // Dato de duracion
        lifecycleScope.launch {
            dataStoreManager.duracion.collect { duracion ->
                editTextDuracion.setText(duracion)
            }
        }

        /* ************************************************
         * Actualizar tamaño de fuente en los componentes
         * ***********************************************/
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView1.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }

        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }

        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView3.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView4.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView5.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView6.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tamanioFuente.collect { size ->
                txtView7.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
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
                btnVolver.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
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
                txtView1.setTypeface(getFontFamily(tipoFuente))
            }
        }

        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                txtView2.setTypeface(getFontFamily(tipoFuente))
            }
        }

        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                txtView3.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                txtView4.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                txtView5.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                txtView6.setTypeface(getFontFamily(tipoFuente))
            }
        }
        lifecycleScope.launch {
            dataStoreManager.tipoFuente.collect { tipoFuente ->
                txtView7.setTypeface(getFontFamily(tipoFuente))
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
                btnVolver.setTypeface(getFontFamily(tipoFuente))
            }
        }
    }

}