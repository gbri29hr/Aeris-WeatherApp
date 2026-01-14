package es.gbr.aeris.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\rJ \u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\rJ \u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Les/gbr/aeris/data/api/OpenWeatherClient;", "", "()V", "API_KEY", "", "BASE_URL", "httpClient", "Lio/ktor/client/HttpClient;", "obtenerClimaActual", "Les/gbr/aeris/data/api/OpenWeatherCurrentResponse;", "lat", "", "lon", "(DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "obtenerIndiceUV", "Les/gbr/aeris/data/api/OpenWeatherUVResponse;", "obtenerPrediccion5Dias", "Les/gbr/aeris/data/api/OpenWeatherForecastResponse;", "app_release"})
public final class OpenWeatherClient {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String API_KEY = "4e88640396039f0acbb94d6eced7a88c";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "https://api.openweathermap.org/data/2.5";
    @org.jetbrains.annotations.NotNull()
    private static final io.ktor.client.HttpClient httpClient = null;
    @org.jetbrains.annotations.NotNull()
    public static final es.gbr.aeris.data.api.OpenWeatherClient INSTANCE = null;
    
    private OpenWeatherClient() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object obtenerClimaActual(double lat, double lon, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super es.gbr.aeris.data.api.OpenWeatherCurrentResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object obtenerPrediccion5Dias(double lat, double lon, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super es.gbr.aeris.data.api.OpenWeatherForecastResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object obtenerIndiceUV(double lat, double lon, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super es.gbr.aeris.data.api.OpenWeatherUVResponse> $completion) {
        return null;
    }
}