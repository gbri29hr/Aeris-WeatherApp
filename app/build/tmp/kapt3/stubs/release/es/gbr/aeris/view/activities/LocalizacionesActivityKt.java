package es.gbr.aeris.view.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a<\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a\u0084\u0001\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0010H\u0007\u00a8\u0006\u0017"}, d2 = {"ElementoLocalizacion", "", "ciudadConTiempo", "Les/gbr/aeris/model/database/relations/CiudadConTiempoActual;", "esCiudadPrincipal", "", "usarFahrenheit", "alPulsar", "Lkotlin/Function0;", "alPulsacionProlongada", "PantallaLocalizaciones", "modeloVista", "Les/gbr/aeris/viewmodel/LocalizacionesViewModel;", "alNavegarAInicio", "alNavegarAAjustes", "alSeleccionarCiudad", "Lkotlin/Function1;", "Les/gbr/aeris/model/database/entities/CiudadEntidad;", "alOcultarCiudad", "", "alMostrarCiudad", "alMostrarMensaje", "", "app_release"})
public final class LocalizacionesActivityKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void PantallaLocalizaciones(@org.jetbrains.annotations.NotNull()
    es.gbr.aeris.viewmodel.LocalizacionesViewModel modeloVista, boolean usarFahrenheit, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> alNavegarAInicio, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> alNavegarAAjustes, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super es.gbr.aeris.model.database.entities.CiudadEntidad, kotlin.Unit> alSeleccionarCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> alOcultarCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> alMostrarCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> alMostrarMensaje) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable()
    public static final void ElementoLocalizacion(@org.jetbrains.annotations.NotNull()
    es.gbr.aeris.model.database.relations.CiudadConTiempoActual ciudadConTiempo, boolean esCiudadPrincipal, boolean usarFahrenheit, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> alPulsar, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> alPulsacionProlongada) {
    }
}