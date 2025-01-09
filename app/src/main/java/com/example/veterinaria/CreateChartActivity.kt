package com.example.veterinaria

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.example.veterinaria.classes.Especie
import com.example.veterinaria.classes.Mascota
import com.example.veterinaria.classes.Raza
import com.example.veterinaria.viewModels.MascotaViewModel
import java.util.Locale

class CreateChartActivity : AppCompatActivity() {
    private lateinit var mascotaViewModel: MascotaViewModel
    private lateinit var editTextDate2: EditText
    private var selectedDate: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_ficha_medica)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Crear Ficha Médica"

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        mascotaViewModel = ViewModelProvider(this).get(MascotaViewModel::class.java)

        editTextDate2 = findViewById(R.id.editTextDate2)
        editTextDate2.setOnClickListener {
            showDatePickerDialog()
        }

        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener {
            saveMascota()
        }
    }

    private fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                selectedDate.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                editTextDate2.setText(dateFormat.format(selectedDate.time))
            },
            selectedDate.get(Calendar.YEAR),
            selectedDate.get(Calendar.MONTH),
            selectedDate.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun saveMascota() {
        val nombre = findViewById<EditText>(R.id.editTextText).text.toString()
        val peso = findViewById<EditText>(R.id.editTextText3).text.toString().toDouble()
        val especie = findViewById<EditText>(R.id.editTextText4).text.toString()
        val raza = findViewById<EditText>(R.id.editTextText5).text.toString()
        val fechaNacimiento = selectedDate.time

        val nuevaMascota = Mascota(
            id = 0, // Assuming auto-generate
            nombre = nombre,
            fechaNacimiento = fechaNacimiento,
            foto = "", // Add logic to handle photo
            peso = peso,
            raza = Raza(0, raza, listOf(Especie(0, especie))) // Adjust as needed
        )

        mascotaViewModel.insertMascota(nuevaMascota)
        finish() // Close the activity
    }
}