package es.gbr.aeris.view.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Les/gbr/aeris/view/activities/LocalizacionesActivity;", "Landroidx/activity/ComponentActivity;", "()V", "modeloVista", "Les/gbr/aeris/viewmodel/LocalizacionesViewModel;", "getModeloVista", "()Les/gbr/aeris/viewmodel/LocalizacionesViewModel;", "modeloVista$delegate", "Lkotlin/Lazy;", "preferenciasRepository", "Les/gbr/aeris/data/preferences/PreferenciasRepository;", "temaOscuro", "", "usarFahrenheit", "usarMph", "configurarUI", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_release"})
public final class LocalizacionesActivity extends androidx.activity.ComponentActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy modeloVista$delegate = null;
    private es.gbr.aeris.data.preferences.PreferenciasRepository preferenciasRepository;
    private boolean usarFahrenheit = false;
    private boolean usarMph = false;
    private boolean temaOscuro = false;
    
    public LocalizacionesActivity() {
        super(0);
    }
    
    private final es.gbr.aeris.viewmodel.LocalizacionesViewModel getModeloVista() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void configurarUI() {
    }
}