package es.gbr.aeris.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007J\u001c\u0010%\u001a\u00020#2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020#0\'R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00100\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00100\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000eR\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Les/gbr/aeris/viewmodel/MainViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_idCiudadSeleccionada", "Landroidx/lifecycle/MutableLiveData;", "", "_refrescandoManual", "", "kotlin.jvm.PlatformType", "idCiudadSeleccionada", "Landroidx/lifecycle/LiveData;", "getIdCiudadSeleccionada", "()Landroidx/lifecycle/LiveData;", "prediccionDiaria", "", "Les/gbr/aeris/model/database/entities/PrediccionDiariaEntidad;", "getPrediccionDiaria", "prediccionHoras", "Les/gbr/aeris/model/database/entities/PrediccionHorasEntidad;", "getPrediccionHoras", "refrescandoManual", "getRefrescandoManual", "repository", "Les/gbr/aeris/model/repository/WeatherRepository;", "tiempoActual", "Les/gbr/aeris/model/database/entities/TiempoActualEntidad;", "getTiempoActual", "todasLasCiudades", "Les/gbr/aeris/model/database/entities/CiudadEntidad;", "getTodasLasCiudades", "weatherRepository", "Les/gbr/aeris/data/api/OpenWeatherRepository;", "cambiarCiudadSeleccionada", "", "nuevoIdCiudad", "sincronizarCiudadActual", "onResultado", "Lkotlin/Function1;", "app_release"})
public final class MainViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final es.gbr.aeris.model.repository.WeatherRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final es.gbr.aeris.data.api.OpenWeatherRepository weatherRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.entities.CiudadEntidad>> todasLasCiudades = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _idCiudadSeleccionada = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> idCiudadSeleccionada = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _refrescandoManual = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> refrescandoManual = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<es.gbr.aeris.model.database.entities.TiempoActualEntidad> tiempoActual = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.entities.PrediccionHorasEntidad>> prediccionHoras = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.entities.PrediccionDiariaEntidad>> prediccionDiaria = null;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.entities.CiudadEntidad>> getTodasLasCiudades() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getIdCiudadSeleccionada() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getRefrescandoManual() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<es.gbr.aeris.model.database.entities.TiempoActualEntidad> getTiempoActual() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.entities.PrediccionHorasEntidad>> getPrediccionHoras() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<es.gbr.aeris.model.database.entities.PrediccionDiariaEntidad>> getPrediccionDiaria() {
        return null;
    }
    
    public final void cambiarCiudadSeleccionada(int nuevoIdCiudad) {
    }
    
    public final void sincronizarCiudadActual(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onResultado) {
    }
}