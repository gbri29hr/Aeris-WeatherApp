package es.gbr.aeris.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0005H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fH\u0086@\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0005H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020#J\u0016\u0010%\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020#R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Les/gbr/aeris/model/DatosCompartidos;", "", "()V", "_idCiudadSeleccionadaFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "value", "idCiudadSeleccionada", "getIdCiudadSeleccionada", "()I", "setIdCiudadSeleccionada", "(I)V", "idCiudadSeleccionadaFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getIdCiudadSeleccionadaFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "preferenciasRepository", "Les/gbr/aeris/data/preferences/PreferenciasRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "cargarCiudadSeleccionada", "", "esCiudadVisible", "", "idCiudad", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inicializar", "context", "Landroid/content/Context;", "mostrarCiudad", "obtenerCiudadesVisibles", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ocultarCiudad", "traducirDescripcion", "", "descripcion", "traducirDia", "dia", "app_release"})
public final class DatosCompartidos {
    @org.jetbrains.annotations.Nullable()
    private static es.gbr.aeris.data.preferences.PreferenciasRepository preferenciasRepository;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _idCiudadSeleccionadaFlow = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> idCiudadSeleccionadaFlow = null;
    @org.jetbrains.annotations.NotNull()
    public static final es.gbr.aeris.model.DatosCompartidos INSTANCE = null;
    
    private DatosCompartidos() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getIdCiudadSeleccionadaFlow() {
        return null;
    }
    
    public final void inicializar(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final int getIdCiudadSeleccionada() {
        return 0;
    }
    
    public final void setIdCiudadSeleccionada(int value) {
    }
    
    public final void cargarCiudadSeleccionada() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object obtenerCiudadesVisibles(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.Set<java.lang.Integer>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object esCiudadVisible(int idCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object ocultarCiudad(int idCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object mostrarCiudad(int idCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String traducirDescripcion(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String descripcion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String traducirDia(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String dia) {
        return null;
    }
}