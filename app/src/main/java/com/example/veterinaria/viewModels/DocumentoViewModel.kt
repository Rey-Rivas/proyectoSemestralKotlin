package com.example.veterinaria.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Documento
import java.io.File

class DocumentoViewModel : ViewModel() {
    private val _documento = MutableLiveData<Documento>()
    val documento: MutableLiveData<Documento> = _documento

    fun adjuntarArchivo(archivo: File) {
        val ruta = archivo.absolutePath
        _documento.value?.let {
            val updatedDocumento = it.copy(ruta = ruta)
            _documento.value = updatedDocumento
        }
    }
}