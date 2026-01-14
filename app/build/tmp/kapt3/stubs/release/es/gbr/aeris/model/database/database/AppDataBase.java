package es.gbr.aeris.model.database.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u0000 \u00052\u00020\u0001:\u0002\u0005\u0006B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Les/gbr/aeris/model/database/database/AppDataBase;", "Landroidx/room/RoomDatabase;", "()V", "weatherDao", "Les/gbr/aeris/model/database/dao/WeatherDao;", "Companion", "DatabaseCallback", "app_release"})
@androidx.room.Database(entities = {es.gbr.aeris.model.database.entities.CiudadEntidad.class, es.gbr.aeris.model.database.entities.TiempoActualEntidad.class, es.gbr.aeris.model.database.entities.PrediccionHorasEntidad.class, es.gbr.aeris.model.database.entities.PrediccionDiariaEntidad.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile es.gbr.aeris.model.database.database.AppDataBase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final es.gbr.aeris.model.database.database.AppDataBase.Companion Companion = null;
    
    public AppDataBase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract es.gbr.aeris.model.database.dao.WeatherDao weatherDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Les/gbr/aeris/model/database/database/AppDataBase$Companion;", "", "()V", "INSTANCE", "Les/gbr/aeris/model/database/database/AppDataBase;", "obtenerBaseDeDatos", "context", "Landroid/content/Context;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final es.gbr.aeris.model.database.database.AppDataBase obtenerBaseDeDatos(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Les/gbr/aeris/model/database/database/AppDataBase$DatabaseCallback;", "Landroidx/room/RoomDatabase$Callback;", "()V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "populateDatabase", "weatherDao", "Les/gbr/aeris/model/database/dao/WeatherDao;", "(Les/gbr/aeris/model/database/dao/WeatherDao;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
    static final class DatabaseCallback extends androidx.room.RoomDatabase.Callback {
        
        public DatabaseCallback() {
            super();
        }
        
        @java.lang.Override()
        public void onCreate(@org.jetbrains.annotations.NotNull()
        androidx.sqlite.db.SupportSQLiteDatabase db) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object populateDatabase(@org.jetbrains.annotations.NotNull()
        es.gbr.aeris.model.database.dao.WeatherDao weatherDao, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
    }
}