package es.gbr.aeris.model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

// Tabla de predicción por días
@Entity(
    tableName = "prediccion_dia",
    foreignKeys = [ForeignKey(
        entity = CiudadEntidad::class,
        parentColumns = ["id_ciudad"],
        childColumns = ["id_ciudad_fk"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["id_ciudad_fk"])]
)
data class PrediccionDiariaEntidad(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_dia")
    val idDia: Int = 0,

    @ColumnInfo(name = "id_ciudad_fk")
    val idCiudadFk: Int,

    @ColumnInfo(name = "nombre_dia")
    val nombreDia: String, // Ej: "Martes"

    @ColumnInfo(name = "temp_alta")
    val tempAlta: Double,

    @ColumnInfo(name = "temp_baja")
    val tempBaja: Double,

    @ColumnInfo(name = "codigo_icono")
    val codigoIcono: String
)
