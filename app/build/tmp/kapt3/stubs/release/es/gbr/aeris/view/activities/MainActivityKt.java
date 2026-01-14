package es.gbr.aeris.view.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aR\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007\u001a@\u0010\u0010\u001a\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007\u001a<\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007\u001a\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002\u001a\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0002\u001a\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0005H\u0002\u001a\u0018\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0014H\u0002\u00a8\u0006\'"}, d2 = {"ContenidoClimaPrincipal", "", "tiempo", "Les/gbr/aeris/model/database/entities/TiempoActualEntidad;", "nombreCiudad", "", "prediccionHoras", "", "Les/gbr/aeris/model/database/entities/PrediccionHorasEntidad;", "prediccionDiaria", "Les/gbr/aeris/model/database/entities/PrediccionDiariaEntidad;", "usarFahrenheit", "", "usarMph", "alSeleccionarCiudad", "Lkotlin/Function0;", "DialogoSeleccionCiudad", "ciudades", "Les/gbr/aeris/model/database/entities/CiudadEntidad;", "idCiudadSeleccionada", "", "Lkotlin/Function1;", "alCerrar", "PantallaPrincipal", "modeloVista", "Les/gbr/aeris/viewmodel/MainViewModel;", "alNavegarALocalizaciones", "alNavegarAAjustes", "celsiusAFahrenheit", "", "celsius", "kphAMph", "kph", "obtenerIconoClima", "codigoIcono", "obtenerNivelUV", "contexto", "Landroid/content/Context;", "indice", "app_release"})
public final class MainActivityKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void PantallaPrincipal(@org.jetbrains.annotations.NotNull()
    es.gbr.aeris.viewmodel.MainViewModel modeloVista, boolean usarFahrenheit, boolean usarMph, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> alNavegarALocalizaciones, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> alNavegarAAjustes) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ContenidoClimaPrincipal(@org.jetbrains.annotations.NotNull()
    es.gbr.aeris.model.database.entities.TiempoActualEntidad tiempo, @org.jetbrains.annotations.NotNull()
    java.lang.String nombreCiudad, @org.jetbrains.annotations.NotNull()
    java.util.List<es.gbr.aeris.model.database.entities.PrediccionHorasEntidad> prediccionHoras, @org.jetbrains.annotations.NotNull()
    java.util.List<es.gbr.aeris.model.database.entities.PrediccionDiariaEntidad> prediccionDiaria, boolean usarFahrenheit, boolean usarMph, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> alSeleccionarCiudad) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DialogoSeleccionCiudad(@org.jetbrains.annotations.NotNull()
    java.util.List<es.gbr.aeris.model.database.entities.CiudadEntidad> ciudades, int idCiudadSeleccionada, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super es.gbr.aeris.model.database.entities.CiudadEntidad, kotlin.Unit> alSeleccionarCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> alCerrar) {
    }
    
    private static final int obtenerIconoClima(java.lang.String codigoIcono) {
        return 0;
    }
    
    private static final java.lang.String obtenerNivelUV(android.content.Context contexto, int indice) {
        return null;
    }
    
    private static final double celsiusAFahrenheit(double celsius) {
        return 0.0;
    }
    
    private static final double kphAMph(double kph) {
        return 0.0;
    }
}