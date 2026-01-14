package es.gbr.aeris.model.database.entities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0006H\u00d6\u0001R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Les/gbr/aeris/model/database/entities/PrediccionHorasEntidad;", "", "idHora", "", "idCiudadFk", "hora", "", "temperatura", "", "codigoIcono", "(IILjava/lang/String;DLjava/lang/String;)V", "getCodigoIcono", "()Ljava/lang/String;", "getHora", "getIdCiudadFk", "()I", "getIdHora", "getTemperatura", "()D", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"})
@androidx.room.Entity(tableName = "prediccion_hora", foreignKeys = {@androidx.room.ForeignKey(entity = es.gbr.aeris.model.database.entities.CiudadEntidad.class, parentColumns = {"id_ciudad"}, childColumns = {"id_ciudad_fk"}, onDelete = 5)}, indices = {@androidx.room.Index(value = {"id_ciudad_fk"})})
public final class PrediccionHorasEntidad {
    @androidx.room.PrimaryKey(autoGenerate = true)
    @androidx.room.ColumnInfo(name = "id_hora")
    private final int idHora = 0;
    @androidx.room.ColumnInfo(name = "id_ciudad_fk")
    private final int idCiudadFk = 0;
    @androidx.room.ColumnInfo(name = "hora")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String hora = null;
    @androidx.room.ColumnInfo(name = "temperatura")
    private final double temperatura = 0.0;
    @androidx.room.ColumnInfo(name = "codigo_icono")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String codigoIcono = null;
    
    public PrediccionHorasEntidad(int idHora, int idCiudadFk, @org.jetbrains.annotations.NotNull()
    java.lang.String hora, double temperatura, @org.jetbrains.annotations.NotNull()
    java.lang.String codigoIcono) {
        super();
    }
    
    public final int getIdHora() {
        return 0;
    }
    
    public final int getIdCiudadFk() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHora() {
        return null;
    }
    
    public final double getTemperatura() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCodigoIcono() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final double component4() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final es.gbr.aeris.model.database.entities.PrediccionHorasEntidad copy(int idHora, int idCiudadFk, @org.jetbrains.annotations.NotNull()
    java.lang.String hora, double temperatura, @org.jetbrains.annotations.NotNull()
    java.lang.String codigoIcono) {
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