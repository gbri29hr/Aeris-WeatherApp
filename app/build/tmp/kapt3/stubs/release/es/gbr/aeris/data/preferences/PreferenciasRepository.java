package es.gbr.aeris.data.preferences;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001:\u0001$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u001c\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017H\u0086@\u00a2\u0006\u0002\u0010\u0018J.\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010 J\u0016\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010 J\u000e\u0010#\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006%"}, d2 = {"Les/gbr/aeris/data/preferences/PreferenciasRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "preferenciasFlow", "Lkotlinx/coroutines/flow/Flow;", "Les/gbr/aeris/data/preferences/UserPreferences;", "getPreferenciasFlow", "()Lkotlinx/coroutines/flow/Flow;", "actualizarUltimaSincronizacion", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anadirCiudadVisible", "idCiudad", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "eliminarCiudadVisible", "esCiudadVisible", "", "guardarCiudadPorDefecto", "guardarCiudadesVisibles", "ciudades", "", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "guardarPreferencias", "usarFahrenheit", "usarMph", "temaOscuro", "idCiudadDefecto", "(ZZZILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "guardarTemaOscuro", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "guardarUsarFahrenheit", "guardarUsarMph", "limpiarPreferencias", "PreferencesKeys", "app_release"})
public final class PreferenciasRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<es.gbr.aeris.data.preferences.UserPreferences> preferenciasFlow = null;
    
    public PreferenciasRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<es.gbr.aeris.data.preferences.UserPreferences> getPreferenciasFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object guardarUsarFahrenheit(boolean usarFahrenheit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object guardarUsarMph(boolean usarMph, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object guardarTemaOscuro(boolean temaOscuro, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object guardarCiudadPorDefecto(int idCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object guardarCiudadesVisibles(@org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.Integer> ciudades, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object anadirCiudadVisible(int idCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object eliminarCiudadVisible(int idCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object esCiudadVisible(int idCiudad, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object actualizarUltimaSincronizacion(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object guardarPreferencias(boolean usarFahrenheit, boolean usarMph, boolean temaOscuro, int idCiudadDefecto, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object limpiarPreferencias(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007\u00a8\u0006\u0015"}, d2 = {"Les/gbr/aeris/data/preferences/PreferenciasRepository$PreferencesKeys;", "", "()V", "CIUDADES_VISIBLES", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getCIUDADES_VISIBLES", "()Landroidx/datastore/preferences/core/Preferences$Key;", "ID_CIUDAD_DEFECTO", "", "getID_CIUDAD_DEFECTO", "TEMA_OSCURO", "", "getTEMA_OSCURO", "ULTIMA_SINCRONIZACION", "", "getULTIMA_SINCRONIZACION", "USAR_FAHRENHEIT", "getUSAR_FAHRENHEIT", "USAR_MPH", "getUSAR_MPH", "app_release"})
    static final class PreferencesKeys {
        @org.jetbrains.annotations.NotNull()
        private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> USAR_FAHRENHEIT = null;
        @org.jetbrains.annotations.NotNull()
        private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> USAR_MPH = null;
        @org.jetbrains.annotations.NotNull()
        private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> TEMA_OSCURO = null;
        @org.jetbrains.annotations.NotNull()
        private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Integer> ID_CIUDAD_DEFECTO = null;
        @org.jetbrains.annotations.NotNull()
        private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> CIUDADES_VISIBLES = null;
        @org.jetbrains.annotations.NotNull()
        private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Long> ULTIMA_SINCRONIZACION = null;
        @org.jetbrains.annotations.NotNull()
        public static final es.gbr.aeris.data.preferences.PreferenciasRepository.PreferencesKeys INSTANCE = null;
        
        private PreferencesKeys() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> getUSAR_FAHRENHEIT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> getUSAR_MPH() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> getTEMA_OSCURO() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.datastore.preferences.core.Preferences.Key<java.lang.Integer> getID_CIUDAD_DEFECTO() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> getCIUDADES_VISIBLES() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.datastore.preferences.core.Preferences.Key<java.lang.Long> getULTIMA_SINCRONIZACION() {
            return null;
        }
    }
}