package es.gbr.aeris.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0082@\u00a2\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J,\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010&J\u001a\u0010\'\u001a\u00020\"2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0014H\u0086@\u00a2\u0006\u0002\u0010)R,\u0010\u0005\u001a \u0012\u0004\u0012\u00020\u0007\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Les/gbr/aeris/data/api/OpenWeatherRepository;", "", "weatherDao", "Les/gbr/aeris/model/database/dao/WeatherDao;", "(Les/gbr/aeris/model/database/dao/WeatherDao;)V", "ciudadesData", "", "", "Lkotlin/Triple;", "", "buscarOCrearCiudad", "Les/gbr/aeris/model/database/entities/CiudadEntidad;", "nombre", "lat", "lon", "(Ljava/lang/String;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertirPrediccionDiaria", "", "Les/gbr/aeris/model/database/entities/PrediccionDiariaEntidad;", "idCiudad", "", "prediccion", "Les/gbr/aeris/data/api/OpenWeatherForecastResponse;", "convertirPrediccionHorariOpenWeather", "Les/gbr/aeris/model/database/entities/PrediccionHorasEntidad;", "convertirTiempoActual", "Les/gbr/aeris/model/database/entities/TiempoActualEntidad;", "climaActual", "Les/gbr/aeris/data/api/OpenWeatherCurrentResponse;", "indiceUVResponse", "Les/gbr/aeris/data/api/OpenWeatherUVResponse;", "mapearIconoOpenWeather", "iconCode", "sincronizarCiudad", "", "nombreCiudad", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sincronizarCiudadPorId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sincronizarDatosBasicos", "excluirIdCiudad", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class OpenWeatherRepository {
    @org.jetbrains.annotations.NotNull()
    private final es.gbr.aeris.model.database.dao.WeatherDao weatherDao = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, kotlin.Triple<java.lang.Double, java.lang.Double, java.lang.String>> ciudadesData = null;
    
    public OpenWeatherRepository(@org.jetbrains.annotations.NotNull()
    es.gbr.aeris.model.database.dao.WeatherDao weatherDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sincronizarCiudad(@org.jetbrains.annotations.NotNull()
    java.lang.String nombreCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sincronizarCiudadPorId(int idCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sincronizarDatosBasicos(@org.jetbrains.annotations.Nullable()
    java.lang.Integer excluirIdCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object buscarOCrearCiudad(java.lang.String nombre, double lat, double lon, kotlin.coroutines.Continuation<? super es.gbr.aeris.model.database.entities.CiudadEntidad> $completion) {
        return null;
    }
    
    private final es.gbr.aeris.model.database.entities.TiempoActualEntidad convertirTiempoActual(int idCiudad, es.gbr.aeris.data.api.OpenWeatherCurrentResponse climaActual, es.gbr.aeris.data.api.OpenWeatherForecastResponse prediccion, es.gbr.aeris.data.api.OpenWeatherUVResponse indiceUVResponse) {
        return null;
    }
    
    private final java.util.List<es.gbr.aeris.model.database.entities.PrediccionHorasEntidad> convertirPrediccionHorariOpenWeather(int idCiudad, es.gbr.aeris.data.api.OpenWeatherForecastResponse prediccion) {
        return null;
    }
    
    private final java.util.List<es.gbr.aeris.model.database.entities.PrediccionDiariaEntidad> convertirPrediccionDiaria(int idCiudad, es.gbr.aeris.data.api.OpenWeatherForecastResponse prediccion) {
        return null;
    }
    
    private final java.lang.String mapearIconoOpenWeather(java.lang.String iconCode) {
        return null;
    }
}