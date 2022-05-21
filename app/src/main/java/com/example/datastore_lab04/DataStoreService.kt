package com.example.datastore_lab04

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreService(private val context: Context) {

    companion object {
        private const val DATASTORE_NAME = "user_preferences"

        private val PERIODO_ACADEMICO_KEY = stringPreferencesKey("periodo_academico_key")
        private val ESCUELA_PROFESIONAL_KEY = stringPreferencesKey("escuela_profesional_key")
        private val CODIGO_ASIGNATURA_KEY = stringPreferencesKey("codigo_asignatura_key")
        private val NOMBRE__ASIGNATURA_KEY = stringPreferencesKey("nombre_asignatura_key")
        private val SEMESTRE_KEY = stringPreferencesKey("semestre_key")
        private val DURACION_KEY = stringPreferencesKey("duracion_key")

        // Modificadores de estilo
        private val COLOR_BACKGROUND_KEY = stringPreferencesKey("color_background_key")
        private val TAMANIO_FUENTE_KEY = floatPreferencesKey("tamanio_fuente_key")
        private val TIPO_FUENTE_KEY = stringPreferencesKey("tipo_fuente_key")

        private val Context.dataStoreService by preferencesDataStore(
            name = DATASTORE_NAME
        )
    }

    /* ***********************************************************************************
     * Funciones definidas para poder almacenar y obtener valores desde cualquier clase
     * ***********************************************************************************/
    suspend fun setPeriodoAcademico(periodoAcademicoValue: String) {
        context.dataStoreService.edit { preferences ->
            preferences[PERIODO_ACADEMICO_KEY] = periodoAcademicoValue
        }
    }

    val periodoAcademico: Flow<String>
        get() = context.dataStoreService.data.map { preferences ->
            preferences[PERIODO_ACADEMICO_KEY] ?: "";
        }

    suspend fun setEscuelaProfesional(escuelaProfesionalValue: String) {
        context.dataStoreService.edit { preferences ->
            preferences[ESCUELA_PROFESIONAL_KEY] = escuelaProfesionalValue
        }
    }

    val escuelaProfesional: Flow<String>
        get() = context.dataStoreService.data.map { preferences ->
            preferences[ESCUELA_PROFESIONAL_KEY] ?: "";
        }

    suspend fun setCodigoAsignatura(codigoAsignaturaValue: String) {
        context.dataStoreService.edit { preferences ->
            preferences[CODIGO_ASIGNATURA_KEY] = codigoAsignaturaValue
        }
    }

    val codigoAsignatura: Flow<String>
        get() = context.dataStoreService.data.map { preferences ->
            preferences[CODIGO_ASIGNATURA_KEY] ?: "";
        }

    suspend fun setNombreAsignatura(nombreAsignaturaValue: String) {
        context.dataStoreService.edit { preferences ->
            preferences[NOMBRE__ASIGNATURA_KEY] = nombreAsignaturaValue
        }
    }

    val nombreAsignatura: Flow<String>
        get() = context.dataStoreService.data.map { preferences ->
            preferences[NOMBRE__ASIGNATURA_KEY] ?: "";
        }

    suspend fun setSemestre(semestreValue: String) {
        context.dataStoreService.edit { preferences ->
            preferences[SEMESTRE_KEY] = semestreValue
        }
    }

    val semestre: Flow<String>
        get() = context.dataStoreService.data.map { preferences ->
            preferences[SEMESTRE_KEY] ?: "";
        }

    suspend fun setDuracion(duracionKey: String) {
        context.dataStoreService.edit { preferences ->
            preferences[DURACION_KEY] = duracionKey
        }
    }

    val duracion: Flow<String>
        get() = context.dataStoreService.data.map { preferences ->
            preferences[DURACION_KEY] ?: "";
        }

    suspend fun setColorBackground(colorBackgroundValue: String) {
        context.dataStoreService.edit { preferences ->
            preferences[COLOR_BACKGROUND_KEY] = colorBackgroundValue
        }
    }

    val colorBackground: Flow<String>
        get() = context.dataStoreService.data.map { preferences ->
            preferences[COLOR_BACKGROUND_KEY] ?: Color.WHITE.toString();
        }

    suspend fun setTamanioFuente(tamanioFuenteValue: Float) {
        context.dataStoreService.edit { preferences ->
            preferences[TAMANIO_FUENTE_KEY] = tamanioFuenteValue
        }
    }

    val tamanioFuente: Flow<Float>
        get() = context.dataStoreService.data.map { preferences ->
            preferences[TAMANIO_FUENTE_KEY] ?: 12f;

        }

    suspend fun setTipoFuente(tipoFuente: String) {
        context.dataStoreService.edit { preferences ->
            preferences[TIPO_FUENTE_KEY] = tipoFuente
        }
    }

    val tipoFuente: Flow<String>
        get() = context.dataStoreService.data.map { preferences ->
            preferences[TIPO_FUENTE_KEY] ?: Typeface.SANS_SERIF.toString()
        }
}