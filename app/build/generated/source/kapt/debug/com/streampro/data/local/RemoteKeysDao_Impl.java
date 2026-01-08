package com.streampro.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class RemoteKeysDao_Impl implements RemoteKeysDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RemoteKeys> __insertionAdapterOfRemoteKeys;

  private final SharedSQLiteStatement __preparedStmtOfClearRemoteKeys;

  public RemoteKeysDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRemoteKeys = new EntityInsertionAdapter<RemoteKeys>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `remote_keys` (`movieId`,`prevKey`,`nextKey`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final RemoteKeys entity) {
        if (entity.getMovieId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getMovieId());
        }
        if (entity.getPrevKey() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getPrevKey());
        }
        if (entity.getNextKey() == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, entity.getNextKey());
        }
      }
    };
    this.__preparedStmtOfClearRemoteKeys = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM remote_keys";
        return _query;
      }
    };
  }

  @Override
  public Object insertAll(final List<RemoteKeys> remoteKey,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRemoteKeys.insert(remoteKey);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clearRemoteKeys(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearRemoteKeys.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfClearRemoteKeys.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object remoteKeysMovieId(final String movieId,
      final Continuation<? super RemoteKeys> $completion) {
    final String _sql = "SELECT * FROM remote_keys WHERE movieId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (movieId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, movieId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<RemoteKeys>() {
      @Override
      @Nullable
      public RemoteKeys call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMovieId = CursorUtil.getColumnIndexOrThrow(_cursor, "movieId");
          final int _cursorIndexOfPrevKey = CursorUtil.getColumnIndexOrThrow(_cursor, "prevKey");
          final int _cursorIndexOfNextKey = CursorUtil.getColumnIndexOrThrow(_cursor, "nextKey");
          final RemoteKeys _result;
          if (_cursor.moveToFirst()) {
            final String _tmpMovieId;
            if (_cursor.isNull(_cursorIndexOfMovieId)) {
              _tmpMovieId = null;
            } else {
              _tmpMovieId = _cursor.getString(_cursorIndexOfMovieId);
            }
            final Integer _tmpPrevKey;
            if (_cursor.isNull(_cursorIndexOfPrevKey)) {
              _tmpPrevKey = null;
            } else {
              _tmpPrevKey = _cursor.getInt(_cursorIndexOfPrevKey);
            }
            final Integer _tmpNextKey;
            if (_cursor.isNull(_cursorIndexOfNextKey)) {
              _tmpNextKey = null;
            } else {
              _tmpNextKey = _cursor.getInt(_cursorIndexOfNextKey);
            }
            _result = new RemoteKeys(_tmpMovieId,_tmpPrevKey,_tmpNextKey);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
