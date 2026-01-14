package es.gbr.aeris.model.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u00a7@\u00a2\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001bH\u00a7@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u00a7@\u00a2\u0006\u0002\u0010$J\u0018\u0010%\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u001b0\'H\'J\u001c\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\'2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u001c\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001b0\'2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020#0\'2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001b0\'H\'\u00a8\u0006-"}, d2 = {"Les/gbr/aeris/model/database/dao/WeatherDao;", "", "actualizarCoordenadasCiudad", "", "idCiudad", "", "latitud", "", "longitud", "(IDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buscarCiudadPorNombre", "Les/gbr/aeris/model/database/entities/CiudadEntidad;", "nombre", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "eliminarCiudadPorId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "eliminarCiudadesDuplicadas", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "eliminarDiasPorCiudad", "eliminarHorasPorCiudad", "insertarCiudad", "", "ciudad", "(Les/gbr/aeris/model/database/entities/CiudadEntidad;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertarListaDias", "listaDias", "", "Les/gbr/aeris/model/database/entities/PrediccionDiariaEntidad;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertarListaHoras", "listaHoras", "Les/gbr/aeris/model/database/entities/PrediccionHorasEntidad;", "insertarTiempoActual", "tiempo", "Les/gbr/aeris/model/database/entities/TiempoActualEntidad;", "(Les/gbr/aeris/model/database/entities/TiempoActualEntidad;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "obtenerCiudadPorId", "obtenerCiudadesConTiempoActual", "Landroidx/lifecycle/LiveData;", "Les/gbr/aeris/model/database/relations/CiudadConTiempoActual;", "obtenerPrediccionDiaria", "obtenerPrediccionHoras", "obtenerTiempoActual", "obtenerTodasLasCiudades", "app_release"})
@androidx.room.Dao()
public abstract interface WeatherDao {
    
    @androidx.room.Query(value = "SELECT * FROM ciudades")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.entities.CiudadEntidad>> obtenerTodasLasCiudades();
    
    @androidx.room.Query(value = "SELECT * FROM tiempo_actual WHERE id_ciudad_fk = :idCiudad")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<es.gbr.aeris.model.database.entities.TiempoActualEntidad> obtenerTiempoActual(int idCiudad);
    
    @androidx.room.Query(value = "SELECT * FROM prediccion_hora WHERE id_ciudad_fk = :idCiudad ORDER BY id_hora ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.entities.PrediccionHorasEntidad>> obtenerPrediccionHoras(int idCiudad);
    
    @androidx.room.Query(value = "SELECT * FROM prediccion_dia WHERE id_ciudad_fk = :idCiudad ORDER BY id_dia ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.entities.PrediccionDiariaEntidad>> obtenerPrediccionDiaria(int idCiudad);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertarCiudad(@org.jetbrains.annotations.NotNull()
    es.gbr.aeris.model.database.entities.CiudadEntidad ciudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM ciudades WHERE nombre = :nombre LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object buscarCiudadPorNombre(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super es.gbr.aeris.model.database.entities.CiudadEntidad> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM ciudades WHERE id_ciudad = :idCiudad LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object obtenerCiudadPorId(int idCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super es.gbr.aeris.model.database.entities.CiudadEntidad> $completion);
    
    @androidx.room.Query(value = "UPDATE ciudades SET latitud = :latitud, longitud = :longitud WHERE id_ciudad = :idCiudad")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object actualizarCoordenadasCiudad(int idCiudad, double latitud, double longitud, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertarTiempoActual(@org.jetbrains.annotations.NotNull()
    es.gbr.aeris.model.database.entities.TiempoActualEntidad tiempo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertarListaHoras(@org.jetbrains.annotations.NotNull()
    java.util.List<es.gbr.aeris.model.database.entities.PrediccionHorasEntidad> listaHoras, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM prediccion_hora WHERE id_ciudad_fk = :idCiudad")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object eliminarHorasPorCiudad(int idCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM prediccion_dia WHERE id_ciudad_fk = :idCiudad")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object eliminarDiasPorCiudad(int idCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertarListaDias(@org.jetbrains.annotations.NotNull()
    java.util.List<es.gbr.aeris.model.database.entities.PrediccionDiariaEntidad> listaDias, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM ciudades WHERE id_ciudad = :idCiudad")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object eliminarCiudadPorId(int idCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "\n        DELETE FROM ciudades \n        WHERE id_ciudad NOT IN (\n            SELECT MIN(id_ciudad) FROM ciudades GROUP BY nombre\n        )\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object eliminarCiudadesDuplicadas(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Transaction()
    @androidx.room.Query(value = "SELECT * FROM ciudades ORDER BY id_ciudad")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.relations.CiudadConTiempoActual>> obtenerCiudadesConTiempoActual();
}