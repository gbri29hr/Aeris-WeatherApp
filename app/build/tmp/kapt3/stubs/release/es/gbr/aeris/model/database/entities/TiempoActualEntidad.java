package es.gbr.aeris.model.database.entities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0006H\u00c6\u0003J\t\u0010$\u001a\u00020\bH\u00c6\u0003J\t\u0010%\u001a\u00020\bH\u00c6\u0003J\t\u0010&\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0006H\u00c6\u0003J\t\u0010(\u001a\u00020\u0006H\u00c6\u0003J\t\u0010)\u001a\u00020\u0006H\u00c6\u0003Jw\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020\u0003H\u00d6\u0001J\t\u0010/\u001a\u00020\bH\u00d6\u0001R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015\u00a8\u00060"}, d2 = {"Les/gbr/aeris/model/database/entities/TiempoActualEntidad;", "", "idTiempo", "", "idCiudadFk", "temperatura", "", "descripcion", "", "codigoIcono", "tempAlta", "tempBaja", "humedad", "vientoVelocidad", "uvIndice", "precipitacion", "(IIDLjava/lang/String;Ljava/lang/String;DDDDDI)V", "getCodigoIcono", "()Ljava/lang/String;", "getDescripcion", "getHumedad", "()D", "getIdCiudadFk", "()I", "getIdTiempo", "getPrecipitacion", "getTempAlta", "getTempBaja", "getTemperatura", "getUvIndice", "getVientoVelocidad", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_release"})
@androidx.room.Entity(tableName = "tiempo_actual", foreignKeys = {@androidx.room.ForeignKey(entity = es.gbr.aeris.model.database.entities.CiudadEntidad.class, parentColumns = {"id_ciudad"}, childColumns = {"id_ciudad_fk"}, onDelete = 5)}, indices = {@androidx.room.Index(value = {"id_ciudad_fk"}, unique = true)})
public final class TiempoActualEntidad {
    @androidx.room.PrimaryKey(autoGenerate = true)
    @androidx.room.ColumnInfo(name = "id_tiempo")
    private final int idTiempo = 0;
    @androidx.room.ColumnInfo(name = "id_ciudad_fk")
    private final int idCiudadFk = 0;
    @androidx.room.ColumnInfo(name = "temperatura")
    private final double temperatura = 0.0;
    @androidx.room.ColumnInfo(name = "descripcion")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String descripcion = null;
    @androidx.room.ColumnInfo(name = "codigo_icono")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String codigoIcono = null;
    @androidx.room.ColumnInfo(name = "temp_alta")
    private final double tempAlta = 0.0;
    @androidx.room.ColumnInfo(name = "temp_baja")
    private final double tempBaja = 0.0;
    @androidx.room.ColumnInfo(name = "humedad")
    private final double humedad = 0.0;
    @androidx.room.ColumnInfo(name = "viento_velocidad")
    private final double vientoVelocidad = 0.0;
    @androidx.room.ColumnInfo(name = "uv_indice")
    private final double uvIndice = 0.0;
    @androidx.room.ColumnInfo(name = "precipitacion")
    private final int precipitacion = 0;
    
    public TiempoActualEntidad(int idTiempo, int idCiudadFk, double temperatura, @org.jetbrains.annotations.NotNull()
    java.lang.String descripcion, @org.jetbrains.annotations.NotNull()
    java.lang.String codigoIcono, double tempAlta, double tempBaja, double humedad, double vientoVelocidad, double uvIndice, int precipitacion) {
        super();
    }
    
    public final int getIdTiempo() {
        return 0;
    }
    
    public final int getIdCiudadFk() {
        return 0;
    }
    
    public final double getTemperatura() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescripcion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCodigoIcono() {
        return null;
    }
    
    public final double getTempAlta() {
        return 0.0;
    }
    
    public final double getTempBaja() {
        return 0.0;
    }
    
    public final double getHumedad() {
        return 0.0;
    }
    
    public final double getVientoVelocidad() {
        return 0.0;
    }
    
    public final double getUvIndice() {
        return 0.0;
    }
    
    public final int getPrecipitacion() {
        return 0;
    }
    
    public final int component1() {
        return 0;
    }
    
    public final double component10() {
        return 0.0;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final double component8() {
        return 0.0;
    }
    
    public final double component9() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final es.gbr.aeris.model.database.entities.TiempoActualEntidad copy(int idTiempo, int idCiudadFk, double temperatura, @org.jetbrains.annotations.NotNull()
    java.lang.String descripcion, @org.jetbrains.annotations.NotNull()
    java.lang.String codigoIcono, double tempAlta, double tempBaja, double humedad, double vientoVelocidad, double uvIndice, int precipitacion) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}