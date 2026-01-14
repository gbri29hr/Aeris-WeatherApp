package es.gbr.aeris.model.database.database;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import es.gbr.aeris.model.database.dao.WeatherDao;
import es.gbr.aeris.model.database.dao.WeatherDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class AppDataBase_Impl extends AppDataBase {
  private volatile WeatherDao _weatherDao;

  @Override
  @NonNull
  protected RoomOpenDelegate createOpenDelegate() {
    final RoomOpenDelegate _openDelegate = new RoomOpenDelegate(1, "79866ddfe921fc7a991f0efe0eddb8db", "374401ba9a3fe16554a5e48e4f2366ca") {
      @Override
      public void createAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `ciudades` (`id_ciudad` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT NOT NULL, `latitud` REAL NOT NULL, `longitud` REAL NOT NULL)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `tiempo_actual` (`id_tiempo` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id_ciudad_fk` INTEGER NOT NULL, `temperatura` REAL NOT NULL, `descripcion` TEXT NOT NULL, `codigo_icono` TEXT NOT NULL, `temp_alta` REAL NOT NULL, `temp_baja` REAL NOT NULL, `humedad` REAL NOT NULL, `viento_velocidad` REAL NOT NULL, `uv_indice` REAL NOT NULL, `precipitacion` INTEGER NOT NULL, FOREIGN KEY(`id_ciudad_fk`) REFERENCES `ciudades`(`id_ciudad`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_tiempo_actual_id_ciudad_fk` ON `tiempo_actual` (`id_ciudad_fk`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `prediccion_hora` (`id_hora` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id_ciudad_fk` INTEGER NOT NULL, `hora` TEXT NOT NULL, `temperatura` REAL NOT NULL, `codigo_icono` TEXT NOT NULL, FOREIGN KEY(`id_ciudad_fk`) REFERENCES `ciudades`(`id_ciudad`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_prediccion_hora_id_ciudad_fk` ON `prediccion_hora` (`id_ciudad_fk`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `prediccion_dia` (`id_dia` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id_ciudad_fk` INTEGER NOT NULL, `nombre_dia` TEXT NOT NULL, `temp_alta` REAL NOT NULL, `temp_baja` REAL NOT NULL, `codigo_icono` TEXT NOT NULL, FOREIGN KEY(`id_ciudad_fk`) REFERENCES `ciudades`(`id_ciudad`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_prediccion_dia_id_ciudad_fk` ON `prediccion_dia` (`id_ciudad_fk`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '79866ddfe921fc7a991f0efe0eddb8db')");
      }

      @Override
      public void dropAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `ciudades`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `tiempo_actual`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `prediccion_hora`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `prediccion_dia`");
      }

      @Override
      public void onCreate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      public void onOpen(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(connection);
      }

      @Override
      public void onPreMigrate(@NonNull final SQLiteConnection connection) {
        DBUtil.dropFtsSyncTriggers(connection);
      }

      @Override
      public void onPostMigrate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      @NonNull
      public RoomOpenDelegate.ValidationResult onValidateSchema(
          @NonNull final SQLiteConnection connection) {
        final Map<String, TableInfo.Column> _columnsCiudades = new HashMap<String, TableInfo.Column>(4);
        _columnsCiudades.put("id_ciudad", new TableInfo.Column("id_ciudad", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCiudades.put("nombre", new TableInfo.Column("nombre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCiudades.put("latitud", new TableInfo.Column("latitud", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCiudades.put("longitud", new TableInfo.Column("longitud", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysCiudades = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesCiudades = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCiudades = new TableInfo("ciudades", _columnsCiudades, _foreignKeysCiudades, _indicesCiudades);
        final TableInfo _existingCiudades = TableInfo.read(connection, "ciudades");
        if (!_infoCiudades.equals(_existingCiudades)) {
          return new RoomOpenDelegate.ValidationResult(false, "ciudades(es.gbr.aeris.model.database.entities.CiudadEntidad).\n"
                  + " Expected:\n" + _infoCiudades + "\n"
                  + " Found:\n" + _existingCiudades);
        }
        final Map<String, TableInfo.Column> _columnsTiempoActual = new HashMap<String, TableInfo.Column>(11);
        _columnsTiempoActual.put("id_tiempo", new TableInfo.Column("id_tiempo", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiempoActual.put("id_ciudad_fk", new TableInfo.Column("id_ciudad_fk", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiempoActual.put("temperatura", new TableInfo.Column("temperatura", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiempoActual.put("descripcion", new TableInfo.Column("descripcion", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiempoActual.put("codigo_icono", new TableInfo.Column("codigo_icono", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiempoActual.put("temp_alta", new TableInfo.Column("temp_alta", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiempoActual.put("temp_baja", new TableInfo.Column("temp_baja", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiempoActual.put("humedad", new TableInfo.Column("humedad", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiempoActual.put("viento_velocidad", new TableInfo.Column("viento_velocidad", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiempoActual.put("uv_indice", new TableInfo.Column("uv_indice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTiempoActual.put("precipitacion", new TableInfo.Column("precipitacion", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysTiempoActual = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysTiempoActual.add(new TableInfo.ForeignKey("ciudades", "CASCADE", "NO ACTION", Arrays.asList("id_ciudad_fk"), Arrays.asList("id_ciudad")));
        final Set<TableInfo.Index> _indicesTiempoActual = new HashSet<TableInfo.Index>(1);
        _indicesTiempoActual.add(new TableInfo.Index("index_tiempo_actual_id_ciudad_fk", true, Arrays.asList("id_ciudad_fk"), Arrays.asList("ASC")));
        final TableInfo _infoTiempoActual = new TableInfo("tiempo_actual", _columnsTiempoActual, _foreignKeysTiempoActual, _indicesTiempoActual);
        final TableInfo _existingTiempoActual = TableInfo.read(connection, "tiempo_actual");
        if (!_infoTiempoActual.equals(_existingTiempoActual)) {
          return new RoomOpenDelegate.ValidationResult(false, "tiempo_actual(es.gbr.aeris.model.database.entities.TiempoActualEntidad).\n"
                  + " Expected:\n" + _infoTiempoActual + "\n"
                  + " Found:\n" + _existingTiempoActual);
        }
        final Map<String, TableInfo.Column> _columnsPrediccionHora = new HashMap<String, TableInfo.Column>(5);
        _columnsPrediccionHora.put("id_hora", new TableInfo.Column("id_hora", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrediccionHora.put("id_ciudad_fk", new TableInfo.Column("id_ciudad_fk", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrediccionHora.put("hora", new TableInfo.Column("hora", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrediccionHora.put("temperatura", new TableInfo.Column("temperatura", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrediccionHora.put("codigo_icono", new TableInfo.Column("codigo_icono", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysPrediccionHora = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysPrediccionHora.add(new TableInfo.ForeignKey("ciudades", "CASCADE", "NO ACTION", Arrays.asList("id_ciudad_fk"), Arrays.asList("id_ciudad")));
        final Set<TableInfo.Index> _indicesPrediccionHora = new HashSet<TableInfo.Index>(1);
        _indicesPrediccionHora.add(new TableInfo.Index("index_prediccion_hora_id_ciudad_fk", false, Arrays.asList("id_ciudad_fk"), Arrays.asList("ASC")));
        final TableInfo _infoPrediccionHora = new TableInfo("prediccion_hora", _columnsPrediccionHora, _foreignKeysPrediccionHora, _indicesPrediccionHora);
        final TableInfo _existingPrediccionHora = TableInfo.read(connection, "prediccion_hora");
        if (!_infoPrediccionHora.equals(_existingPrediccionHora)) {
          return new RoomOpenDelegate.ValidationResult(false, "prediccion_hora(es.gbr.aeris.model.database.entities.PrediccionHorasEntidad).\n"
                  + " Expected:\n" + _infoPrediccionHora + "\n"
                  + " Found:\n" + _existingPrediccionHora);
        }
        final Map<String, TableInfo.Column> _columnsPrediccionDia = new HashMap<String, TableInfo.Column>(6);
        _columnsPrediccionDia.put("id_dia", new TableInfo.Column("id_dia", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrediccionDia.put("id_ciudad_fk", new TableInfo.Column("id_ciudad_fk", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrediccionDia.put("nombre_dia", new TableInfo.Column("nombre_dia", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrediccionDia.put("temp_alta", new TableInfo.Column("temp_alta", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrediccionDia.put("temp_baja", new TableInfo.Column("temp_baja", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrediccionDia.put("codigo_icono", new TableInfo.Column("codigo_icono", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysPrediccionDia = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysPrediccionDia.add(new TableInfo.ForeignKey("ciudades", "CASCADE", "NO ACTION", Arrays.asList("id_ciudad_fk"), Arrays.asList("id_ciudad")));
        final Set<TableInfo.Index> _indicesPrediccionDia = new HashSet<TableInfo.Index>(1);
        _indicesPrediccionDia.add(new TableInfo.Index("index_prediccion_dia_id_ciudad_fk", false, Arrays.asList("id_ciudad_fk"), Arrays.asList("ASC")));
        final TableInfo _infoPrediccionDia = new TableInfo("prediccion_dia", _columnsPrediccionDia, _foreignKeysPrediccionDia, _indicesPrediccionDia);
        final TableInfo _existingPrediccionDia = TableInfo.read(connection, "prediccion_dia");
        if (!_infoPrediccionDia.equals(_existingPrediccionDia)) {
          return new RoomOpenDelegate.ValidationResult(false, "prediccion_dia(es.gbr.aeris.model.database.entities.PrediccionDiariaEntidad).\n"
                  + " Expected:\n" + _infoPrediccionDia + "\n"
                  + " Found:\n" + _existingPrediccionDia);
        }
        return new RoomOpenDelegate.ValidationResult(true, null);
      }
    };
    return _openDelegate;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final Map<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final Map<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "ciudades", "tiempo_actual", "prediccion_hora", "prediccion_dia");
  }

  @Override
  public void clearAllTables() {
    super.performClear(true, "ciudades", "tiempo_actual", "prediccion_hora", "prediccion_dia");
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final Map<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(WeatherDao.class, WeatherDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final Set<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public WeatherDao weatherDao() {
    if (_weatherDao != null) {
      return _weatherDao;
    } else {
      synchronized(this) {
        if(_weatherDao == null) {
          _weatherDao = new WeatherDao_Impl(this);
        }
        return _weatherDao;
      }
    }
  }
}
