package es.gbr.aeris.data.api;

@kotlinx.serialization.Serializable()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000256BY\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0002\u0010\u0013BG\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0014J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010#\u001a\u00020\nH\u00c6\u0003J\t\u0010$\u001a\u00020\fH\u00c6\u0003J\t\u0010%\u001a\u00020\u000eH\u00c6\u0003J\t\u0010&\u001a\u00020\u0010H\u00c6\u0003JK\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u00c6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\u0003H\u00d6\u0001J\t\u0010,\u001a\u00020\u000eH\u00d6\u0001J&\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u00c1\u0001\u00a2\u0006\u0002\b4R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u00067"}, d2 = {"Les/gbr/aeris/data/api/OpenWeatherCurrentResponse;", "", "seen1", "", "coord", "Les/gbr/aeris/data/api/OpenWeatherCoord;", "weather", "", "Les/gbr/aeris/data/api/OpenWeatherWeather;", "main", "Les/gbr/aeris/data/api/OpenWeatherMain;", "wind", "Les/gbr/aeris/data/api/OpenWeatherWind;", "name", "", "dt", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILes/gbr/aeris/data/api/OpenWeatherCoord;Ljava/util/List;Les/gbr/aeris/data/api/OpenWeatherMain;Les/gbr/aeris/data/api/OpenWeatherWind;Ljava/lang/String;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Les/gbr/aeris/data/api/OpenWeatherCoord;Ljava/util/List;Les/gbr/aeris/data/api/OpenWeatherMain;Les/gbr/aeris/data/api/OpenWeatherWind;Ljava/lang/String;J)V", "getCoord", "()Les/gbr/aeris/data/api/OpenWeatherCoord;", "getDt", "()J", "getMain", "()Les/gbr/aeris/data/api/OpenWeatherMain;", "getName", "()Ljava/lang/String;", "getWeather", "()Ljava/util/List;", "getWind", "()Les/gbr/aeris/data/api/OpenWeatherWind;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"})
public final class OpenWeatherCurrentResponse {
    @org.jetbrains.annotations.NotNull()
    private final es.gbr.aeris.data.api.OpenWeatherCoord coord = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<es.gbr.aeris.data.api.OpenWeatherWeather> weather = null;
    @org.jetbrains.annotations.NotNull()
    private final es.gbr.aeris.data.api.OpenWeatherMain main = null;
    @org.jetbrains.annotations.NotNull()
    private final es.gbr.aeris.data.api.OpenWeatherWind wind = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    private final long dt = 0L;
    @org.jetbrains.annotations.NotNull()
    public static final es.gbr.aeris.data.api.OpenWeatherCurrentResponse.Companion Companion = null;
    
    public OpenWeatherCurrentResponse(@org.jetbrains.annotations.NotNull()
    es.gbr.aeris.data.api.OpenWeatherCoord coord, @org.jetbrains.annotations.NotNull()
    java.util.List<es.gbr.aeris.data.api.OpenWeatherWeather> weather, @org.jetbrains.annotations.NotNull()
    es.gbr.aeris.data.api.OpenWeatherMain main, @org.jetbrains.annotations.NotNull()
    es.gbr.aeris.data.api.OpenWeatherWind wind, @org.jetbrains.annotations.NotNull()
    java.lang.String name, long dt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final es.gbr.aeris.data.api.OpenWeatherCoord getCoord() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<es.gbr.aeris.data.api.OpenWeatherWeather> getWeather() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final es.gbr.aeris.data.api.OpenWeatherMain getMain() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final es.gbr.aeris.data.api.OpenWeatherWind getWind() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final long getDt() {
        return 0L;
    }
    
    public OpenWeatherCurrentResponse() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final es.gbr.aeris.data.api.OpenWeatherCoord component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<es.gbr.aeris.data.api.OpenWeatherWeather> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final es.gbr.aeris.data.api.OpenWeatherMain component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final es.gbr.aeris.data.api.OpenWeatherWind component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    public final long component6() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final es.gbr.aeris.data.api.OpenWeatherCurrentResponse copy(@org.jetbrains.annotations.NotNull()
    es.gbr.aeris.data.api.OpenWeatherCoord coord, @org.jetbrains.annotations.NotNull()
    java.util.List<es.gbr.aeris.data.api.OpenWeatherWeather> weather, @org.jetbrains.annotations.NotNull()
    es.gbr.aeris.data.api.OpenWeatherMain main, @org.jetbrains.annotations.NotNull()
    es.gbr.aeris.data.api.OpenWeatherWind wind, @org.jetbrains.annotations.NotNull()
    java.lang.String name, long dt) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmStatic()
    public static final void write$Self$app_release(@org.jetbrains.annotations.NotNull()
    es.gbr.aeris.data.api.OpenWeatherCurrentResponse self, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.encoding.CompositeEncoder output, @org.jetbrains.annotations.NotNull()
    kotlinx.serialization.descriptors.SerialDescriptor serialDesc) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u00d6\u0001\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"es/gbr/aeris/data/api/OpenWeatherCurrentResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Les/gbr/aeris/data/api/OpenWeatherCurrentResponse;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_release"})
    @java.lang.Deprecated()
    public static final class $serializer implements kotlinx.serialization.internal.GeneratedSerializer<es.gbr.aeris.data.api.OpenWeatherCurrentResponse> {
        @org.jetbrains.annotations.NotNull()
        public static final es.gbr.aeris.data.api.OpenWeatherCurrentResponse.$serializer INSTANCE = null;
        
        private $serializer() {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.KSerializer<?>[] childSerializers() {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public es.gbr.aeris.data.api.OpenWeatherCurrentResponse deserialize(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.encoding.Decoder decoder) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.descriptors.SerialDescriptor getDescriptor() {
            return null;
        }
        
        @java.lang.Override()
        public void serialize(@org.jetbrains.annotations.NotNull()
        kotlinx.serialization.encoding.Encoder encoder, @org.jetbrains.annotations.NotNull()
        es.gbr.aeris.data.api.OpenWeatherCurrentResponse value) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public kotlinx.serialization.KSerializer<?>[] typeParametersSerializers() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Les/gbr/aeris/data/api/OpenWeatherCurrentResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Les/gbr/aeris/data/api/OpenWeatherCurrentResponse;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.serialization.KSerializer<es.gbr.aeris.data.api.OpenWeatherCurrentResponse> serializer() {
            return null;
        }
    }
}