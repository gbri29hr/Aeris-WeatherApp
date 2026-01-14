package es.gbr.aeris.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0014\u0010\u001b\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0013J\u0006\u0010\u001f\u001a\u00020\u0019J\u001a\u0010 \u001a\u00020\u00192\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00190\"R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Les/gbr/aeris/viewmodel/LocalizacionesViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_ciudadesFiltradas", "Landroidx/lifecycle/MutableLiveData;", "", "Les/gbr/aeris/model/database/relations/CiudadConTiempoActual;", "ciudadesFiltradas", "Landroidx/lifecycle/LiveData;", "getCiudadesFiltradas", "()Landroidx/lifecycle/LiveData;", "ciudadesVisiblesActuales", "", "", "repository", "Les/gbr/aeris/model/repository/WeatherRepository;", "textoBusquedaActual", "", "todasLasCiudadesDB", "getTodasLasCiudadesDB", "weatherRepository", "Les/gbr/aeris/data/api/OpenWeatherRepository;", "actualizarCiudadesVisibles", "", "visibles", "actualizarListaFiltrada", "todasLasCiudades", "buscarCiudad", "texto", "refrescarCiudades", "sincronizarTodasLasCiudades", "onResultado", "Lkotlin/Function1;", "", "app_release"})
public final class LocalizacionesViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final es.gbr.aeris.model.repository.WeatherRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final es.gbr.aeris.data.api.OpenWeatherRepository weatherRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.relations.CiudadConTiempoActual>> todasLasCiudadesDB = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String textoBusquedaActual = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.Set<java.lang.Integer> ciudadesVisiblesActuales;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<es.gbr.aeris.model.database.relations.CiudadConTiempoActual>> _ciudadesFiltradas = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.relations.CiudadConTiempoActual>> ciudadesFiltradas = null;
    
    public LocalizacionesViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.relations.CiudadConTiempoActual>> getTodasLasCiudadesDB() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.relations.CiudadConTiempoActual>> getCiudadesFiltradas() {
        return null;
    }
    
    public final void actualizarListaFiltrada(@org.jetbrains.annotations.NotNull()
    java.util.List<es.gbr.aeris.model.database.relations.CiudadConTiempoActual> todasLasCiudades) {
    }
    
    public final void buscarCiudad(@org.jetbrains.annotations.NotNull()
    java.lang.String texto) {
    }
    
    public final void actualizarCiudadesVisibles(@org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.Integer> visibles) {
    }
    
    public final void refrescarCiudades() {
    }
    
    public final void sincronizarTodasLasCiudades(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onResultado) {
    }
}