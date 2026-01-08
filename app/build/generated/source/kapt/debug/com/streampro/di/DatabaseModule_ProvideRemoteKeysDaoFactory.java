package com.streampro.di;

import com.streampro.data.local.AppDatabase;
import com.streampro.data.local.RemoteKeysDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DatabaseModule_ProvideRemoteKeysDaoFactory implements Factory<RemoteKeysDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideRemoteKeysDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public RemoteKeysDao get() {
    return provideRemoteKeysDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideRemoteKeysDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideRemoteKeysDaoFactory(databaseProvider);
  }

  public static RemoteKeysDao provideRemoteKeysDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideRemoteKeysDao(database));
  }
}
