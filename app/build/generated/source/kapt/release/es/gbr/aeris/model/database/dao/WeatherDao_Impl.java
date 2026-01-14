package es.gbr.aeris.model.database.dao;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import es.gbr.aeris.model.database.entities.CiudadEntidad;
import es.gbr.aeris.model.database.entities.PrediccionDiariaEntidad;
import es.gbr.aeris.model.database.entities.PrediccionHorasEntidad;
import es.gbr.aeris.model.database.entities.TiempoActualEntidad;
import es.gbr.aeris.model.database.relations.CiudadConTiempoActual;
import java.lang.Class;
import java.lang.Long;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class WeatherDao_Impl implements WeatherDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<CiudadEntidad> __insertAdapterOfCiudadEntidad;

  private final EntityInsertAdapter<TiempoActualEntidad> __insertAdapterOfTiempoActualEntidad;

  private final EntityInsertAdapter<PrediccionHorasEntidad> __insertAdapterOfPrediccionHorasEntidad;

  private final EntityInsertAdapter<PrediccionDiariaEntidad> __insertAdapterOfPrediccionDiariaEntidad;

  public WeatherDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfCiudadEntidad = new EntityInsertAdapter<CiudadEntidad>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `ciudades` (`id_ciudad`,`nombre`,`latitud`,`longitud`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final CiudadEntidad entity) {
        statement.bindLong(1, entity.getIdCiudad());
        if (entity.getNombre() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getNombre());
        }
        statement.bindDouble(3, entity.getLatitud());
        statement.bindDouble(4, entity.getLongitud());
      }
    };
    this.__insertAdapterOfTiempoActualEntidad = new EntityInsertAdapter<TiempoActualEntidad>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `tiempo_actual` (`id_tiempo`,`id_ciudad_fk`,`temperatura`,`descripcion`,`codigo_icono`,`temp_alta`,`temp_baja`,`humedad`,`viento_velocidad`,`uv_indice`,`precipitacion`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final TiempoActualEntidad entity) {
        statement.bindLong(1, entity.getIdTiempo());
        statement.bindLong(2, entity.getIdCiudadFk());
        statement.bindDouble(3, entity.getTemperatura());
        if (entity.getDescripcion() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getDescripcion());
        }
        if (entity.getCodigoIcono() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getCodigoIcono());
        }
        statement.bindDouble(6, entity.getTempAlta());
        statement.bindDouble(7, entity.getTempBaja());
        statement.bindDouble(8, entity.getHumedad());
        statement.bindDouble(9, entity.getVientoVelocidad());
        statement.bindDouble(10, entity.getUvIndice());
        statement.bindLong(11, entity.getPrecipitacion());
      }
    };
    this.__insertAdapterOfPrediccionHorasEntidad = new EntityInsertAdapter<PrediccionHorasEntidad>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `prediccion_hora` (`id_hora`,`id_ciudad_fk`,`hora`,`temperatura`,`codigo_icono`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final PrediccionHorasEntidad entity) {
        statement.bindLong(1, entity.getIdHora());
        statement.bindLong(2, entity.getIdCiudadFk());
        if (entity.getHora() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getHora());
        }
        statement.bindDouble(4, entity.getTemperatura());
        if (entity.getCodigoIcono() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getCodigoIcono());
        }
      }
    };
    this.__insertAdapterOfPrediccionDiariaEntidad = new EntityInsertAdapter<PrediccionDiariaEntidad>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `prediccion_dia` (`id_dia`,`id_ciudad_fk`,`nombre_dia`,`temp_alta`,`temp_baja`,`codigo_icono`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final PrediccionDiariaEntidad entity) {
        statement.bindLong(1, entity.getIdDia());
        statement.bindLong(2, entity.getIdCiudadFk());
        if (entity.getNombreDia() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getNombreDia());
        }
        statement.bindDouble(4, entity.getTempAlta());
        statement.bindDouble(5, entity.getTempBaja());
        if (entity.getCodigoIcono() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getCodigoIcono());
        }
      }
    };
  }

  @Override
  public Object insertarCiudad(final CiudadEntidad ciudad,
      final Continuation<? super Long> $completion) {
    if (ciudad == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      return __insertAdapterOfCiudadEntidad.insertAndReturnId(_connection, ciudad);
    }, $completion);
  }

  @Override
  public Object insertarTiempoActual(final TiempoActualEntidad tiempo,
      final Continuation<? super Unit> $completion) {
    if (tiempo == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfTiempoActualEntidad.insert(_connection, tiempo);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object insertarListaHoras(final List<PrediccionHorasEntidad> listaHoras,
      final Continuation<? super Unit> $completion) {
    if (listaHoras == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfPrediccionHorasEntidad.insert(_connection, listaHoras);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object insertarListaDias(final List<PrediccionDiariaEntidad> listaDias,
      final Continuation<? super Unit> $completion) {
    if (listaDias == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfPrediccionDiariaEntidad.insert(_connection, listaDias);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public LiveData<List<CiudadEntidad>> obtenerTodasLasCiudades() {
    final String _sql = "SELECT * FROM ciudades";
    return __db.getInvalidationTracker().createLiveData(new String[] {"ciudades"}, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfIdCiudad = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id_ciudad");
        final int _columnIndexOfNombre = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "nombre");
        final int _columnIndexOfLatitud = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "latitud");
        final int _columnIndexOfLongitud = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "longitud");
        final List<CiudadEntidad> _result = new ArrayList<CiudadEntidad>();
        while (_stmt.step()) {
          final CiudadEntidad _item;
          final int _tmpIdCiudad;
          _tmpIdCiudad = (int) (_stmt.getLong(_columnIndexOfIdCiudad));
          final String _tmpNombre;
          if (_stmt.isNull(_columnIndexOfNombre)) {
            _tmpNombre = null;
          } else {
            _tmpNombre = _stmt.getText(_columnIndexOfNombre);
          }
          final double _tmpLatitud;
          _tmpLatitud = _stmt.getDouble(_columnIndexOfLatitud);
          final double _tmpLongitud;
          _tmpLongitud = _stmt.getDouble(_columnIndexOfLongitud);
          _item = new CiudadEntidad(_tmpIdCiudad,_tmpNombre,_tmpLatitud,_tmpLongitud);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public LiveData<TiempoActualEntidad> obtenerTiempoActual(final int idCiudad) {
    final String _sql = "SELECT * FROM tiempo_actual WHERE id_ciudad_fk = ?";
    return __db.getInvalidationTracker().createLiveData(new String[] {"tiempo_actual"}, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, idCiudad);
        final int _columnIndexOfIdTiempo = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id_tiempo");
        final int _columnIndexOfIdCiudadFk = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id_ciudad_fk");
        final int _columnIndexOfTemperatura = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "temperatura");
        final int _columnIndexOfDescripcion = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "descripcion");
        final int _columnIndexOfCodigoIcono = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "codigo_icono");
        final int _columnIndexOfTempAlta = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "temp_alta");
        final int _columnIndexOfTempBaja = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "temp_baja");
        final int _columnIndexOfHumedad = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "humedad");
        final int _columnIndexOfVientoVelocidad = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "viento_velocidad");
        final int _columnIndexOfUvIndice = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "uv_indice");
        final int _columnIndexOfPrecipitacion = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "precipitacion");
        final TiempoActualEntidad _result;
        if (_stmt.step()) {
          final int _tmpIdTiempo;
          _tmpIdTiempo = (int) (_stmt.getLong(_columnIndexOfIdTiempo));
          final int _tmpIdCiudadFk;
          _tmpIdCiudadFk = (int) (_stmt.getLong(_columnIndexOfIdCiudadFk));
          final double _tmpTemperatura;
          _tmpTemperatura = _stmt.getDouble(_columnIndexOfTemperatura);
          final String _tmpDescripcion;
          if (_stmt.isNull(_columnIndexOfDescripcion)) {
            _tmpDescripcion = null;
          } else {
            _tmpDescripcion = _stmt.getText(_columnIndexOfDescripcion);
          }
          final String _tmpCodigoIcono;
          if (_stmt.isNull(_columnIndexOfCodigoIcono)) {
            _tmpCodigoIcono = null;
          } else {
            _tmpCodigoIcono = _stmt.getText(_columnIndexOfCodigoIcono);
          }
          final double _tmpTempAlta;
          _tmpTempAlta = _stmt.getDouble(_columnIndexOfTempAlta);
          final double _tmpTempBaja;
          _tmpTempBaja = _stmt.getDouble(_columnIndexOfTempBaja);
          final double _tmpHumedad;
          _tmpHumedad = _stmt.getDouble(_columnIndexOfHumedad);
          final double _tmpVientoVelocidad;
          _tmpVientoVelocidad = _stmt.getDouble(_columnIndexOfVientoVelocidad);
          final double _tmpUvIndice;
          _tmpUvIndice = _stmt.getDouble(_columnIndexOfUvIndice);
          final int _tmpPrecipitacion;
          _tmpPrecipitacion = (int) (_stmt.getLong(_columnIndexOfPrecipitacion));
          _result = new TiempoActualEntidad(_tmpIdTiempo,_tmpIdCiudadFk,_tmpTemperatura,_tmpDescripcion,_tmpCodigoIcono,_tmpTempAlta,_tmpTempBaja,_tmpHumedad,_tmpVientoVelocidad,_tmpUvIndice,_tmpPrecipitacion);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public LiveData<List<PrediccionHorasEntidad>> obtenerPrediccionHoras(final int idCiudad) {
    final String _sql = "SELECT * FROM prediccion_hora WHERE id_ciudad_fk = ? ORDER BY id_hora ASC";
    return __db.getInvalidationTracker().createLiveData(new String[] {"prediccion_hora"}, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, idCiudad);
        final int _columnIndexOfIdHora = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id_hora");
        final int _columnIndexOfIdCiudadFk = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id_ciudad_fk");
        final int _columnIndexOfHora = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hora");
        final int _columnIndexOfTemperatura = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "temperatura");
        final int _columnIndexOfCodigoIcono = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "codigo_icono");
        final List<PrediccionHorasEntidad> _result = new ArrayList<PrediccionHorasEntidad>();
        while (_stmt.step()) {
          final PrediccionHorasEntidad _item;
          final int _tmpIdHora;
          _tmpIdHora = (int) (_stmt.getLong(_columnIndexOfIdHora));
          final int _tmpIdCiudadFk;
          _tmpIdCiudadFk = (int) (_stmt.getLong(_columnIndexOfIdCiudadFk));
          final String _tmpHora;
          if (_stmt.isNull(_columnIndexOfHora)) {
            _tmpHora = null;
          } else {
            _tmpHora = _stmt.getText(_columnIndexOfHora);
          }
          final double _tmpTemperatura;
          _tmpTemperatura = _stmt.getDouble(_columnIndexOfTemperatura);
          final String _tmpCodigoIcono;
          if (_stmt.isNull(_columnIndexOfCodigoIcono)) {
            _tmpCodigoIcono = null;
          } else {
            _tmpCodigoIcono = _stmt.getText(_columnIndexOfCodigoIcono);
          }
          _item = new PrediccionHorasEntidad(_tmpIdHora,_tmpIdCiudadFk,_tmpHora,_tmpTemperatura,_tmpCodigoIcono);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public LiveData<List<PrediccionDiariaEntidad>> obtenerPrediccionDiaria(final int idCiudad) {
    final String _sql = "SELECT * FROM prediccion_dia WHERE id_ciudad_fk = ? ORDER BY id_dia ASC";
    return __db.getInvalidationTracker().createLiveData(new String[] {"prediccion_dia"}, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, idCiudad);
        final int _columnIndexOfIdDia = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id_dia");
        final int _columnIndexOfIdCiudadFk = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id_ciudad_fk");
        final int _columnIndexOfNombreDia = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "nombre_dia");
        final int _columnIndexOfTempAlta = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "temp_alta");
        final int _columnIndexOfTempBaja = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "temp_baja");
        final int _columnIndexOfCodigoIcono = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "codigo_icono");
        final List<PrediccionDiariaEntidad> _result = new ArrayList<PrediccionDiariaEntidad>();
        while (_stmt.step()) {
          final PrediccionDiariaEntidad _item;
          final int _tmpIdDia;
          _tmpIdDia = (int) (_stmt.getLong(_columnIndexOfIdDia));
          final int _tmpIdCiudadFk;
          _tmpIdCiudadFk = (int) (_stmt.getLong(_columnIndexOfIdCiudadFk));
          final String _tmpNombreDia;
          if (_stmt.isNull(_columnIndexOfNombreDia)) {
            _tmpNombreDia = null;
          } else {
            _tmpNombreDia = _stmt.getText(_columnIndexOfNombreDia);
          }
          final double _tmpTempAlta;
          _tmpTempAlta = _stmt.getDouble(_columnIndexOfTempAlta);
          final double _tmpTempBaja;
          _tmpTempBaja = _stmt.getDouble(_columnIndexOfTempBaja);
          final String _tmpCodigoIcono;
          if (_stmt.isNull(_columnIndexOfCodigoIcono)) {
            _tmpCodigoIcono = null;
          } else {
            _tmpCodigoIcono = _stmt.getText(_columnIndexOfCodigoIcono);
          }
          _item = new PrediccionDiariaEntidad(_tmpIdDia,_tmpIdCiudadFk,_tmpNombreDia,_tmpTempAlta,_tmpTempBaja,_tmpCodigoIcono);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Object buscarCiudadPorNombre(final String nombre,
      final Continuation<? super CiudadEntidad> $completion) {
    final String _sql = "SELECT * FROM ciudades WHERE nombre = ? LIMIT 1";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (nombre == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, nombre);
        }
        final int _columnIndexOfIdCiudad = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id_ciudad");
        final int _columnIndexOfNombre = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "nombre");
        final int _columnIndexOfLatitud = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "latitud");
        final int _columnIndexOfLongitud = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "longitud");
        final CiudadEntidad _result;
        if (_stmt.step()) {
          final int _tmpIdCiudad;
          _tmpIdCiudad = (int) (_stmt.getLong(_columnIndexOfIdCiudad));
          final String _tmpNombre;
          if (_stmt.isNull(_columnIndexOfNombre)) {
            _tmpNombre = null;
          } else {
            _tmpNombre = _stmt.getText(_columnIndexOfNombre);
          }
          final double _tmpLatitud;
          _tmpLatitud = _stmt.getDouble(_columnIndexOfLatitud);
          final double _tmpLongitud;
          _tmpLongitud = _stmt.getDouble(_columnIndexOfLongitud);
          _result = new CiudadEntidad(_tmpIdCiudad,_tmpNombre,_tmpLatitud,_tmpLongitud);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object obtenerCiudadPorId(final int idCiudad,
      final Continuation<? super CiudadEntidad> $completion) {
    final String _sql = "SELECT * FROM ciudades WHERE id_ciudad = ? LIMIT 1";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, idCiudad);
        final int _columnIndexOfIdCiudad = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id_ciudad");
        final int _columnIndexOfNombre = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "nombre");
        final int _columnIndexOfLatitud = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "latitud");
        final int _columnIndexOfLongitud = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "longitud");
        final CiudadEntidad _result;
        if (_stmt.step()) {
          final int _tmpIdCiudad;
          _tmpIdCiudad = (int) (_stmt.getLong(_columnIndexOfIdCiudad));
          final String _tmpNombre;
          if (_stmt.isNull(_columnIndexOfNombre)) {
            _tmpNombre = null;
          } else {
            _tmpNombre = _stmt.getText(_columnIndexOfNombre);
          }
          final double _tmpLatitud;
          _tmpLatitud = _stmt.getDouble(_columnIndexOfLatitud);
          final double _tmpLongitud;
          _tmpLongitud = _stmt.getDouble(_columnIndexOfLongitud);
          _result = new CiudadEntidad(_tmpIdCiudad,_tmpNombre,_tmpLatitud,_tmpLongitud);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public LiveData<List<CiudadConTiempoActual>> obtenerCiudadesConTiempoActual() {
    final String _sql = "SELECT * FROM ciudades ORDER BY id_ciudad";
    return __db.getInvalidationTracker().createLiveData(new String[] {"tiempo_actual",
        "ciudades"}, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfIdCiudad = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id_ciudad");
        final int _columnIndexOfNombre = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "nombre");
        final int _columnIndexOfLatitud = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "latitud");
        final int _columnIndexOfLongitud = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "longitud");
        final LongSparseArray<TiempoActualEntidad> _collectionTiempoActual = new LongSparseArray<TiempoActualEntidad>();
        while (_stmt.step()) {
          final long _tmpKey;
          _tmpKey = _stmt.getLong(_columnIndexOfIdCiudad);
          _collectionTiempoActual.put(_tmpKey, null);
        }
        _stmt.reset();
        __fetchRelationshiptiempoActualAsesGbrAerisModelDatabaseEntitiesTiempoActualEntidad(_connection, _collectionTiempoActual);
        final List<CiudadConTiempoActual> _result = new ArrayList<CiudadConTiempoActual>();
        while (_stmt.step()) {
          final CiudadConTiempoActual _item;
          final CiudadEntidad _tmpCiudad;
          final int _tmpIdCiudad;
          _tmpIdCiudad = (int) (_stmt.getLong(_columnIndexOfIdCiudad));
          final String _tmpNombre;
          if (_stmt.isNull(_columnIndexOfNombre)) {
            _tmpNombre = null;
          } else {
            _tmpNombre = _stmt.getText(_columnIndexOfNombre);
          }
          final double _tmpLatitud;
          _tmpLatitud = _stmt.getDouble(_columnIndexOfLatitud);
          final double _tmpLongitud;
          _tmpLongitud = _stmt.getDouble(_columnIndexOfLongitud);
          _tmpCiudad = new CiudadEntidad(_tmpIdCiudad,_tmpNombre,_tmpLatitud,_tmpLongitud);
          final TiempoActualEntidad _tmpTiempoActual;
          final long _tmpKey_1;
          _tmpKey_1 = _stmt.getLong(_columnIndexOfIdCiudad);
          _tmpTiempoActual = _collectionTiempoActual.get(_tmpKey_1);
          _item = new CiudadConTiempoActual(_tmpCiudad,_tmpTiempoActual);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Object actualizarCoordenadasCiudad(final int idCiudad, final double latitud,
      final double longitud, final Continuation<? super Unit> $completion) {
    final String _sql = "UPDATE ciudades SET latitud = ?, longitud = ? WHERE id_ciudad = ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindDouble(_argIndex, latitud);
        _argIndex = 2;
        _stmt.bindDouble(_argIndex, longitud);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, idCiudad);
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object eliminarHorasPorCiudad(final int idCiudad,
      final Continuation<? super Unit> $completion) {
    final String _sql = "DELETE FROM prediccion_hora WHERE id_ciudad_fk = ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, idCiudad);
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object eliminarDiasPorCiudad(final int idCiudad,
      final Continuation<? super Unit> $completion) {
    final String _sql = "DELETE FROM prediccion_dia WHERE id_ciudad_fk = ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, idCiudad);
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object eliminarCiudadPorId(final int idCiudad,
      final Continuation<? super Unit> $completion) {
    final String _sql = "DELETE FROM ciudades WHERE id_ciudad = ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, idCiudad);
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object eliminarCiudadesDuplicadas(final Continuation<? super Unit> $completion) {
    final String _sql = "\n"
            + "        DELETE FROM ciudades \n"
            + "        WHERE id_ciudad NOT IN (\n"
            + "            SELECT MIN(id_ciudad) FROM ciudades GROUP BY nombre\n"
            + "        )\n"
            + "    ";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshiptiempoActualAsesGbrAerisModelDatabaseEntitiesTiempoActualEntidad(
      @NonNull final SQLiteConnection _connection,
      @NonNull final LongSparseArray<TiempoActualEntidad> _map) {
    if (_map.isEmpty()) {
      return;
    }
    if (_map.size() > 999) {
      RelationUtil.recursiveFetchLongSparseArray(_map, false, (_tmpMap) -> {
        __fetchRelationshiptiempoActualAsesGbrAerisModelDatabaseEntitiesTiempoActualEntidad(_connection, _tmpMap);
        return Unit.INSTANCE;
      });
      return;
    }
    final StringBuilder _stringBuilder = new StringBuilder();
    _stringBuilder.append("SELECT `id_tiempo`,`id_ciudad_fk`,`temperatura`,`descripcion`,`codigo_icono`,`temp_alta`,`temp_baja`,`humedad`,`viento_velocidad`,`uv_indice`,`precipitacion` FROM `tiempo_actual` WHERE `id_ciudad_fk` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final SQLiteStatement _stmt = _connection.prepare(_sql);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      final long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex++;
    }
    try {
      final int _itemKeyIndex = SQLiteStatementUtil.getColumnIndex(_stmt, "id_ciudad_fk");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _columnIndexOfIdTiempo = 0;
      final int _columnIndexOfIdCiudadFk = 1;
      final int _columnIndexOfTemperatura = 2;
      final int _columnIndexOfDescripcion = 3;
      final int _columnIndexOfCodigoIcono = 4;
      final int _columnIndexOfTempAlta = 5;
      final int _columnIndexOfTempBaja = 6;
      final int _columnIndexOfHumedad = 7;
      final int _columnIndexOfVientoVelocidad = 8;
      final int _columnIndexOfUvIndice = 9;
      final int _columnIndexOfPrecipitacion = 10;
      while (_stmt.step()) {
        final long _tmpKey;
        _tmpKey = _stmt.getLong(_itemKeyIndex);
        if (_map.containsKey(_tmpKey)) {
          final TiempoActualEntidad _item_1;
          final int _tmpIdTiempo;
          _tmpIdTiempo = (int) (_stmt.getLong(_columnIndexOfIdTiempo));
          final int _tmpIdCiudadFk;
          _tmpIdCiudadFk = (int) (_stmt.getLong(_columnIndexOfIdCiudadFk));
          final double _tmpTemperatura;
          _tmpTemperatura = _stmt.getDouble(_columnIndexOfTemperatura);
          final String _tmpDescripcion;
          if (_stmt.isNull(_columnIndexOfDescripcion)) {
            _tmpDescripcion = null;
          } else {
            _tmpDescripcion = _stmt.getText(_columnIndexOfDescripcion);
          }
          final String _tmpCodigoIcono;
          if (_stmt.isNull(_columnIndexOfCodigoIcono)) {
            _tmpCodigoIcono = null;
          } else {
            _tmpCodigoIcono = _stmt.getText(_columnIndexOfCodigoIcono);
          }
          final double _tmpTempAlta;
          _tmpTempAlta = _stmt.getDouble(_columnIndexOfTempAlta);
          final double _tmpTempBaja;
          _tmpTempBaja = _stmt.getDouble(_columnIndexOfTempBaja);
          final double _tmpHumedad;
          _tmpHumedad = _stmt.getDouble(_columnIndexOfHumedad);
          final double _tmpVientoVelocidad;
          _tmpVientoVelocidad = _stmt.getDouble(_columnIndexOfVientoVelocidad);
          final double _tmpUvIndice;
          _tmpUvIndice = _stmt.getDouble(_columnIndexOfUvIndice);
          final int _tmpPrecipitacion;
          _tmpPrecipitacion = (int) (_stmt.getLong(_columnIndexOfPrecipitacion));
          _item_1 = new TiempoActualEntidad(_tmpIdTiempo,_tmpIdCiudadFk,_tmpTemperatura,_tmpDescripcion,_tmpCodigoIcono,_tmpTempAlta,_tmpTempBaja,_tmpHumedad,_tmpVientoVelocidad,_tmpUvIndice,_tmpPrecipitacion);
          _map.put(_tmpKey, _item_1);
        }
      }
    } finally {
      _stmt.close();
    }
  }
}
