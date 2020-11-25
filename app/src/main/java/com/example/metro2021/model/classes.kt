package com.example.metro2021.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "linea")
data class Linea(
    @PrimaryKey
    @ColumnInfo(name = "id") // nombre columna en tabla
    var id: Int,
    @ColumnInfo(name = "nombre") // nombre columna en tabla
    var nombre: String,
    @ColumnInfo(name = "color") // nombre columna en tabla
    var color: String
)

@Entity(
    tableName = "estacion",
    foreignKeys = [ForeignKey(
        entity = Linea::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("linea")
    )]
)
data class Estacion(
    @PrimaryKey
    @ColumnInfo(name = "id") // nombre columna en tabla
    var id: Int,
    @ColumnInfo(name = "nombre") // nombre columna en tabla
    var nombre: String,
    @ColumnInfo(name = "linea") // nombre columna en tabla
    var linea: Int
)

@Entity(tableName = "estacionView")
data class EstacionView(
    @PrimaryKey
    @ColumnInfo(name = "id") // nombre columna en tabla
    var id: Int,
    @ColumnInfo(name = "nombre") // nombre columna en tabla
    var nombre: String,
    @ColumnInfo(name = "linea") // nombre columna en tabla
    var linea: Int,
    @ColumnInfo(name = "correspondencias") // nombre columna en tabla
    var listCorrespondencias: List<Linea>
)

@Entity(tableName = "lineaView")
data class LineaView(
    @PrimaryKey
    @ColumnInfo(name = "id") // nombre columna en tabla
    var id: Int,
    @ColumnInfo(name = "nombre") // nombre columna en tabla
    var nombre: String,
    @ColumnInfo(name = "color") // nombre columna en tabla
    var color: String,
    @ColumnInfo(name = "eini") // nombre columna en tabla
    var eini: String,
    @ColumnInfo(name = "efin") // nombre columna en tabla
    var efin: String
): Serializable
