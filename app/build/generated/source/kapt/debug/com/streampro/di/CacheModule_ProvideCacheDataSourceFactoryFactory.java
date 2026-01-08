package com.streampro.di;

import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.cache.SimpleCache;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class CacheModule_ProvideCacheDataSourceFactoryFactory implements Factory<CacheDataSource.Factory> {
  private final Provider<SimpleCache> simpleCacheProvider;

  public CacheModule_ProvideCacheDataSourceFactoryFactory(
      Provider<SimpleCache> simpleCacheProvider) {
    this.simpleCacheProvider = simpleCacheProvider;
  }

  @Override
  public CacheDataSource.Factory get() {
    return provideCacheDataSourceFactory(simpleCacheProvider.get());
  }

  public static CacheModule_ProvideCacheDataSourceFactoryFactory create(
      Provider<SimpleCache> simpleCacheProvider) {
    return new CacheModule_ProvideCacheDataSourceFactoryFactory(simpleCacheProvider);
  }

  public static CacheDataSource.Factory provideCacheDataSourceFactory(SimpleCache simpleCache) {
    return Preconditions.checkNotNullFromProvides(CacheModule.INSTANCE.provideCacheDataSourceFactory(simpleCache));
  }
}
