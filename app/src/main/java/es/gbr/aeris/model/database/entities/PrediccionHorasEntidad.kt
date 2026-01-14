package es.gbr.aeris.model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

// Tabla de predicción por horas
@Entity(
    tableName = "prediccion_hora",
    foreignKeys = [ForeignKey(
        entity = CiudadEntidad::class,
        parentColumns = ["id_ciudad"],
        childColumns = ["id_ciudad_fk"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["id_ciudad_fk"])]
)
data class PrediccionHorasEntidad(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_hora")
    val idHora: Int = 0,

    @ColumnInfo(name = "id_ciudad_fk")
    val idCiudadFk: Int,

    @ColumnInfo(name = "hora")
    val hora: String,

    @ColumnInfo(name = "temperatura")
    val temperatura: Double,

    @ColumnInfo(name = "codigo_icono")
    val codigoIcono: String
)
