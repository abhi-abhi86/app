package com.streampro.data.repository;

import com.streampro.data.api.ApiService;
import com.streampro.data.local.AppDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class MovieRepositoryImpl_Factory implements Factory<MovieRepositoryImpl> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<AppDatabase> databaseProvider;

  public MovieRepositoryImpl_Factory(Provider<ApiService> apiServiceProvider,
      Provider<AppDatabase> databaseProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.databaseProvider = databaseProvider;
  }

  @Override
  public MovieRepositoryImpl get() {
    return newInstance(apiServiceProvider.get(), databaseProvider.get());
  }

  public static MovieRepositoryImpl_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<AppDatabase> databaseProvider) {
    return new MovieRepositoryImpl_Factory(apiServiceProvider, databaseProvider);
  }

  public static MovieRepositoryImpl newInstance(ApiService apiService, AppDatabase database) {
    return new MovieRepositoryImpl(apiService, database);
  }
}
