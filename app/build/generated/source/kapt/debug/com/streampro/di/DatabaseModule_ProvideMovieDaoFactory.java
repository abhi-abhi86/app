package com.streampro.di;

import com.streampro.data.local.AppDatabase;
import com.streampro.data.local.MovieDao;
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
public final class DatabaseModule_ProvideMovieDaoFactory implements Factory<MovieDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideMovieDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public MovieDao get() {
    return provideMovieDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideMovieDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideMovieDaoFactory(databaseProvider);
  }

  public static MovieDao provideMovieDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideMovieDao(database));
  }
}
