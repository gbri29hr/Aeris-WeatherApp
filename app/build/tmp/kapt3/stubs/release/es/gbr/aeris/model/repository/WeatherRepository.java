package es.gbr.aeris.model.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bJ\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Les/gbr/aeris/model/repository/WeatherRepository;", "", "weatherDao", "Les/gbr/aeris/model/database/dao/WeatherDao;", "(Les/gbr/aeris/model/database/dao/WeatherDao;)V", "insertarCiudad", "", "ciudad", "Les/gbr/aeris/model/database/entities/CiudadEntidad;", "(Les/gbr/aeris/model/database/entities/CiudadEntidad;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "obtenerCiudadesConTiempoActual", "Landroidx/lifecycle/LiveData;", "", "Les/gbr/aeris/model/database/relations/CiudadConTiempoActual;", "obtenerPrediccionDiaria", "Les/gbr/aeris/model/database/entities/PrediccionDiariaEntidad;", "idCiudad", "", "obtenerPrediccionHoras", "Les/gbr/aeris/model/database/entities/PrediccionHorasEntidad;", "obtenerTiempoActual", "Les/gbr/aeris/model/database/entities/TiempoActualEntidad;", "obtenerTodasLasCiudades", "app_release"})
public final class WeatherRepository {
    @org.jetbrains.annotations.NotNull()
    private final es.gbr.aeris.model.database.dao.WeatherDao weatherDao = null;
    
    public WeatherRepository(@org.jetbrains.annotations.NotNull()
    es.gbr.aeris.model.database.dao.WeatherDao weatherDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.entities.CiudadEntidad>> obtenerTodasLasCiudades() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<es.gbr.aeris.model.database.entities.TiempoActualEntidad> obtenerTiempoActual(int idCiudad) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.entities.PrediccionHorasEntidad>> obtenerPrediccionHoras(int idCiudad) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.entities.PrediccionDiariaEntidad>> obtenerPrediccionDiaria(int idCiudad) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.relations.CiudadConTiempoActual>> obtenerCiudadesConTiempoActual() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertarCiudad(@org.jetbrains.annotations.NotNull()
    es.gbr.aeris.model.database.entities.CiudadEntidad ciudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
}