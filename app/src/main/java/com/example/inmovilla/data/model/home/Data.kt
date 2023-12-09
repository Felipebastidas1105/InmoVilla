package com.example.inmovilla.data.model.home

data class Data(
    val AgentId: Int,
    val Amueblado: String,
    val Area_Inmueble: String,
    val Cant_Baños: String,
    val Cant_Cuartos: String,
    val Caracteristicas_Extra: String,
    val Codigo_Vivienda: Int,
    val Descripcion: String,
    val Direccion: String,
    val Estado: String,
    val Imagen: List<String>,
    val Latitud: Double,
    val Longitud: Double,
    val Precio: Int,
    val Precio_Venta: String,
    val Tiene_Garaje_Carro: String,
    val Tiene_Garaje_Moto: String,
    val Tiene_Patio: String,
    val Tiene_Servicios_Incluidos: String,
    val TypehousingId: Int,
    val TypetargetId: Int,
    val createdAt: String,
    val id: Int,
    val updatedAt: String
)